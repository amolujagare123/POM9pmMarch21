package DBTesting.clients;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.client.AddClient;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static utilities.ConfigReader.*;
import static utilities.Conversion.*;
import static utilities.DataProviderUtil.readAndGetSheet;
import static utilities.Driver.DriverType.CHROME;
import static utilities.Driver.getMyDriver;

public class AddClientTestDBTestingCountry {
    WebDriver driver;

    @BeforeClass
    public void doLogin() throws IOException {

        driver = getMyDriver(CHROME);
        driver.get(getUrl());
        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }

    @Test (dataProvider = "getData")
    public void addClientTest(String  name,String surname,String language,
                              String add1,String add2,String city,String state,String zip,
                              String country,String gender,String bdate,
                              String phone,String fax,String mobile,String email,
                              String web,String vat,String tax) throws ClassNotFoundException, SQLException, ParseException {

        ArrayList<String> expected = new ArrayList<>();




        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);


        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setlanguage(language);
        addClient.setClientAdd1(add1);
        addClient.setClientAdd2(add2);
        addClient.setClientCity(city);
        addClient.setclientstate(state);
        addClient.setclientzip(zip);
        String shortCountry = addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthDate(bdate);
        addClient.setclientphone(phone);
        addClient.setClientFaxno(fax);
        addClient.setClientMobno(mobile);
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientVatid(vat);
        addClient.setClienttaxcode(tax);

        addClient.clickSave();




        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase()); // English --> english
        expected.add(add1);
        expected.add(add2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(shortCountry);
        expected.add(gender);
        expected.add(bdate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);


        // JDBC - JAVA DABASE CONNECTIVITY
        // 4 steps og jdbc

        // 1. loading a driver.
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. creating a connection
        String user ="root";
        String password ="root";
        String url = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(url,user,password);

        // 3. creating a statement
        Statement st = con.createStatement();

        // 4. execute query

        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs =  st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));


            actual.add(rs.getString("client_country")); // make change in expected


            actual.add(genderFull(rs.getString("client_gender")));


            actual.add(convertDate(rs.getString("client_birthdate")));


            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("expected / excel ="+expected);

        System.out.println("actual / DB ="+actual);

         Assert.assertEquals(actual,expected,"some fields are not match");

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return  readAndGetSheet("Data/MyData.xlsx","dbTesting");
    }
}

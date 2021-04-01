package regression.Clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.client.AddClient;

import java.io.IOException;

import static utilities.ConfigReader.*;
import static utilities.DataProviderUtil.readAndGetSheet;
import static utilities.Driver.DriverType.CHROME;
import static utilities.Driver.getMyDriver;

public class AddClientTestDataProvider {
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
                              String web,String vat,String tax,String expected,String xpathActual)
    {
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
        addClient.setCountry(country);
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

        String actual ="";

        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"wrong message");

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return  readAndGetSheet("Data/MyData.xlsx","addclient");
    }
}

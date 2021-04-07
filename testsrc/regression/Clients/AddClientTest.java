package regression.Clients;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.client.AddClient;
import util.DoLogin;

import java.io.IOException;

import static utilities.ConfigReader.*;
import static utilities.Driver.DriverType.CHROME;
import static utilities.Driver.DriverType.FIREFOX;
import static utilities.Driver.getMyDriver;

public class AddClientTest extends DoLogin {


    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);


        addClient.setClientName("Rohith123");
        addClient.setClientSurname("borra");
        addClient.setlanguage("Thai");
        addClient.setClientAdd1("xyz");
        addClient.setClientAdd2("pqr");
        addClient.setClientCity("Pune");
        addClient.setclientstate("MH");
        addClient.setclientzip("898989");
        addClient.setCountry("Kenya");
        addClient.setGender("Other");
        addClient.setBirthDate("05/12/1980");
        addClient.setclientphone("987878");
        addClient.setClientFaxno("898989");
        addClient.setClientMobno("89889");
        addClient.setClientEmail("amol@gmail.com");
        addClient.setClientWeb("www.xyz.com");
        addClient.setClientVatid("8989");
        addClient.setClienttaxcode("898989");

        addClient.clickSave();
    }
}

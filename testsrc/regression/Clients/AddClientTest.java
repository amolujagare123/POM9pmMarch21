package regression.Clients;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.client.AddClient;

import java.io.IOException;

import static utilities.ConfigReader.*;
import static utilities.Driver.DriverType.CHROME;
import static utilities.Driver.DriverType.FIREFOX;
import static utilities.Driver.getMyDriver;

public class AddClientTest {
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

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setlanguage("Thai");

       /* addClient.setClientName("Rohith");
        addClient.setClientSurname("borra");
        addClient.setClientAdd1("xyz");
        addClient.setClientAdd2("pqr");
        addClient.setClientCity("Pune");
        addClient.clickSave();*/
    }
}

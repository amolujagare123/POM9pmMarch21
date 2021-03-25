package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import utilities.Driver;

import java.io.IOException;

import static utilities.ConfigReader.*;
import static utilities.Driver.DriverType.CHROME;
import static utilities.Driver.DriverType.FIREFOX;
import static utilities.Driver.getMyDriver;

public class LoginTest {

    @Test
    public void loginTest() throws IOException {

        WebDriver driver = getMyDriver(FIREFOX);

        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }

}

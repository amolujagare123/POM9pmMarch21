package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;

import java.io.IOException;

import static utilities.ConfigReader.getUrl;
import static utilities.Driver.DriverType.FIREFOX;
import static utilities.Driver.DriverType.OPERA;
import static utilities.Driver.getMyDriver;

public class ForgotPassTest {

    @Test
    public void forgotPassTest() throws IOException {

        WebDriver driver = getMyDriver(OPERA);

        driver.get(getUrl()); // http://ip2.scriptinglogic.net/

        Login login = new Login(driver);
        login.clickForgotPass();

        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setTxtEmail("amol@gmail.com");
        forgotPassword.clickReset();

    }

}

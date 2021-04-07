package regression;

import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import java.io.IOException;

import static utilities.ConfigReader.*;

public class LoginTest extends OpenUrl{

    @Test
    public void loginTest() throws IOException {

        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }

}

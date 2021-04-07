package UITesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import java.io.IOException;
import java.util.Locale;

import static utilities.ConfigReader.*;
import static utilities.Driver.DriverType.CHROME;
import static utilities.Driver.getMyDriver;

public class LoginTest extends OpenUrl {


    Login login;

    @BeforeClass
    public void initLogin() throws IOException {


        login = new Login(driver);

    }


    @Test
    public void txtUsernameVisibility()
    {
        boolean expected = true;
        boolean actual = false;
        try {

            actual = login.txtUser.isDisplayed(); // true / false
        }
        catch (Exception e)
        {
            
        }
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void txtUsernameEnability()
    {
        boolean expected = true;
        boolean actual = false;
        try {

            actual = login.txtUser.isEnabled(); // true / false
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void txtUsernameCheckWaterMark()
    {
        String expected = "Email";
        String actual ="";
        try {
            actual = login.txtUser.getAttribute("placeholder");
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"wrong watermark");

    }

    public void lblPasswordSpellCheck()
    {
        String expected ="Password";

        String actual = "";

        try {
            actual = login.lblpassword.getText();
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"wrong spelling");
    }

    @Test
    public void lblPasswordCheckFontSize()
    {
        String expected ="14px";
        String actual = "";

        try {
            actual = login.lblpassword.getCssValue("font-size");
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void lblPasswordCheckFontFamily()
    {
        String expected ="-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = "";

        try {
            actual = login.lblpassword.getCssValue("font-family");
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"");
    }

    //sans-serif

    @Test
    public void lblPasswordCheckFont()
    {
        String expected ="sans-serif";
        String fontFamily = "";

        try {
            fontFamily = login.lblpassword.getCssValue("font-family");
            System.out.println("actual="+fontFamily);
        }
        catch (Exception e)
        {

        }

        boolean result = fontFamily.contains(expected); // true / false

        Assert.assertTrue(result,"the actual family doesnot have the font:"+expected);

    }

    @Test
    public void btnLoginColorCheck()
    {
        String expected ="#2C8EDD";

        String actual ="";

        try {
            String rgbColor  = login.btnLogin.getCssValue("background-color");

                actual = Color.fromString(rgbColor).asHex().toUpperCase();

            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"wrong color");
    }
}

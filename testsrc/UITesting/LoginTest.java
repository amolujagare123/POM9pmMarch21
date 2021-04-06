package UITesting;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

import static utilities.ConfigReader.*;
import static utilities.Driver.DriverType.CHROME;
import static utilities.Driver.getMyDriver;

public class LoginTest {

    WebDriver driver;
    Login login;

    @BeforeClass
    public void openUrl() throws IOException {

        driver = getMyDriver(CHROME);
        driver.get(getUrl());
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
}

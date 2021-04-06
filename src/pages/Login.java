package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

   // WebElement txtUsername = driver.findElement(By.xpath("//input[@id='email']"));

    @FindBy (xpath = "//label[@for='password']")
    public WebElement lblpassword;

    @FindBy (xpath="//input[@id='email']")
    public WebElement txtUser;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement txtPassword;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement btnLogin;

    @FindBy (xpath="//a[normalize-space()='I forgot my password']")
    public  WebElement lnkForgotPass;

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setTxtUser(String username)
    {
        txtUser.sendKeys(username);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }

    public void clickForgotPass()
    {
        lnkForgotPass.click();
    }

}

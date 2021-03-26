package pages.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    @FindBy (xpath="//input[@id='client_surname']")
    WebElement clientSurname;

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement clientAdd1;

    @FindBy (xpath="//input[@id='client_address_2']")
    WebElement clientAdd2;

    @FindBy (xpath="//input[@id='client_city']")
    WebElement clientCity;

    @FindBy (xpath="//input[@id='client_state']")
    WebElement clientState;

    @FindBy (xpath="//input[@id='client_zip']")
    WebElement clientZip;


    @FindBy (xpath="//input[@id='client_phone']")
    WebElement clientPhone;

    @FindBy (xpath="//input[@id='client_fax']")
    WebElement clientFax;

    @FindBy (xpath="//input[@id='client_mobile']")
    WebElement clientMobile;

    @FindBy (xpath="//input[@id='client_email']")
    WebElement clientEmail;

    @FindBy (xpath="//input[@id='client_web']")
    WebElement clientWeb;

    @FindBy (xpath="//input[@id='client_vat_id']")
    WebElement clientVat;

    @FindBy (xpath="//input[@id='client_tax_code']")
    WebElement clientTax;

    @FindBy (xpath="//button[normalize-space()='Save']")
    WebElement btnSave;


    @FindBy (xpath="//span[@id='select2-client_language-container']")
    WebElement containerlanguage;
    @FindBy (xpath="//input[@role='searchbox']")
    WebElement searchBox;

    WebDriver driver;

    public void setlanguage(String language)
    {
        containerlanguage.click();
        searchBox.sendKeys(language); // we may skip this
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();
    }


    public AddClient(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void setClientName(String name)
    {
        clientName.sendKeys(name);
    }

    public void setClientSurname(String surname)
    {
        clientSurname.sendKeys(surname);
    }

    public void setClientAdd1(String add1)
    {
        clientAdd1.sendKeys(add1);
    }
    public void setClientAdd2(String add2)
    {
        clientAdd2.sendKeys(add2);
    }

    public  void setClientCity(String city)
    {
        clientCity.sendKeys(city);
    }

    public void clickSave()
    {
        btnSave.click();
    }
}

package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

   static WebDriver driver;

   public static enum DriverType{
        CHROME, FIREFOX, OPERA
    }
    public static WebDriver getMyDriver(DriverType d)
    {

        switch (d)
        {
            case CHROME: WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX: WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case OPERA: WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + d);
        }
        driver.manage().window().maximize();

        return  driver;
    }
}

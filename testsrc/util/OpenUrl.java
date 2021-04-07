package util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static utilities.ConfigReader.getUrl;
import static utilities.Driver.DriverType.CHROME;
import static utilities.Driver.DriverType.FIREFOX;
import static utilities.Driver.getMyDriver;

public class OpenUrl {
    public static WebDriver driver;
    @BeforeClass
    public void openUrl() throws IOException {
        driver = getMyDriver(CHROME);
        driver.get(getUrl());
    }

}

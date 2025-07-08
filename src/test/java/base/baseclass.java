package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class baseclass {
 protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();


@BeforeMethod

public void setUp() {
    WebDriver localDriver = new ChromeDriver();
    driver.set(localDriver);
    getDriver().manage().window().maximize();
	getDriver().get("https://www.amazon.com");
}

public WebDriver getDriver() {
    return driver.get();
}
@AfterMethod
public void tearDown() {
    if (driver != null) {
        getDriver().quit();
        driver.remove();
    }
}
}

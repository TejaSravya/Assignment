package utilities;

import org.openqa.selenium.WebDriver;
import java.lang.reflect.Method;
import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(String browser, boolean isRemote, String gridUrl, String platform, String version, Method method) {
        WebDriver webDriver = DriverFactory.createDriver(browser, isRemote, gridUrl, platform, version, method.getName());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

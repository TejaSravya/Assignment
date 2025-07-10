package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver(String browser, boolean isRemote, String gridUrl, String platform, String version, String testName) {
        WebDriver driver;

        if (isRemote) {
            try {
                Map<String, Object> ltOptions = new HashMap<>();
                ltOptions.put("username", System.getProperty("LT_USERNAME"));
                ltOptions.put("accessKey", System.getProperty("LT_ACCESS_KEY"));
                ltOptions.put("project", "CrossBrowser Parallel Test");
                ltOptions.put("build", "Build-" + System.currentTimeMillis());
                ltOptions.put("name", testName);
                ltOptions.put("selenium_version", "4.14.0");

                switch (browser.toLowerCase()) {
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setPlatformName(platform);
                        firefoxOptions.setBrowserVersion(version);
                        firefoxOptions.setCapability("LT:Options", ltOptions);
                        driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                        break;

                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.setPlatformName(platform);
                        edgeOptions.setBrowserVersion(version);
                        edgeOptions.setCapability("LT:Options", ltOptions);
                        driver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
                        break;

                    case "chrome":
                    default:
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setPlatformName(platform);
                        chromeOptions.setBrowserVersion(version);
                        chromeOptions.setCapability("LT:Options", ltOptions);
                        driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                        break;
                }
                
            } catch (Exception e) {
                throw new RuntimeException("Failed to create remote WebDriver: " + e.getMessage(), e);
            }

        } else {
         
            switch (browser.toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "chrome":
                default:
                    driver = new ChromeDriver();
                    break;
            }
        }

        return driver;
    }
}

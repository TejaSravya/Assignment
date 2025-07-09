package base;


import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class baseclass {
	  public static final String USERNAME = System.getProperty("LT_USERNAME");
	    public static final String ACCESS_KEY = System.getProperty("LT_ACCESS_KEY");
	    public static final String GRID_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub.lambdatest.com/wd/hub";

 protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();



@Parameters({"browser", "version", "platform"})
@BeforeMethod(alwaysRun = true)
public void setUp(@Optional("Chrome") String browser,
                  @Optional("latest") String version,
                  @Optional("Windows 10") String platform,
                  Method method) {

   
    		 try {
    	            WebDriver remoteDriver;
    	            URL gridUrl = new URL(GRID_URL);

    	            // LambdaTest specific capabilities
    	            Map<String, Object> ltOptions = new HashMap<String, Object>();
    	            ltOptions.put("username", USERNAME);
    	            ltOptions.put("accessKey", ACCESS_KEY);
    	            ltOptions.put("build", "W3C-LambdaTest-Run");
    	            ltOptions.put("project", "CrossBrowser Test");
    	            ltOptions.put("name", method.getName());
    	            ltOptions.put("selenium_version", "4.14.0");
    	            ltOptions.put("build", "Run-" + System.currentTimeMillis());

    	            switch (browser.toLowerCase()) {
    	                case "firefox":
    	                    FirefoxOptions firefoxOptions = new FirefoxOptions();
    	                    firefoxOptions.setPlatformName(platform);
    	                    firefoxOptions.setBrowserVersion(version);
    	                    firefoxOptions.setCapability("LT:Options", ltOptions);
    	                    remoteDriver = new RemoteWebDriver(gridUrl, firefoxOptions);
    	                    break;

    	                case "edge":
    	                    EdgeOptions edgeOptions = new EdgeOptions();
    	                    edgeOptions.setPlatformName(platform);
    	                    edgeOptions.setBrowserVersion(version);
    	                    edgeOptions.setCapability("LT:Options", ltOptions);
    	                    remoteDriver = new RemoteWebDriver(gridUrl, edgeOptions);
    	                    break;

    	                case "chrome":
    	                default:
    	                    ChromeOptions chromeOptions = new ChromeOptions();
    	                    chromeOptions.setPlatformName(platform);
    	                    chromeOptions.setBrowserVersion(version);
    	                    chromeOptions.setCapability("LT:Options", ltOptions);
    	                    remoteDriver = new RemoteWebDriver(gridUrl, chromeOptions);
//    	                	remoteDriver=new ChromeDriver();
    	                    break;
    	            
    	            }
    	            driver.set(remoteDriver);
    	            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    		 } catch (Exception e) {
        throw new RuntimeException("Error initializing LambdaTest driver: " + e.getMessage(), e);
    }
}

public WebDriver getDriver() {
    return driver.get();
}
@AfterMethod
public void tearDown() {
	if (getDriver() != null) {
	    getDriver().quit();
	    driver.remove();;
	}
}
}

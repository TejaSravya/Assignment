package base;
import org.testng.annotations.*;
import utilities.DriverManager;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.Method;

public class baseclass {
    private final String GRID_URL = "https://" + System.getProperty("LT_USERNAME")
                                   + ":" +System.getProperty("LT_ACCESS_KEY") +
                                    "@hub.lambdatest.com/wd/hub";

    @Parameters({"browser", "runMode", "platform", "version"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser,
                      @Optional("remote") String runMode,
                      @Optional("Windows 10") String platform,
                      @Optional("latest") String version,
                      Method method) {

        boolean isRemote = runMode.equalsIgnoreCase("remote");
        DriverManager.initializeDriver(browser, isRemote, GRID_URL, platform, version, method);
    }

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
    
    

   
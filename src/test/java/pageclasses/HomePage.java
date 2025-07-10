package pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HomePage {
	 WebDriver driver;
	 private final String url = "https://www.amazon.com/";
	 public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 @FindBy(className="a-button-text")
	 private WebElement continueShopping;
	 
	 @FindBy(id="twotabsearchtextbox")
	 private WebElement searchTextBox;
	 
	 @FindBy(id="nav-search-submit-button")
	 private WebElement searchButton;
	 
	 public void open() {
		 
	        driver.get(url);
	        driver.manage().window().maximize();
	    }
	public void searchItem(String itemname) {	
		if (continueShopping.isDisplayed()) {
          continueShopping.click();
		} else {
		    System.out.println("Button is not visible, skipping click.");
		}
		searchTextBox.clear();
		searchTextBox.sendKeys(itemname);
		searchButton.click();
	}
	public WebElement waitForVisibility(WebElement element, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }
}

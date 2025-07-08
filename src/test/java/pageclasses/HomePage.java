package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 WebDriver driver;
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
	 
	 
	public void searchItem(String itemname) {
		continueShopping.click();
		searchTextBox.clear();
		searchTextBox.sendKeys(itemname);
		searchButton.click();
	}
}

package pageclasses;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

public class ItemSearchList {
	 WebDriver driver;
	
	public ItemSearchList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(@role,'listitem') and contains(@data-component-type,\"s-search-result\")][1]")
	private WebElement item;
	
	@FindBy(xpath="//button[@name='submit.addToCart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//span[@class='ewc-subtotal-amount']/h2")
	private WebElement price;
	@FindBy(xpath ="//a[@id='nav-cart']")
	private WebElement gotoCart;
	
	public void addProductToCart() {
		waitForClickabilitty(addToCart, 3);

		addToCart.click();
		
	}
	public void goToCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gotoCart);
		waitForClickabilitty(gotoCart, 10);
		js.executeScript("arguments[0].click();", gotoCart);
       gotoCart.click();
}
	public WebElement waitForClickabilitty(WebElement element, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
////div[contains(@role,'listitem') and contains(@data-component-type,"s-search-result")][1]//*contains(@data-cy="add-to-cart")
}

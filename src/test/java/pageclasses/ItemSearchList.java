package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(id="nav-cart")
	private WebElement gotoCart;
	
	public void addProductToCart() {
		addToCart.click();
		
	}
	public void goToCart() {
       gotoCart.click();
}
////div[contains(@role,'listitem') and contains(@data-component-type,"s-search-result")][1]//*contains(@data-cy="add-to-cart")
}

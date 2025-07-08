package CommonMethods;

import org.openqa.selenium.WebDriver;

import base.baseclass;
import pageclasses.CartPage;
import pageclasses.HomePage;
import pageclasses.ItemSearchList;

public class CommonMethods {
	WebDriver driver;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }
	public void searchProductandAddtoCart(String product) {
	HomePage home= new HomePage(driver);
	ItemSearchList item=new ItemSearchList(driver);
    CartPage cart=new CartPage(driver);
	home.searchItem(product);
	item.addProductToCart();
	item.goToCart();
	System.out.println("price is" +cart.retrivePrice());
}
}

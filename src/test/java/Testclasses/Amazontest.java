package Testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonMethods.CommonMethods;
import base.baseclass;
import pageclasses.CartPage;
import pageclasses.HomePage;
import pageclasses.ItemSearchList;

public class Amazontest extends baseclass{
@Test
public void searchiPhoneandAddtoCart() {
	CommonMethods actions=new CommonMethods(getDriver());
	   System.out.println("Running on thread: " + Thread.currentThread().getId());
	    System.out.println("Driver object: " + getDriver());
	String price = actions.searchProductandAddtoCart("iPhone");
	Assert.assertNotNull(price, "Price is null");
	
}
@Test
public void searchSamsungandAddtoCart() {
	CommonMethods actions=new CommonMethods(getDriver());
	 System.out.println("Running on thread: " + Thread.currentThread().getId());
	    System.out.println("Driver object: " + getDriver());
	    String price = actions.searchProductandAddtoCart("iPhone");
		Assert.assertNotNull(price, "Price is null");
	
}
//tejasravyan LT_dfJ3RUv3uJpJU9q7Q24zvY8MfB4m3ns1VUpDkzxN7GrgOzN

}

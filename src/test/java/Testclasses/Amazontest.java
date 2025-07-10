package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.baseclass;
import commonmethods.CommonMethods;


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
	    String price = actions.searchProductandAddtoCart("Samsung");
		Assert.assertNotNull(price, "Price is null");
	
}
}

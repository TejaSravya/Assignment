package Testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	actions.searchProductandAddtoCart("iPhone");
	
}
@Test
public void searchSamsungandAddtoCart() {
	CommonMethods actions=new CommonMethods(getDriver());
	actions.searchProductandAddtoCart("Samsung");
	
}
}

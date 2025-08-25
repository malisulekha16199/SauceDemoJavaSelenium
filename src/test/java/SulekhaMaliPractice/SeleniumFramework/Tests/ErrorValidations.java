package SulekhaMaliPractice.SeleniumFramework.Tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import SulekhaMaliPractice.SeleniumFramework.PageObjects.CartItemsPage;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.OrderDetailsPage;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.ProductsPage;
import SulekhaMaliPractice.SeleniumFramework.TestComponents.BaseTest;

public class ErrorValidations  extends BaseTest{

	@Test
	public void verifyInvalidLogin() throws InterruptedException, IOException  {
		String strUsername="standa_user";
		String strPassword="secret_sauce";
		String errorMsg="Epic sadface: Username and password do not match any user in this service";
		
		//LoginPage
		loginPg.LoginApplication(strUsername, strPassword);
		
		String ActualErrMsg=loginPg.getErrMsg();
		
		AssertJUnit.assertEquals(errorMsg, ActualErrMsg);
		
	}
	
	@Test
	public void verifyFillingAllDetails() throws InterruptedException, IOException  {

		String strUsername="standard_user";
		String strPassword="secret_sauce";
		String strProductname1="Sauce Labs Bolt T-Shirt";
		String strErrMsg="Error: First Name is required";
	
		
		//LoginPage
		ProductsPage prodPg=loginPg.LoginApplication(strUsername, strPassword);
		
		//ProductsPage
		prodPg.addToCartProduct(strProductname1);
		Thread.sleep(500);
		CartItemsPage cartItemPg= prodPg.goTocart();
		
		//CartItemPage
		WebElement eleCartItem=cartItemPg.verifyItemAddedToCart(strProductname1);
		Assert.assertNotNull(eleCartItem, "Product was not found in the cart!");
		OrderDetailsPage orderDetailsPg=cartItemPg.clickCheckout();
		
		//OrderDetailsPage
		orderDetailsPg.clickContinue();
		String ActualErrMsg=loginPg.getErrMsg();
		AssertJUnit.assertEquals(ActualErrMsg, strErrMsg);
		
	}
	
	
}

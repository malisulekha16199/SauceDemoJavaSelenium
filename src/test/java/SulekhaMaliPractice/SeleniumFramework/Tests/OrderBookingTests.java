package SulekhaMaliPractice.SeleniumFramework.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.CartItemsPage;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.OrderDetailsPage;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.ProductsPage;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.ThankYouPage;
import SulekhaMaliPractice.SeleniumFramework.TestComponents.BaseTest;

public class OrderBookingTests  extends BaseTest {

	@Test
	public void verifyMultipleOrderBooking() throws InterruptedException, IOException  {
		String strUsername="standard_user";
		String strPassword="secret_sauce";
		String strProductname1="Sauce Labs Bolt T-Shirt";
		String strProductname2="Sauce Labs Fleece Jacket";
		String strLastName="Mali";
		String strUserName="Sulekha";
		String strPin="421202";
	
		
		//LoginPage	
		ProductsPage prodPg=loginPg.LoginApplication(strUsername, strPassword);
		Thread.sleep(500);
		//ProductsPage
		prodPg.addToCartProduct(strProductname1);
		prodPg.addToCartProduct(strProductname2);
		CartItemsPage cartItemPg= prodPg.goTocart();
		Thread.sleep(500);
		
		//CartItemPage
		cartItemPg.verifyItemAddedToCart(strProductname1);
		cartItemPg.verifyItemAddedToCart(strProductname2);
		OrderDetailsPage orderDetailsPg=cartItemPg.clickCheckout();
		Thread.sleep(500);
		
		//OrderDetailsPage
		orderDetailsPg.enterOrderDetails(strUserName, strLastName, strPin);		
		orderDetailsPg.clickContinue();
		
		//finalCartpage
		cartItemPg.verifyItemAddedToCart(strProductname1);
		cartItemPg.verifyItemAddedToCart(strProductname2);
		ThankYouPage thnkYouMsg=cartItemPg.clickFinish();
		
		
		//ThankYouPage
		thnkYouMsg.VerifyThankYouMsg();
	
		
	}
	
	@Test
	public void verifyOrderBooking() throws InterruptedException, IOException  {
		String strUsername="standard_user";
		String strPassword="secret_sauce";
		String strProductname1="Sauce Labs Bolt T-Shirt";
		String strLastName="Mali";
		String strUserName="Sulekha";
		String strPin="421202";
	
		//LoginPage
		ProductsPage prodPg=loginPg.LoginApplication(strUsername, strPassword);
		Thread.sleep(500);
		
		//ProductsPage
		prodPg.addToCartProduct(strProductname1);
		CartItemsPage cartItemPg= prodPg.goTocart();
		Thread.sleep(500);
		
		//CartItemPage
		cartItemPg.verifyItemAddedToCart(strProductname1);
		OrderDetailsPage orderDetailsPg=cartItemPg.clickCheckout();
		
		//OrderDetailsPage
		orderDetailsPg.enterOrderDetails(strUserName, strLastName, strPin);		
		orderDetailsPg.clickContinue();
		
		//finalCartpage
		cartItemPg.verifyItemAddedToCart(strProductname1);
		ThankYouPage thnkYouMsg=cartItemPg.clickFinish();
			
		//ThankYouPage
		thnkYouMsg.VerifyThankYouMsg();
	
		
	}
	@Test
	public void verifyShoppingBadgeIconChange() throws IOException, InterruptedException {
		String strUsername="standard_user";
		String strPassword="secret_sauce";
		String strProductname1="Sauce Labs Bolt T-Shirt";
		String strProductname2="Sauce Labs Fleece Jacket";
		int intCount=2;
		//LoginPage
		ProductsPage prodPg=loginPg.LoginApplication(strUsername, strPassword);
		
		//ProductsPage
		prodPg.addToCartProduct(strProductname1);
		prodPg.addToCartProduct(strProductname2);
		Thread.sleep(500);
		int intActualCount=Integer.parseInt(prodPg.getIconBadgeCount());
		
		AssertJUnit.assertEquals(intActualCount, intCount);
	
	}
}

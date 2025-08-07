package SulekhaMaliPractice.SeleniumFramework;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.CartItemsPage;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.LoginPage;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.OrderDetailsPage;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.ProductsPage;
import SulekhaMaliPractice.SeleniumFramework.PageObjects.ThankYouPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
	
	@Test
	public void verifyMultipleOrderBooking() throws InterruptedException  {
		String strURL="https://www.saucedemo.com/";
		String strUsername="standard_user";
		String strPassword="secret_sauce";
		String strProductname1="Sauce Labs Bolt T-Shirt";
		String strProductname2="Sauce Labs Fleece Jacket";
		String strLastName="Mali";
		String strUserName="Sulekha";
		String strPin="421202";
	
		//Initialize driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Goto URL
		driver.get(strURL);
		
		//LoginPage
		LoginPage loginPg=new LoginPage(driver);
		ProductsPage prodPg=loginPg.LoginApplication(strUsername, strPassword);
		Thread.sleep(2000);
		//ProductsPage
		prodPg.addToCartProduct(strProductname1);
		prodPg.addToCartProduct(strProductname2);
		CartItemsPage cartItemPg= prodPg.goTocart();
		Thread.sleep(2000);
		
		//CartItemPage
		cartItemPg.verifyItemAddedToCart(strProductname1);
		cartItemPg.verifyItemAddedToCart(strProductname2);
		OrderDetailsPage orderDetailsPg=cartItemPg.clickCheckout();
		
		
		//OrderDetailsPage
		orderDetailsPg.enterOrderDetails(strUserName, strLastName, strPin);		
		orderDetailsPg.clickContinue();
		
		//finalCartpage
		cartItemPg.verifyItemAddedToCart(strProductname1);
		cartItemPg.verifyItemAddedToCart(strProductname2);
		ThankYouPage thnkYouMsg=cartItemPg.clickFinish();
		
		
		//ThankYouPage
		thnkYouMsg.VerifyThankYouMsg();
	
		
		//InitialiserPage
		driver.close();
		
	}

}
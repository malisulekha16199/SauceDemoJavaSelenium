package SulekhaMaliPractice.SeleniumFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SulekhaMaliPractice.SeleniumFramework.AbstractComponents.AbstractComponent;

public class ProductsPage extends AbstractComponent{
	WebDriver driver;
	
	@FindBy(xpath="//*[@data-test='inventory-item-name']")
	List<WebElement> eleProducts;
	
	@FindBy(className="shopping_cart_link")
	WebElement eleCartIcon;
	
	@FindBy(className="shopping_cart_link")
	WebElement eleShoppingBadgeIcon;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProduct(String strProductName) {
		waitForWebElementToAppear(eleProducts);
		WebElement eleProduct=eleProducts.stream().filter(prod->prod.getText().equals(strProductName)).findFirst().orElse(null);
		return eleProduct;
		
	}
	public void addToCartProduct(String strProductName) {
		WebElement eleProduct=getProduct(strProductName);
		eleProduct.findElement(By.xpath(".//parent::a/parent::div//following-sibling::div[@class='pricebar']//button")).click();
	}
	
	public CartItemsPage goTocart() {
		eleCartIcon.click();
		return new CartItemsPage(driver);
	}
	
	public String getIconBadgeCount() {
		waitForWebElementToAppear(eleShoppingBadgeIcon);
		String strCount=eleShoppingBadgeIcon.getText();
		return strCount;
		
		
	}
}

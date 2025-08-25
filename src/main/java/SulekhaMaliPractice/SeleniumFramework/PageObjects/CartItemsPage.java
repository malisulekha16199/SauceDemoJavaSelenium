package SulekhaMaliPractice.SeleniumFramework.PageObjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SulekhaMaliPractice.SeleniumFramework.AbstractComponents.AbstractComponent;

public class CartItemsPage extends AbstractComponent{

	WebDriver driver;

	@FindBy(xpath = "//*[@data-test='inventory-item']")
	List<WebElement> eleCartItems;

	@FindBy(id = "checkout")
	WebElement eleCheckoutBtn;

	@FindBy(id = "finish")
	WebElement eleFinishBtn;

	public CartItemsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement verifyItemAddedToCart(String strProductname) {
		waitForWebElementToAppear(eleCartItems);
		WebElement eleCartItem = eleCartItems.stream()
				.filter(prod -> prod.findElement(By.className("inventory_item_name")).getText().equals(strProductname))
				.findFirst().orElse(null);
		return eleCartItem;
		//System.out.println(eleCartItem.findElement(By.className("inventory_item_name")).getText());
	}

	public OrderDetailsPage clickCheckout() {
		eleCheckoutBtn.click();
		return new OrderDetailsPage(driver);

	}

	public ThankYouPage clickFinish() {
		eleFinishBtn.click();
		return new ThankYouPage(driver);
	}

}

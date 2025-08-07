package SulekhaMaliPractice.SeleniumFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SulekhaMaliPractice.SeleniumFramework.AbstractComponents.AbstractComponent;

public class OrderDetailsPage extends AbstractComponent{
	WebDriver driver;
	
	@FindBy(id="first-name")
	WebElement eleFirstName;
	
	@FindBy(id="last-name")
	WebElement eleLastName;
	
	@FindBy(id="postal-code")
	WebElement elePin;
	
	@FindBy(id="continue")
	WebElement eleContinueBtn;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement eleErrMsg;
	
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterOrderDetails(String strUserName, String strLastName, String strPin) {
		waitForWebElementToAppear(eleFirstName);
		eleFirstName.sendKeys(strUserName);
		eleLastName.sendKeys(strLastName);
		elePin.sendKeys(strPin);
		
	}

	public CartItemsPage clickContinue() {
		eleContinueBtn.click();
		return new CartItemsPage(driver);
	}
	
	public String getErrMsg() {
		waitForWebElementToAppear(eleErrMsg);
		return eleErrMsg.getText();
		
	}
}

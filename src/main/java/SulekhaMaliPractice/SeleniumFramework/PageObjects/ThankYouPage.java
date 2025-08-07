package SulekhaMaliPractice.SeleniumFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SulekhaMaliPractice.SeleniumFramework.AbstractComponents.AbstractComponent;

public class ThankYouPage extends AbstractComponent{
	WebDriver driver;
	String strActualMsg="Thank you for your order!";
	
	@FindBy(css=".complete-header")
	WebElement eleFinalMsg;
	
	public ThankYouPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyThankYouMsg() {
		waitForWebElementToAppear(eleFinalMsg);
		String strSuccessMsg=eleFinalMsg.getText();
		Assert.assertEquals(strActualMsg, strSuccessMsg);
	}
}

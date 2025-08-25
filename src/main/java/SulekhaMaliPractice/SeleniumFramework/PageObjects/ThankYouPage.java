package SulekhaMaliPractice.SeleniumFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SulekhaMaliPractice.SeleniumFramework.AbstractComponents.AbstractComponent;

public class ThankYouPage extends AbstractComponent{
	WebDriver driver;
	
	@FindBy(css=".complete-header")
	WebElement eleFinalMsg;
	
	public ThankYouPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyThankYouMsg() {
		waitForWebElementToAppear(eleFinalMsg);
		String strSuccessMsg=eleFinalMsg.getText();
		return strSuccessMsg;
		
	}
}

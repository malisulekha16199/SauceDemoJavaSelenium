package SulekhaMaliPractice.SeleniumFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SulekhaMaliPractice.SeleniumFramework.AbstractComponents.AbstractComponent;


public class LoginPage extends AbstractComponent{

	WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement eleUserName;
	
	@FindBy(id="password")
	WebElement elePassword;
	
	@FindBy(id="login-button")
	WebElement eleSigninBtn;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement eleErrMsg;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProductsPage LoginApplication(String strUserName, String strPassword) {
		//Login Page
		waitForWebElementToAppear(eleUserName);
		eleUserName.sendKeys(strUserName);
		elePassword.sendKeys(strPassword);
		eleSigninBtn.click();
		return new ProductsPage(driver);
}
	public void goTo(String strURL) {
		driver.get(strURL);
	}
	
	public String getErrMsg() {
		waitForWebElementToAppear(eleErrMsg);
		return eleErrMsg.getText();
	}
}

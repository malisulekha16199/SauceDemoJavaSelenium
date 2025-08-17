package SulekhaMaliPractice.SeleniumFramework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SulekhaMaliPractice.SeleniumFramework.PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginPg;
	public String strURL;
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement eleErrMsg;
	
	public WebDriver InitializeDriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//SulekhaMaliPractice//SeleniumFramework//Resources//GlobalData.properties");
		prop.load(fis);
		String browsername=System.getProperty("browser")!=null? System.getProperty("browser"): prop.getProperty("browser");
		strURL=prop.getProperty("url");
		
		if (browsername.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browsername.equals("edge")){
			System.setProperty("webdriver.edge.driver", "/Users/sulekhamali/eclipse-workspace/Drivers/msedgedriver"); // update with actual path
			driver = new EdgeDriver();
		}
		else if(browsername.equals("firefox")){
		WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@BeforeMethod
	public LoginPage LaunchApp() throws IOException {
		driver= InitializeDriver();

		loginPg= new LoginPage(driver);
		loginPg.goTo(strURL);
		
		return loginPg;
	
	}
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		File destination= new File(path);
		FileUtils.copyFile(source, destination);
		return path;
	}
			
}

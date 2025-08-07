package SulekhaMaliPractice.SeleniumFramework.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Sauce Demo E commerce Automated test reports");
		reporter.config().setReportName("Practice testing");	
		
		ExtentReports extent = new 	ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sulekha Mali");
		return extent;
	}
}

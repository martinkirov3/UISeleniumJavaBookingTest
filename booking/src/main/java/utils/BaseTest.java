package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.lang.reflect.Method;


public class BaseTest {

	public static WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("BeforeTest called");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("AutomationReport");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Martin Kirov");
	}
	
	@BeforeMethod
	@Parameters("browserName")
	
	public void beforeMethodMethod(String browserName, Method testMethod) {
		System.out.println("BeforeMethod called");
		test = extent.createTest(testMethod.getName());
		driver = SetupDriver.startBrowser(browserName);
			}


	@AfterMethod
    
	public void afterMethodMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("AfterMethodMethod called");
			String methodName = result.getMethod().getMethodName();
			String longText = "Test Case: " + methodName + " Passed";
			Markup m = MarkupHelper.createLabel(longText, ExtentColor.GREEN);
			test.log(Status.PASS, m);
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String longText = "Test Case: " + methodName + " Failed";
			Markup m = MarkupHelper.createLabel(longText, ExtentColor.RED);
			test.log(Status.FAIL,m);
		}
		driver.quit();
	}
	
	@AfterTest
	public void afterTestMethod() {
		System.out.println("AfterTest called");
		extent.flush();
	}
	
}

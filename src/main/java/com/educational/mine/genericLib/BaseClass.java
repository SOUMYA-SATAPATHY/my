package com.educational.mine.genericLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends FileUtilities {
	public WebDriver driver;
	public ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	public WebdriverUtilies utilities=new WebdriverUtilies();
	public FileUtilities fu=new FileUtilities();
	public Connection con;

	@BeforeSuite
	public void configureBS() throws SQLException
	{
		System.out.println("Connect to Database");
		con=fu.getDataDb();
		
		htmlreport=new ExtentHtmlReporter(AutoConstant.reportPath);
		htmlreport.config().setDocumentTitle("skillary");
		htmlreport.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		
	}
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertyFile("url"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeapp(ITestResult res) throws IOException
	{
		int result = res.getStatus();
		if (result==ITestResult.FAILURE) {
			test.log(Status.FAIL, res.getName()+"Test case failed");
			test.log(Status.FAIL, res.getThrowable()+"Test case is failed");
		}
		else if (result==ITestResult.SUCCESS) {
			test.log(Status.PASS, res.getName()+"Test case is passed");
		}
		else if(result==ITestResult.SKIP)
		{
			test.log(Status.SKIP, res.getName()+"Test case is skipped");
		}
		
		String name = res.getName();
	    if (result==2)
	    {
	    	Photo p = new Photo();
	    	p.screenshot(driver, name);
	    }
		
		driver.quit();
	}
	@AfterSuite
	public void congigAS()
	{
		htmlreport.flush();
		reports.flush();
		
		fu.closedb();
		System.out.println("Database is closing");
	}
	

}

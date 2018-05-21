package com.qualtab.automationdemo.scripts.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qualtab.automationdemo.scripts.utility.Constant;

public class Base {

	public static WebDriver driver;
	public static boolean bResult;

	public static WebDriver getDriver() {
		return driver;
	}

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static final Logger log4j = Logger.getLogger(Base.class);

	@BeforeClass
	public void _beforeTest() {
		DateFormat df = new SimpleDateFormat("dd.MM.yy-hhmmss");
		htmlReporter = new ExtentHtmlReporter(Constant.Path_Report + "TestReport_" +df.format(new Date()) + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "https://stage.realtydaddy.com");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("Reporter Name", "Samir Patel");

		htmlReporter.config().setDocumentTitle("Test Automation");
		htmlReporter.config().setReportName("Test Execution Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		if (log4j.isDebugEnabled()) {
			log4j.debug("entering BaseClass BeforeTest()");
		}

		// Configuring Log4j logs, please see the following posts to learn about Log4j
		// Logging
		// http://www.toolsqa.com/test-case-with-log4j/
		// http://www.toolsqa.com/log4j-logging/
		DOMConfigurator.configure("log4j.xml");

		System.setProperty("webdriver.gecko.driver", getClass().getResource(Constant.FF_Driver).getPath());
		driver = new FirefoxDriver();
		driver.navigate().to(Constant.URL);
		//logger.info("Open URL :" +Constant.URL);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void _afterMethod() {
		try {
			driver.quit();
			driver = null;
		} catch (Exception ignore) {

		}
		if (log4j.isDebugEnabled()) {
			log4j.debug("exiting BaseClass AfterClass()");
		}
	}
	
	public String getTestDataPath()
	{
		return getClass().getResource(Constant.Path_TestData).getPath();
	}

}

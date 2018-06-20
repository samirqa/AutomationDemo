package com.qa.rd.scripts.base;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.rd.scripts.utility.ApplicationProperties;
import com.qa.rd.scripts.utility.Constant;

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
	//@Parameters(value={"browser"})
	//public void _beforeTest(String browser) {
		public void _beforeClass() {
		try{
		DateFormat df = new SimpleDateFormat("dd.MM.yy-hhmmss");
//		File f = new File(ApplicationProperties.getInstance().getProperty("report.dir") + Constant.Path_Report);
//		if(!f.exists())
//			f.mkdirs();
//		
		
		htmlReporter = new ExtentHtmlReporter(ApplicationProperties.getInstance().getProperty("report.dir") + Constant.Path_Report + df.format(new Date()) + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "http://stage.realtydaddy.com/RealtyDaddyWeb");
		extent.setSystemInfo("Environment", "Stage Server Testing");
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
		//System.setProperty("webdriver.gecko.driver", getClass().getResource(Constant.FF_Driver).getPath());
		//driver = new FirefoxDriver();

		System.out.println(getClass().getResource(Constant.FF_Driver));
		URI url = new URI(getClass().getResource(Constant.FF_Driver).getFile());
		File f1=new File(url.getPath());
		Assert.assertEquals(f1.exists(), true);
		System.setProperty("webdriver.gecko.driver", url.getPath());
		driver = new FirefoxDriver();
		
		driver.navigate().to(Constant.URL);
		//logger.info("Open URL :" +Constant.URL);
		driver.manage().window().maximize();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public void _afterMethod() {
		try {
			extent.flush();
			//driver = null;
		} catch (Exception ignore) {

		}
		if (log4j.isDebugEnabled()) {
			log4j.debug("exiting BaseClass AfterClass()");
		}
	}
	
	public String getTestDataPath() throws URISyntaxException
	{
		URI url = new URI(getClass().getResource(Constant.Path_TestData).getFile());
		File f1=new File(url.getPath());
		Assert.assertEquals(f1.exists(), true);

		return url.getPath();
	}

}

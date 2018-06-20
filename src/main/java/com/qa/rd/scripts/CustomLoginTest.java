package com.qa.rd.scripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.rd.scripts.appModule.Login_Action;
import com.qa.rd.scripts.base.Base;
import com.qa.rd.scripts.utility.Constant;
import com.qa.rd.scripts.utility.ExcelUtils;
import com.qa.rd.scripts.utility.Log;
import com.qa.rd.scripts.utility.TestListener;

public class CustomLoginTest extends Base {
	// Getting the Test Case name, as it will going to use in so many places
	private String sTestCaseName = this.toString();

	@Test(priority = 0)
	public void Test_Login_Validation() throws Exception {
		Log.info("-------Start TestCase" + sTestCaseName + "----------");
		driver.manage().deleteAllCookies();
		logger = extent.createTest("Test Login Validation");
		ExcelUtils.setExcelFile(getTestDataPath() + Constant.File_TestData, "LoginTest");
		try {
			Login_Action.Click_Login_Link();
			Login_Action.Test_Blank_login();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_Blank_login", ExtentColor.GREEN));
			Log.info("Login_Action.Test_Valid_Login() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_Valid_Login() : FAIL");
			throw (e);
		}
		try {
			Login_Action.Test_InValid_Login();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_InValid_Login", ExtentColor.GREEN));
			Log.info("Login_Action.Test_InValid_Login() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_InValid_Login() : FAIL");
			throw (e);
		}
	}

	@Test(priority = 1)
	public void Test_Valid_Registration() throws Exception {
		Log.info("-------Start TestCase" + sTestCaseName + "----------");
		driver.manage().deleteAllCookies();
		logger = extent.createTest("Test Valid Registration");
		ExcelUtils.setExcelFile(getTestDataPath() + Constant.File_TestData, "LoginTest");
		try {
			Login_Action.Test_Valid_Login();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_Valid_Login ", ExtentColor.GREEN));
			Log.info("Login_Action.Test_Valid_Login() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_Valid_Login() : FAIL");
			throw (e);
		}
	}

	@Test(priority = 2)
	public void Test_FB_Login_Validation() throws Exception {
		Log.info("-------Start TestCase" + sTestCaseName + "----------");
		driver.manage().deleteAllCookies();
		logger = extent.createTest("Test FB Login Validation");
		try {
			Login_Action.Click_Login_Link();
			Thread.sleep(2000);
			Login_Action.Test_FB_Login_Validation();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_FB_Login_Validation ", ExtentColor.GREEN));
		} catch (Exception e) {
			Log.error("Login_Action.Test_InValid_Login() : FAIL");
			throw (e);
		}
	}

	@Test(priority = 3)
	public void Test_FB_Valid_Login() throws Exception {
		Log.info("-------Start TestCase" + sTestCaseName + "----------");
		driver.manage().deleteAllCookies();
		logger = extent.createTest("Test FB Valid Login");
		try {
		//	Login_Action.Click_Login_Link();
		//	Thread.sleep(2000);
			Login_Action.Test_FB_Valid_Login();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_FB_Valid_Login ", ExtentColor.GREEN));
		} catch (Exception e) {
			Log.error("Login_Action.Test_FB_Valid_Login() : FAIL");
			throw (e);
		}
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		Log.endTestCase(sTestCaseName);
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			TestListener testListener = new TestListener();
			testListener.onTestFailure(result);
		} else if (result.getStatus() == ITestResult.SKIP) {
			// logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
	}

	@AfterClass
	public void endReport() {
		driver.close();
	}
}

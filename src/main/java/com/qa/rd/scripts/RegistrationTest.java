package com.qa.rd.scripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.rd.scripts.appModule.Registration_Action;
import com.qa.rd.scripts.base.Base;
import com.qa.rd.scripts.utility.Log;
import com.qa.rd.scripts.utility.TestListener;

public class RegistrationTest extends Base {
	// Getting the Test Case name, as it will going to use in so many places
	private String sTestCaseName = this.toString();

	@Test(priority = 0)
	public void Test_Registration_Validation() throws Exception {
		Log.info("-------Start TestCase" + sTestCaseName + "----------");
		driver.manage().deleteAllCookies();
		logger = extent.createTest("Test Registaration Validation");
		try {
			Registration_Action.Click_Signup_Link();
			Registration_Action.Test_Blank_Registration();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_Blank_Registration", ExtentColor.GREEN));
			Log.info("Registration_Action.Test_Registraton_Validation() : PASS");
		} catch (Exception e) {
			Log.error("Registration_Action.Test_Registraton_Validation() : FAIL");
			throw (e);
		}
	}

	@Test(priority = 1)
	public void Test_Valid_Registration() throws Exception {
		Log.info("-------Start TestCase" + sTestCaseName + "----------");
		driver.manage().deleteAllCookies();
		logger = extent.createTest("Test Valid Registration");
		try {
			Registration_Action.Click_Signup_Link();
			Registration_Action.Click_Signup_Link();
			Registration_Action.Test_Valid_Registration();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_Valid_Registration ", ExtentColor.GREEN));
			Log.info("Login_Action.Test_Valid_Registration() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_Valid_Registration() : FAIL");
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

	@AfterTest
	public void endReport() {
		driver.close();
	}
}

package com.qualtab.automationdemo.scripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qualtab.automationdemo.scripts.appModule.Login_Action;
import com.qualtab.automationdemo.scripts.appModule.Shopping_Action;
import com.qualtab.automationdemo.scripts.base.Base;
import com.qualtab.automationdemo.scripts.utility.Constant;
import com.qualtab.automationdemo.scripts.utility.ExcelUtils;
import com.qualtab.automationdemo.scripts.utility.Log;
import com.qualtab.automationdemo.scripts.utility.TestListener;

public class ShoppingTest extends Base {
	// Getting the Test Case name, as it will going to use in so many places
	private String sTestCaseName = this.toString();

	@Test
	public void Test_Select_Product() throws Exception {
		Log.info("-------Start TestCase" + sTestCaseName + "----------");
		logger = extent.createTest("Test Select Product");
		ExcelUtils.setExcelFile(getTestDataPath() + Constant.File_TestData, "Sheet1");
		try {
			//Click on SignIn Link
			Login_Action.Click_SignIn_Link();
			logger.log(Status.PASS, MarkupHelper.createLabel("Click_SignIn_Link", ExtentColor.GREEN));
			// Do Login
			Login_Action.Test_Valid_Login();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_Valid_Login", ExtentColor.GREEN));
			Log.info("Login_Action.Test_Valid_Login() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_Valid_Login() : FAIL");
			Log.error(e.getMessage());
			// Utils.takeScreenshot(driver, sTestCaseName);
			throw (e);
		}
		try {
			Shopping_Action.Test_Select_Product_To_Cart();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_Select_Product_To_Cart", ExtentColor.GREEN));
			Log.info("Login_Action.Test_Select_Product_To_Cart() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_Select_Product_To_Cart() : FAIL");
			Log.error(e.getMessage());
			throw (e);
		}
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		Log.endTestCase(sTestCaseName);
		if (result.getStatus() == ITestResult.FAILURE) {
			// logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
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
		extent.flush();
	}
}

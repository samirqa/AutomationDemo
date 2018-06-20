package com.qa.rd.scripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.rd.scripts.appModule.CreatePropertyRequest_Action;
import com.qa.rd.scripts.appModule.HomeSearchLocation_Action;
import com.qa.rd.scripts.appModule.Login_Action;
import com.qa.rd.scripts.base.Base;
import com.qa.rd.scripts.utility.Log;
import com.qa.rd.scripts.utility.TestListener;

public class CreatePropertyRequestTest extends Base {
	// Getting the Test Case name, as it will going to use in so many places
	private String sTestCaseName = this.toString();

	@Test(priority = 0)
	public void Test_Search_Locaion() throws Exception {
		Log.info("-------Start TestCase" + sTestCaseName + "----------");
		driver.manage().deleteAllCookies();
		logger = extent.createTest("Test HomePage Search_Location");
		//ExcelUtils.setExcelFile(getTestDataPath() + Constant.File_TestData, "LoginTest");
		try {
			Login_Action.Click_Login_Link();
			logger.log(Status.PASS, MarkupHelper.createLabel("Click_Login_Link", ExtentColor.GREEN));
			Log.info("Login_Action.Click_Login_Link() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_Valid_Login() : FAIL");
			//logger.log(Status.FAIL, MarkupHelper.createLabel("Test_Blank_login", ExtentColor.RED));
			Log.error(e.getMessage());
			throw (e);
		}
		try {
			HomeSearchLocation_Action.Test_SearchLocation();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_Search_By_Location", ExtentColor.GREEN));
			Log.info("Login_Action.Test_SearchLocation() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_SearchLocation() : FAIL");
			//logger.log(Status.FAIL, MarkupHelper.createLabel("Test_Search_By_Location", ExtentColor.RED));
			Log.error(e.getMessage());
			throw (e);
		}
		try {
			CreatePropertyRequest_Action.Test_Create_Property_Request();
			logger.log(Status.PASS, MarkupHelper.createLabel("Test_Create_Property_Request", ExtentColor.GREEN));
			Log.info("Login_Action.Test_SearchLocation() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_SearchLocation() : FAIL");
			//logger.log(Status.FAIL, MarkupHelper.createLabel("Test_Create_Property_Request", ExtentColor.RED));
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
		driver.close();
	}
}

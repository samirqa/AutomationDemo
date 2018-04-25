package testCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import appModule.Login_Action;
import pageObjects.Base;
import utility.Log;
import utility.TestListener;


public class LoginTest extends Base {
	// Getting the Test Case name, as it will going to use in so many places
	private String sTestCaseName = this.toString();

	@Test
	public void Test_Login_Validation() throws Exception {
		Log.info("-------Start TestCase" + sTestCaseName + "----------");
		logger = extent.createTest("Test Valid Login");
		try {
			Login_Action.Test_Blank_login();
			Login_Action.Test_InValid_Login();
			
			logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed ", ExtentColor.GREEN));
			Log.info("Login_Action.Test_Valid_Login() : PASS");
		} catch (Exception e) {
			Log.error("Login_Action.Test_Valid_Login() : FAIL");
			Log.error(e.getMessage());
			//Utils.takeScreenshot(driver, sTestCaseName);
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

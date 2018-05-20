package appModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;
import library.Functions;
import pageObjects.Home_Page;
import pageObjects.MyAccount_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Frameworkg, please see http://www.toolsqa.com/modular-driven/   
public class Login_Action extends Base {
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	private static int iTestCaseRow;

	public Login_Action(WebDriver driver) {
		Base.driver = driver;
	}

	public static void Click_SignIn_Link() throws Exception {
		Log.info("Inside Login_Action.class - Click_SignIn_Link()");
		PageFactory.initElements(driver, Home_Page.class);
		logger.info("Searching SignIn Link");
		Functions.Click(Home_Page.SignInLink);
	}

	public static void Test_Blank_login() throws Exception {
		Log.info("Inside Login_Action.class - Test_Blank_login()");
		PageFactory.initElements(driver, Home_Page.class);
	
		// Clicking on Sign In Button
		Functions.Click(Home_Page.SignIn_btn);
		try {
			Assert.assertEquals(Home_Page.error_msg.getText(), "An email address required.");
			logger.info("Display " + Home_Page.error_msg.getText() + " message Successfully");
			Log.info("Verified " + Home_Page.error_msg.getText() + " message Successfully");
		} catch (Exception e) {
			logger.error("Exception :" + e);
			Log.error("Validation message is not matched");
			throw (e);
		}
		Log.info("Test_Blank_login() Executed Successfully");
	}

	public static void Test_InValid_Login() throws Exception {

		Log.info("Inside Login_Action.class - Test_InValid_Login()");

		PageFactory.initElements(driver, Home_Page.class);
		iTestCaseRow = ExcelUtils.getRowContains("Test_InValid_Login", Constant.Col_TestCaseName);
		// Fetched email test data against Test method name from the Test Data Sheet
		String sEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Email);
		
		// Enter invalid email
		Functions.Enter(Home_Page.Email, sEmail);
		
		// Click on Sign In button
		Functions.Click(Home_Page.SignIn_btn);
		try {
			logger.info("Verify Validation Message");
			Assert.assertEquals(Home_Page.error_msg.getText(), "Invalid email address.");
			logger.info("Display " + Home_Page.error_msg.getText() + " message Successfully");
			Log.info("Verified " + Home_Page.error_msg.getText() + " message Successfully");
		} catch (Exception e) {
			Log.error("Validation message is not matched");
			throw (e);
		}
		// Fetched invalid password against Test method name from the Test Data Sheet
		String sPwd = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);

		Functions.Enter(Home_Page.Email, "Test@test.com");
		Functions.Enter(Home_Page.Password, sPwd);
		Functions.Click(Home_Page.SignIn_btn);

		try {
			logger.info("Verify Validation Message");
			Assert.assertEquals(Home_Page.error_msg.getText(), "Authentication failed.");
			logger.info("Display " + Home_Page.error_msg.getText() + " message Successfully");
			Log.info("Verified " + Home_Page.error_msg.getText() + " message Successfully");
		} catch (Exception e) {
			Log.error("Validation message is not matched");
			throw (e);
		}

	}

	public static void Test_Valid_Login() throws Exception {

		Log.info("Inside Login_Action.class - Test_Valid_Login()");

		PageFactory.initElements(driver, Home_Page.class);
		PageFactory.initElements(driver, MyAccount_Page.class);
		iTestCaseRow = ExcelUtils.getRowContains("Test_Valid_Login", Constant.Col_TestCaseName);
		// Fetched email test data against Test method name from the Test Data Sheet
		String sEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Email);
		// Enter invalid email format
		Functions.Enter(Home_Page.Email, sEmail);
		// Fetched valid password against Test method name from the Test Data Sheet
		String sPwd = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
		// Enter Password
		Functions.Enter(Home_Page.Password, sPwd);
		// Click on Sign In button
		Functions.Click(Home_Page.SignIn_btn);
		try {

			if (MyAccount_Page.SignOut_Link.isDisplayed()) {
				logger.info("Display : " + MyAccount_Page.SignOut_Link.getText());
				Log.info("Display : " + MyAccount_Page.SignOut_Link.getText() + " Successfully");
				if (MyAccount_Page.MyAccount_Label.isDisplayed()) {
					logger.info("Display : " + MyAccount_Page.MyAccount_Label.getText() + " Label Successfully");
					Log.info("Display " + MyAccount_Page.MyAccount_Label.getText());
				}
				logger.info("Login Successful");
			}
		} catch (Exception e) {
			logger.error("Login failed :"+e.getMessage());
			Log.error("Login Unsuccessful");
			throw (e);
		}

	}

}

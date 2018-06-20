package com.qa.rd.scripts.appModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.rd.pageobjects.Login_Page;
import com.qa.rd.scripts.base.Base;
import com.qa.rd.scripts.library.Functions;
import com.qa.rd.scripts.utility.Constant;
import com.qa.rd.scripts.utility.ExcelUtils;
import com.qa.rd.scripts.utility.Log;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Frameworkg, please see http://www.toolsqa.com/modular-driven/   
public class Login_Action extends Base {
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	private static int iTestCaseRow;
	private static String winHandleBefore;

	public Login_Action(WebDriver driver) {
		Base.driver = driver;
	}

	public static void Click_Login_Link() throws Exception {
		Log.info("Inside Login_Action.class - Click_SignIn_Link()");
		PageFactory.initElements(driver, Login_Page.class);
		logger.info("Searching SignIn Link");
		Functions.waitForElement(Login_Page.LoginLink);
		Functions.Click(Login_Page.LoginLink);
	}

	public static void Test_Blank_login() throws Exception {
		Log.info("Inside Login_Action.class - Test_Blank_login()");
		PageFactory.initElements(driver, Login_Page.class);
		SoftAssert softAssert = new SoftAssert();
		// Clicking on Sign In Button
		Functions.Click(Login_Page.Login_btn);

		softAssert.assertEquals(Login_Page.Msg_EmailorPhone_Required.getText(), "Please enter Email Or Phone number");
		// Assert.assertEquals(Login_Page.Msg_EmailorPhone_Required.getText(), "Please
		// enter Email Or Phone number");
		logger.info("Verified Msg :" + Login_Page.Msg_EmailorPhone_Required.getText());
		Log.info("Verified Msg :" + Login_Page.Msg_EmailorPhone_Required.getText());
		softAssert.assertEquals(Login_Page.Msg_EmailorPhone_Required.getText(), "Please enter Email Or Phone number");
		// Assert.assertEquals(Login_Page.Msg_Password_Required.getText(), "Please enter
		// password");
		logger.info("Verified Msg :" + Login_Page.Msg_Password_Required.getText());
		Log.info("Verified " + Login_Page.Msg_Password_Required.getText());
		softAssert.assertAll();
	}

	public static void Test_InValid_Login() throws Exception {

		Log.info("Inside Login_Action.class - Test_InValid_Login()");
		PageFactory.initElements(driver, Login_Page.class);
		SoftAssert softAssert = new SoftAssert();
		iTestCaseRow = ExcelUtils.getRowContains("Test_InValid_Login", Constant.Col_TestCaseName);
		// Fetched email test data against Test method name from the Test Data Sheet
		String sEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Email);
		String pwd = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
		// Enter invalid email
		Functions.Enter(Login_Page.Login_EmailorPhone, sEmail);

		// Click on Sign In button
		Functions.Click(Login_Page.Login_btn);

		logger.info("Verify Validation Message");
		softAssert.assertEquals(Login_Page.Msg_Password_Required.getText(), "Please enter password");
		// Assert.assertEquals(Login_Page.Msg_Password_Required.getText(), "Please enter
		// password");
		logger.info("Verified Msg : " + Login_Page.Msg_Password_Required.getText());
		Log.info("Verified Msg : " + Login_Page.Msg_Password_Required.getText());

		// Fetched invalid password against Test method name from the Test Data Sheet
		String sPwd = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
		Functions.Enter(Login_Page.LoginPassword, sPwd);
		Functions.Click(Login_Page.Login_btn);

		logger.info("Verify Validation Message");
		softAssert.assertEquals(Login_Page.Msg_EmailorPhone_Not_Exist.getText(), "Email Or Phone does not exist");
		// Assert.assertEquals(Login_Page.Msg_EmailorPhone_Not_Exist.getText(), "Email
		// Or Phone does not exist");
		logger.info("Verified Msg : " + Login_Page.Msg_EmailorPhone_Not_Exist.getText());
		Log.info("Verified Msg :" + Login_Page.Msg_EmailorPhone_Not_Exist.getText());

		softAssert.assertAll();
	}

	public static void Test_Valid_Login() throws Exception {

		Log.info("Inside Login_Action.class - Test_FB_Valid_Login()");

		PageFactory.initElements(driver, Login_Page.class);

		iTestCaseRow = ExcelUtils.getRowContains("Test_Valid_Login", Constant.Col_TestCaseName);
		// Fetched email test data against Test method name from the Test Data Sheet
		String sEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Email);
		// Enter invalid email format
		Functions.Enter(Login_Page.Login_EmailorPhone, sEmail);
		// Fetched valid password against Test method name from the Test Data Sheet
		String sPwd = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
		// Enter Password
		Functions.Enter(Login_Page.LoginPassword, sPwd);
		// Click on Sign In button
		Functions.Click(Login_Page.Login_btn);

		Login_Page.MenuIcon.click();
		Thread.sleep(1000);

		if (Login_Page.LogoutLink.isDisplayed()) {
			logger.info("Display : " + Login_Page.LogoutLink.getText());
			Log.info("Display : " + Login_Page.LogoutLink.getText());
		}
		Functions.waitForElement(Login_Page.LogoutLink);
		logger.info("Click on : " + Login_Page.LogoutLink.getText());
		Functions.Click(Login_Page.LogoutLink);

	}

	public static void Test_FB_Login_Validation() throws Exception {

		Log.info("Inside Login_Action.class - Test_Valid_Login()");
		PageFactory.initElements(driver, Login_Page.class);
		// Creating softAssert object
		SoftAssert softAssert = new SoftAssert();

		logger.info("Click on " + Login_Page.FB_Login_Link.getText());
		Login_Page.FB_Login_Link.click();
		Thread.sleep(1000);
		winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			System.out.println("Window Title :" + driver.getTitle());
		}
		logger.info("Switch to FB Login");
		Functions.WaitForPageLoad();
		Login_Page.FB_Loginbtn.click();
		softAssert.assertEquals(Login_Page.FB_Login_Error.getText(), "Incorrect email address or phone number");
		logger.info("Verified  Msg :" + Login_Page.FB_Login_Error.getText());
		Functions.Enter(Login_Page.FB_email, "test");
		logger.info("Enter Email :" + "test");
		Functions.Enter(Login_Page.FB_passwrord, "test");
		logger.info("Enter Password :" + "test");
		Login_Page.FB_Loginbtn.click();
		logger.info("Click on FB Login Button");
		Thread.sleep(2000);
		softAssert.assertEquals(Login_Page.FB_Login_Error.getText(), "Please try again later");
		// Assert.assertEquals(Login_Page.FB_Login_Error.getText(), "Please try again
		// later");
		logger.info("Verified  Msg :" + Login_Page.FB_Login_Error.getText());
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
		logger.info("Switch to Back to Home Page");
		softAssert.assertAll();

	}

	public static void Test_FB_Valid_Login() throws Exception {

		Log.info("Inside Login_Action.class - Test_FB_Valid_Login()");
		PageFactory.initElements(driver, Login_Page.class);

		logger.info("Click on " + Login_Page.FB_Login_Link.getText());
		Login_Page.FB_Login_Link.click();
		Thread.sleep(1000);
		winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			System.out.println("Window Title :" + driver.getTitle());
		}
		logger.info("Switch to FB Login");
		// Functions.WaitForPageLoad();
		Functions.Enter(Login_Page.FB_email, "cnsqa2@gmail.com");
		logger.info("Enter Email :" + "cnsqa2@gmail.com");
		Functions.Enter(Login_Page.FB_passwrord, "cnsoftnet2525");
		logger.info("Enter Password :" + "cnsoftnet2525");
		Login_Page.FB_Loginbtn.click();
		Thread.sleep(2000);
		// driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		logger.info("Switch to Back to Home Page");
		Login_Page.MenuIcon.click();
		Thread.sleep(2000);
		Functions.waitForElement(Login_Page.LogoutLink);
		if (Login_Page.LogoutLink.isDisplayed()) {
			logger.info("Display : " + Login_Page.LogoutLink.getText());
			Log.info("Display : " + Login_Page.LogoutLink.getText());
		}
		Functions.Click(Login_Page.LogoutLink);

	}

}

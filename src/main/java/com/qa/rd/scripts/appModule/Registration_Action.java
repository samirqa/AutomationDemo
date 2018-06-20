package com.qa.rd.scripts.appModule;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.qa.rd.pageobjects.Login_Page;
import com.qa.rd.pageobjects.Registration_Page;
import com.qa.rd.scripts.base.Base;
import com.qa.rd.scripts.library.Functions;
import com.qa.rd.scripts.utility.Log;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Frameworkg, please see http://www.toolsqa.com/modular-driven/   
public class Registration_Action extends Base {
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	private static int iTestCaseRow;
	static JSONParser parser = new JSONParser();

	public Registration_Action(WebDriver driver) {
		Base.driver = driver;
	}

	public static void Click_Signup_Link() throws Exception {
		Log.info("Inside Registration_Action.class - Click_SignUp_Link()");
		PageFactory.initElements(driver, Registration_Page.class);
		logger.info("Searching Sign Up Link");
		Functions.Click(Registration_Page.SignUp_Link);
	}

	public static void Test_Blank_Registration() throws Exception {
		Log.info("Inside Registration_Action.class - Test_Blank_login()");
		PageFactory.initElements(driver, Registration_Page.class);

		// Clicking on Create an Account Button
		Functions.Click(Registration_Page.CreateAccount_Link);
		Functions.Click(Registration_Page.Proceed);

		Thread.sleep(2000);
		Assert.assertEquals(Registration_Page.Title_required_msg.getText(), "Please select Title");
		logger.info(
				"Verified Validation : " + Registration_Page.Title_required_msg.getText() + " message Successfully");
		Log.info("Verified " + Registration_Page.Title_required_msg.getText() + " message Successfully");

		Assert.assertEquals(Registration_Page.Firstname_required_msg.getText(), "Please enter first name");
		logger.info(
				"Verified Validation :" + Registration_Page.Firstname_required_msg.getText() + " message Successfully");
		Log.info("Verified " + Registration_Page.Firstname_required_msg.getText() + " message Successfully");

		Assert.assertEquals(Registration_Page.DOB_required_msg.getText(), "Please enter date of birth");
		logger.info("Verified Validation :" + Registration_Page.DOB_required_msg.getText() + " message Successfully");
		Log.info("Verified " + Registration_Page.DOB_required_msg.getText() + " message Successfully");

		Assert.assertEquals(Registration_Page.Mobile_required_msg.getText(), "Please enter Mobile Number");
		logger.info(
				"Verified Validation :" + Registration_Page.Mobile_required_msg.getText() + " message Successfully");
		Log.info("Verified " + Registration_Page.Mobile_required_msg.getText() + " message Successfully");

		Assert.assertEquals(Registration_Page.Email_required_msg.getText(), "Please enter Email");
		logger.info("Verified Validation :" + Registration_Page.Email_required_msg.getText() + " message Successfully");
		Log.info("Verified " + Registration_Page.Email_required_msg.getText() + " message Successfully");

		Assert.assertEquals(Registration_Page.Password_required_msg.getText(), "Please enter password");
		logger.info(
				"Verified Validation :" + Registration_Page.Password_required_msg.getText() + " message Successfully");
		Log.info("Verified " + Registration_Page.Password_required_msg.getText() + " message Successfully");

		// Test Validation
		Thread.sleep(2000);
		Functions.Enter(Registration_Page.FirstName, "123");
		Assert.assertEquals(Registration_Page.Firstname_required_msg.getText(), "Only alphabets and dot are allowed.");
		logger.info(
				"Verified Validation :" + Registration_Page.Firstname_required_msg.getText() + " message Successfully");

		Functions.Enter(Registration_Page.DOB_Date, "1/6/18");
		Registration_Page.DOB_Date.sendKeys(Keys.TAB);
		Assert.assertEquals(Registration_Page.DOB_required_msg.getText(),
				"Date of birth should be in DD/MM/YYYY format");
		logger.info("Verified Validation :" + Registration_Page.DOB_required_msg.getText() + " message Successfully");

		Functions.Enter(Registration_Page.PhoneNumber, "98980");
		Assert.assertEquals(Registration_Page.Mobile_required_msg.getText(), "Enter 10 digit valid mobile number");
		logger.info(
				"Verified Validation :" + Registration_Page.Mobile_required_msg.getText() + " message Successfully");

		Functions.Enter(Registration_Page.Emailid, "test@123");
		Assert.assertEquals(Registration_Page.Email_required_msg.getText(), "Please enter a valid email address");
		logger.info("Verified Validation :" + Registration_Page.Email_required_msg.getText() + " message Successfully");

		Functions.Enter(Registration_Page.Password, "123");
		Assert.assertEquals(Registration_Page.Password_required_msg.getText(),
				"Min 8 and Max 35 characters, atleast 1 Uppercase, 1 Number & 1 Special Character");
		logger.info(
				"Verified Validation :" + Registration_Page.Password_required_msg.getText() + " message Successfully");

	}

	public static void Test_Valid_Registration() throws Exception {

		Log.info("Inside Test_Valid_Registration.class - Test_Valid_Registration()");
		Functions.Click(Registration_Page.CreateAccount_Link);

		Object obj = parser
				.parse(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\Registration.json"));

		JSONObject jsonObject = (JSONObject) obj;
		String Title = (String) jsonObject.get("Title");
		System.out.println(Title);

		String FirstName = (String) jsonObject.get("FirstName");
		System.out.println(FirstName);

		String LastName = (String) jsonObject.get("LastName");
		System.out.println(LastName);

		String DOB = (String) jsonObject.get("DOB");
		System.out.println(DOB);

		String Mobile = (String) jsonObject.get("Mobile");
		System.out.println(Mobile);

		String Email = (String) jsonObject.get("Email");
		System.out.println(Email);

		String Password = (String) jsonObject.get("Password");
		System.out.println(Password);

		// JSON By Array
		// JSONArray a = (JSONArray) parser.parse(new
		// FileReader(System.getProperty("user.dir") +
		// "\\src\\main\\resources\\Registration.json"));
		// for (Object o : a)
		// {
		// JSONObject jsonObject = (JSONObject) o;
		//
		// String Title = (String) jsonObject.get("Title");
		// System.out.println(Title);
		//
		// String FirstName = (String) jsonObject.get("FirstName");
		// System.out.println(FirstName);
		//
		// String LastName = (String) jsonObject.get("LastName");
		// System.out.println(LastName);
		//
		// String Mobile = (String) jsonObject.get("Mobile");
		// System.out.println(Mobile);
		//
		// String Email = (String) jsonObject.get("Email");
		// System.out.println(Email);
		//
		// String Password = (String) jsonObject.get("Password");
		// System.out.println(Password);
		//
		// }
		// Functions.ScrollToView(Registration_Page.Title);
		Functions.SelectByValue(Registration_Page.Title, Title);
		logger.info("Select Title : " + Title);
		Functions.Enter(Registration_Page.FirstName, FirstName);
		logger.info("Enter FirstName : " + FirstName);
		Functions.Enter(Registration_Page.LastName, LastName);
		logger.info("Enter LastName : " + LastName);
		Functions.Enter(Registration_Page.DOB_Date, DOB);
		logger.info("Select DOB : " + DOB);
		Functions.Enter(Registration_Page.PhoneNumber, Mobile);
		logger.info("Enter Mobile : " + Mobile);
		Functions.Enter(Registration_Page.Emailid, Email);
		logger.info("Enter Email : " + Email);
		Functions.Enter(Registration_Page.Password, Password);
		logger.info("Enter Password : " + Password);

		Functions.Click(Registration_Page.Proceed);
		logger.info("Click on " + Registration_Page.Proceed.getText());
		Thread.sleep(1000);

		String smsotp = Registration_Page.SMSOTP.getText();
		System.out.println("SMS OTP " + smsotp);
		String emailotp = Registration_Page.EmailOTP.getText();
		System.out.println("SMS OTP " + emailotp);

		Functions.Enter(Registration_Page.EnterMobileOTP, smsotp);
		logger.info("Enter EmailOTP : " + smsotp);

		Functions.Enter(Registration_Page.EnterEmailOTP, emailotp);
		logger.info("Enter EmailOTP : " + emailotp);

		Functions.Click(Registration_Page.Submitbtn);
		Thread.sleep(1000);
		System.out.println("Confirmation msg : " + Registration_Page.RegistratioinConfirm.getText());
		System.out.println("Confirmation msg : " + Registration_Page.MobileConfirm.getAttribute("value"));
		System.out.println("Confirmation msg : " + Registration_Page.EmailConfirm.getAttribute("value"));
		Assert.assertEquals(Registration_Page.RegistratioinConfirm.getText(), "Account Creation Completed!");
		logger.info("Success Msg :" + Registration_Page.RegistratioinConfirm.getText());
		Assert.assertEquals(Mobile, Registration_Page.MobileConfirm.getAttribute("value"));
		logger.info("Registration is confirmation Mobile : " + Registration_Page.MobileConfirm.getAttribute("value"));
		Assert.assertEquals(Email, Registration_Page.EmailConfirm.getAttribute("value"));
		logger.info("Registration is confirmation Email : " + Registration_Page.EmailConfirm.getAttribute("value"));

	}

}

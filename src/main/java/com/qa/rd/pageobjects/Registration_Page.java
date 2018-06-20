package com.qa.rd.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Registration_Page {

	@FindBy(how = How.ID, using = "btnSignUp")
	public static WebElement SignUp_Link;
	@FindBy(how = How.LINK_TEXT, using = "Create an Account")
	public static WebElement CreateAccount_Link;
	@FindBy(how = How.ID, using = "UserRegister_Title")
	public static WebElement Title;
	@FindBy(how = How.ID, using = "UserRegister_FirstName")
	public static WebElement FirstName;
	@FindBy(how = How.ID, using = "UserRegister_LastName")
	public static WebElement LastName;
	@FindBy(how = How.XPATH, using = "//[@id='signinstartDate']/span[@class='input-group-addon']/span[@class='glyphicon glyphicon-calendar']")
	public static WebElement Calender;
	@FindBy(how = How.ID, using = "UserRegister_DateofBirth")
	public static WebElement DOB_Date;
	@FindBy(how = How.ID, using = "UserRegister_PhoneNumber")
	public static WebElement PhoneNumber;
	@FindBy(how = How.ID, using = "UserRegister_EmailAddress")
	public static WebElement Emailid;
	@FindBy(how = How.ID, using = "UserRegister_UserPassword")
	public static WebElement Password;
	@FindBy(how = How.ID, using = "sbtnSaveRegistration")
	public static WebElement Proceed;
	@FindBy(how = How.ID, using = "UserRegister_Title-error")
	public static WebElement Title_required_msg;
	@FindBy(how = How.ID, using = "UserRegister_FirstName-error")
	public static WebElement Firstname_required_msg;
	@FindBy(how = How.ID, using = "UserRegister_DateofBirth-error")
	public static WebElement DOB_required_msg;
	@FindBy(how = How.ID, using = "UserRegister_PhoneNumber-error")
	public static WebElement Mobile_required_msg;
	@FindBy(how = How.ID, using = "UserRegister_EmailAddress-error")
	public static WebElement Email_required_msg;
	@FindBy(how = How.ID, using = "UserRegister_UserPassword-error")
	public static WebElement Password_required_msg;
	@FindBy(how = How.ID, using = "lblOTPMobileCode")
	public static WebElement SMSOTP;
	@FindBy(how = How.ID, using = "lblOTPEmailCode")
	public static WebElement EmailOTP;
	@FindBy(how = How.ID, using = "txtOtpCode")
	public static WebElement EnterMobileOTP;
	@FindBy(how = How.ID, using = "txtEmailOtpCode")
	public static WebElement EnterEmailOTP;
	@FindBy(how = How.ID, using = "abtnRegistration")
	public static WebElement Submitbtn;
	@FindBy(how = How.XPATH, using = "//*[@id='frmRegistration']/div[4]/h2")
	public static WebElement RegistratioinConfirm;
	@FindBy(how = How.XPATH, using = "//*[@id='frmRegistration']/div[4]/div[1]/input")
	public static WebElement MobileConfirm;
	@FindBy(how = How.XPATH, using = "//*[@id='frmRegistration']/div[4]/div[2]/input")
	public static WebElement EmailConfirm;
}

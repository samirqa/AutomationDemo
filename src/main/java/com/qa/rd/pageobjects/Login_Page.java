package com.qa.rd.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_Page {

	@FindBy(how = How.XPATH, using = "//a[@href = 'javascript:void(0)' and (text() = 'Login' or . = 'Login')]")
	public static WebElement LoginLink;
	@FindBy(how = How.ID, using = "UserLoginDetail_EmailOrPhone")
	public static WebElement Login_EmailorPhone;
	@FindBy(how = How.ID, using = "UserLoginDetail_Password")
	public static WebElement LoginPassword;
	@FindBy(how = How.ID, using = "sbtnLoginClick")
	public static WebElement Login_btn;
	@FindBy(how = How.XPATH, using = "//*[@id='error_msg']/div[@class='error_msg_left']/label[1]")
	public static WebElement Msg_EmailorPhone_Not_Exist;
	@FindBy(how = How.ID, using = "UserLoginDetail_EmailOrPhone-error")
	public static WebElement Msg_EmailorPhone_Required;
	@FindBy(how = How.ID, using = "UserLoginDetail_Password-error")
	public static WebElement Msg_Password_Required;
	@FindBy(how = How.CSS, using = "a.nav_home")
	public static WebElement MenuIcon;
	@FindBy(how = How.LINK_TEXT, using = "Logout")
	public static WebElement LogoutLink;
	@FindBy(how = How.XPATH, using = "//div[@id='divSignIn']/div/div/a[1]/span")
	public static WebElement FB_Login_Link;
	@FindBy(how = How.XPATH, using = "//input[@id='u_0_0']")
	public static WebElement FB_Loginbtn;
	@FindBy(how = How.XPATH, using = "//div[@id='divSignIn']/div/div/a[2]/span")
	public static WebElement Google_Login_Link;
	@FindBy(how = How.XPATH, using = "//div[@id='error_box']/div[1]")
	public static WebElement FB_Login_Error;
	@FindBy(how = How.ID, using ="email")
	public static WebElement FB_email;
	@FindBy(how = How.ID, using ="pass")
	public static WebElement FB_passwrord;
	
	
	
}

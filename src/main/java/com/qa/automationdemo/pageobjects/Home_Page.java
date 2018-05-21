package com.qa.automationdemo.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Page {

	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	public static WebElement SignInLink;
	@FindBy(how = How.ID, using = "email")
	public static WebElement Email;
	@FindBy(how = How.ID, using = "passwd")
	public static WebElement Password;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']/span")
	public static WebElement SignIn_btn;
	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/div/ol/li")
	public static WebElement error_msg;
}

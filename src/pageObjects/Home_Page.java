package pageObjects;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Log;

//import utility.Log;
//import utility.Utils;
public class Home_Page {

	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	private static WebElement SignInLink;

	@FindBy(how = How.ID, using = "email")
	private static WebElement Email;
	@FindBy(how = How.ID, using = "passwd")
	private static WebElement Password;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']/span")
	public static WebElement SignIn_btn;
	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/div/ol/li")
	public static WebElement error_msg;

	public static WebElement SignIn_Link() throws Exception {
		try {
			if (SignInLink.isDisplayed()) {
				Log.info("SignIn Link is Displayed is displayed on the Home Page");
			}
		} catch (NoSuchElementException no_ele) {
			Log.error(no_ele.getMessage());
		} catch (ElementNotVisibleException ele_dis) {
			Log.error(ele_dis.getMessage());
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw (e);
		}

		return SignInLink;
	}

	public static WebElement Email() throws Exception {
		try {
			if (Email.isEnabled()) {
				Email.clear();
				Log.info("Email Textbox is Displayed on the Home Page");
			}
		} catch (NoSuchElementException no_ele) {
			Log.error(no_ele.getMessage());
		} catch (ElementNotVisibleException ele_dis) {
			Log.error(ele_dis.getMessage());
		} catch (Exception e) {
			Log.error("Email Textbox is not found on the Home Page");
			throw (e);
		}
		return Email;
	}

	public static WebElement Password() throws Exception {
		try {
			if (Password.isEnabled()) {
				Log.info("Password is Displayed on the Home Page");
			}
		} catch (NoSuchElementException no_ele) {
			Log.error(no_ele.getMessage());
		} catch (ElementNotVisibleException ele_dis) {
			Log.error(ele_dis.getMessage());
		} catch (Exception e) {
			Log.error("Password Option is not found on the Home Page");
			throw (e);
		}
		return Password;
	}

}

package appModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Base;
import pageObjects.CheckOut_Page;
import utility.Log;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Frameworkg, please see http://www.toolsqa.com/modular-driven/   
public class CheckOut_Action extends Base {
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	public CheckOut_Action(WebDriver driver) {
		Base.driver = driver;
	}

	public static void Test_CheckOut() throws Exception {
		Log.info("Inside CheckOut_Action.class - Test_CheckOut()");

		PageFactory.initElements(driver, CheckOut_Page.class);
		try {
			if (CheckOut_Page.Summary_tab.getText().equalsIgnoreCase("01. Summary"))
			logger.info("Display : " + CheckOut_Page.Summary_tab.getText() + "Successfully");
			Log.info("Display : " + CheckOut_Page.Summary_tab.getText() + "Successfully");
		} catch (Exception e) {
			Log.error("Fail to open Shopping-cart summary");
			throw (e);
		}
		
	}
}

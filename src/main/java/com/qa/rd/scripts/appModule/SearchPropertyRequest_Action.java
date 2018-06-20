package com.qa.rd.scripts.appModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.qa.rd.pageobjects.Login_Page;
import com.qa.rd.pageobjects.SearchProeprtyRequest_Page;
import com.qa.rd.scripts.base.Base;
import com.qa.rd.scripts.library.Functions;
import com.qa.rd.scripts.utility.Log;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Frameworkg, please see http://www.toolsqa.com/modular-driven/   
public class SearchPropertyRequest_Action extends Base {
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	public static String winHandleBefore;
	public SearchPropertyRequest_Action(WebDriver driver) {
		Base.driver = driver;
	}

	public static void Test_Search_Property_Request() throws Exception {
		
		Log.info("Inside SearchPropertyRequest_Action");
		PageFactory.initElements(driver, Login_Page.class);
		PageFactory.initElements(driver, SearchProeprtyRequest_Page.class);
		logger.info("Inside SearchPropertyRequest_Action");
		Functions.waitForElement(Login_Page.Login_EmailorPhone);
		Functions.Enter(Login_Page.Login_EmailorPhone,"selenium@test.com");
		logger.info("Login with Valid credential");
		Functions.Enter(Login_Page.LoginPassword,"Admin@123");
		Functions.Click(Login_Page.Login_btn);
		logger.info("Click on Login button");
		Functions.WaitForPageLoad();
		Login_Page.MenuIcon.click();
		logger.info("Click on Menu Link");
		Functions.waitForElement(SearchProeprtyRequest_Page.SearchPropertyLead_Menu_Link);
		SearchProeprtyRequest_Page.SearchPropertyLead_Menu_Link.click();
		logger.info("Click on Property Lead Menu Link");
		Functions.WaitForPageLoad();
		SearchProeprtyRequest_Page.SearchLead.click();
		logger.info("Click on Property Search request record");
		// Store the current window handle
		winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		logger.info("Switch to Property Request detail page");
		Functions.WaitForPageLoad();
		Thread.sleep(2000);
	}
	public static void Test_Property_Request_Feedback() throws Exception {
		// Perform the actions on new window
		Functions.Click(SearchProeprtyRequest_Page.ViewContactbtn);
		Thread.sleep(2000);
		if(SearchProeprtyRequest_Page.Feedbacksection.isDisplayed())
		{
			Functions.ScrollToView(SearchProeprtyRequest_Page.EditFeedbackbtn);
			Functions.Click(SearchProeprtyRequest_Page.EditFeedbackbtn);
			logger.info("Click on feedback edit feedback button");
			Functions.Click(SearchProeprtyRequest_Page.FeedbackSumitbtn);
			logger.info("Click on feedback submit button");
		}
		else {
			
		Functions.ScrollToView(SearchProeprtyRequest_Page.GenuinityRate);
		Functions.Click(SearchProeprtyRequest_Page.GenuinityRate);
		logger.info("Click on Genuinity Rating");
		Functions.Click(SearchProeprtyRequest_Page.AccuracyRate);
		logger.info("Click on Accuracy Rating");
		Functions.Click(SearchProeprtyRequest_Page.ClerityRate);
		logger.info("Click on Clerity Rating");
		Functions.Enter(SearchProeprtyRequest_Page.feedbackText,"Test Feedback");
		logger.info("Enter feedback");
		Functions.Click(SearchProeprtyRequest_Page.FeedbackSumitbtn);
		logger.info("Click on feedback submit button");
		}
		// Close the new window, if that window no more required
		driver.close();
		Thread.sleep(2000);
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		logger.info("Switch to Back to Property Search Request result page");
		Functions.WaitForPageLoad();
	}
}

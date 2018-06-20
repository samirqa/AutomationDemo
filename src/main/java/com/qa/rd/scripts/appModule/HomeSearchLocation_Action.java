package com.qa.rd.scripts.appModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.base.Function;
import com.qa.rd.pageobjects.Home_Page;
import com.qa.rd.pageobjects.Login_Page;
import com.qa.rd.scripts.base.Base;
import com.qa.rd.scripts.library.Functions;
import com.qa.rd.scripts.utility.Constant;
import com.qa.rd.scripts.utility.ExcelUtils;
import com.qa.rd.scripts.utility.Log;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Frameworkg, please see http://www.toolsqa.com/modular-driven/   
public class HomeSearchLocation_Action extends Base {
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	private static int iTestCaseRow;

	public HomeSearchLocation_Action(WebDriver driver) {
		Base.driver = driver;
	}

	public static void Test_SearchLocation() throws Exception {
		Thread.sleep(2000);
		Log.info("Inside HomeSearchLocation_Action");
		PageFactory.initElements(driver, Home_Page.class);
		Functions.Enter(Login_Page.Login_EmailorPhone,"selenim1@test.com");
		Functions.Enter(Login_Page.LoginPassword,"Admin@123");
		Functions.Click(Login_Page.Login_btn);
		Thread.sleep(2000);
		Functions.Enter(Home_Page.SearchBuy_Property, "Vastr");
		logger.info("Enter Search Location 'Vastr' ");
		Functions.selectOptionWithText("Vastrapur");
		//Functions.Click(Home_Page.selectVastrapur);
		Thread.sleep(2000);
		logger.info("Select matched Location");
		Functions.Click(Home_Page.ProeprtyType_DD);
		logger.info("Click on Property Type Drop down");
		Functions.Click(Home_Page.Apertmentchk);
		logger.info("Checked Apartment");
		Functions.Click(Home_Page.BHK1chk);
		logger.info("Checked 1 BHK");
		Functions.Click(Home_Page.Searchbtn);
		logger.info("Click on Search button");
	}
}

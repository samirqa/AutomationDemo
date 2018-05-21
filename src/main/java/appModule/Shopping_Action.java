package appModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import library.Functions;
import pageObjects.MyAccount_Page;
import pageObjects.Shopping_Page;
import utility.Log;
import utility.Utils;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Frameworkg, please see http://www.toolsqa.com/modular-driven/   
public class Shopping_Action extends Base {
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	public Shopping_Action(WebDriver driver) {
		Base.driver = driver;
	}

	public static void Test_Select_Product_To_Cart() throws Exception {
		Log.info("Inside Shopping_Action.class - Test_Select_Product()");

		PageFactory.initElements(driver, Shopping_Page.class);
		PageFactory.initElements(driver, MyAccount_Page.class);
		
		//Click on Home button to go on shopping page
		Functions.Click(MyAccount_Page.Home_btn);
		
		//Click on TShirt Tab
		Functions.Click(Shopping_Page.TShirts_Tab);
		//logger.info("Click on :" + Shopping_Page.TShirts_Tab.getText() + " Tab Successfully");
		try {
			if (Shopping_Page.Catalog_Label.getText().equalsIgnoreCase("Catalog"))
			logger.info("Display : " + Shopping_Page.Catalog_Label.getText() + "Successfully");
			Log.info("Display : " + Shopping_Page.Catalog_Label.getText() + " Successfully");
		} catch (Exception e) {
			Log.error("Fail to open Shopping Page");
			throw (e);
		}
		//Click on Check Box
		Functions.Click(Shopping_Page.Size_M_CheckBox);
		//logger.info("Click on M Size Check Box Successfully");
		Select dropdown = new Select(Shopping_Page.ProductSort_DropDown);
		// Select value from Product drop down
		dropdown.selectByVisibleText("Price: Lowest first");
		logger.info("Select value : Price: Lowest first from product drop down");
		// Click on TShirt link
		Functions.Click(Shopping_Page.TShirt_Link);
		//logger.info("Click on "+ Shopping_Page.TShirt_Link +" Link Successfully");
		Log.info("Test_Select_Product Executed Successfully");
		List<WebElement> links = Shopping_Page.images.findElements(By.tagName("li"));
		//Actions a1 = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
		for (int i = 1; i < links.size(); i++)
		{
		    Functions.MouseHover(links.get(i));
		    Thread.sleep(2000);
		}
		logger.info("Navigate the all small images Successfully");
		Log.info("Navigate the all small images Successfully");
		Functions.Click(Shopping_Page.AddToCart_Submit);
		Log.info("Click on "+ Shopping_Page.AddToCart_Submit +" Button Successfully");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			if (wait.until(ExpectedConditions.textToBePresentInElement(Shopping_Page.AddToCart_Confirmation, "Product successfully added to your shopping cart"))) {
				if(Shopping_Page.AddToCart_Confirmation.getText().equalsIgnoreCase("Product successfully added to your shopping cart"))
				{
					logger.info("Add to Cart Confirmation Msg : "+ Shopping_Page.AddToCart_Confirmation.getText());
					Log.info("Add to Cart Confirmation Msg : "+ Shopping_Page.AddToCart_Confirmation.getText());
				}
				if(Shopping_Page.AddToCart_item_Confirmation.getText().equalsIgnoreCase("There is 1 item in your cart."))
				{
					logger.info("Add to Cart Item Confirmation Msg : "+ Shopping_Page.AddToCart_item_Confirmation.getText());
					Log.info("Add to Cart Item Confirmation Msg : "+ Shopping_Page.AddToCart_item_Confirmation.getText());
				}
			}
		}catch (Exception e) {
			Log.error("Fail to Add Product in Cart");
			throw (e);
		}
		Log.info("Inside Shopping_Action.class - Test_CheckOut()");
		Utils.waitForElement(Shopping_Page.ProccedCheckOut_btn);
		Functions.Click(Shopping_Page.ProccedCheckOut_btn);
	}
}

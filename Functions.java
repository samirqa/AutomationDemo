package library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pageObjects.Base;
import utility.Log;

public class Functions extends Base {

	public static void Click(WebElement element) throws Exception {
		try {
			// Highlight the Element before Click
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);

			element.click();
		 
			logger.info("Click on :" + element.getText() + " Successfully");
			Log.info("Click on :" + element.getText() + " Successfully");
			//Remove Highlight on Element after Click
			//((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
			
			

		} catch (org.openqa.selenium.NoSuchElementException NSEE) {
			logger.warning("Click on :" + element + " failed :" + NSEE);
			Log.error("Click on :" + element + " failed :" + NSEE);
		} catch (org.openqa.selenium.ElementNotVisibleException ENV) {
			logger.warning("Not Visible Element :" + element + " Error :" + ENV);
			Log.error("Not Visible Element :" + element + " Error :" + ENV);
		}
	}

	public static void Enter(WebElement element, String TestData) throws Exception {
		try {
			// Highlight the Element before Click
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
			element.clear();
			element.sendKeys(TestData);
			
			// Remove Highlight on Element after Click
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
			
			logger.info("Enter Test Data :" + TestData + " in field " + element +" Successfully");
			Log.info("Enter Test Data :" + TestData + " in field " + element +" Successfully");
		} catch (org.openqa.selenium.NoSuchElementException NSEE) {
			logger.error("Enter on :" + element + " failed :" + NSEE);
			Log.error("Enter on :" + element + " failed :" + NSEE);
		} catch (org.openqa.selenium.ElementNotVisibleException ENV) {
			logger.error("Not Visible Element :" + element + " Error :" + ENV);
			Log.error("Not Visible Element :" + element + " Error :" + ENV);
		} 
	}
}

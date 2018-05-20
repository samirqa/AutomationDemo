package library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.Base;
import utility.Log;

public class Functions extends Base {

	public static void Click(WebElement element) throws Exception {
		try {
			// Highlight the Element before Click
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
			logger.info("Click on :" + element.getText());
			Log.info("Click on :" + element.getText());
			element.click();

			// Remove Highlight on Element after Click
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].style.border='0px'", element);
		} catch (org.openqa.selenium.NoSuchElementException NSEE) {
			logger.warning("Click on :" + element + " failed");
			Log.error("Click on :" + element + " failed :" + NSEE);
			throw (NSEE);
		} catch (org.openqa.selenium.ElementNotVisibleException ENV) {
			logger.warning("Not Visible Element :" + element);
			Log.error("Not Visible Element :" + element + " Error :" + ENV);
			throw (ENV);
		}
	}

	public static void Enter(WebElement element, String TestData) throws Exception {
		try {
			// Highlight the Element before Click
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
			element.clear();
			logger.info("Enter Test Data :" + TestData + " in field " + element);
			Log.info("Enter Test Data :" + TestData + " in field " + element);
			element.sendKeys(TestData);

			// Remove Highlight on Element after Click
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].style.border='0px'", element);

		} catch (org.openqa.selenium.NoSuchElementException NSEE) {
			logger.error("Enter on :" + element + " failed.");
			Log.error("Enter on :" + element + " failed :" + NSEE);
			throw (NSEE);
		} catch (org.openqa.selenium.ElementNotVisibleException ENV) {
			logger.error("Not Visible Element :" + element);
			Log.error("Not Visible Element :" + element + " Error :" + ENV);
			throw (ENV);
		}
	}

	public static void MouseHover(WebElement element) throws Exception {
		try {
			// Highlight the Element before Click
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
			Actions a1 = new Actions(driver);
			a1.moveToElement(element).build().perform();
			logger.info("Mouse Hover on :" + element.getTagName());
			// Remove Highlight on Element after Click
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);

		} catch (org.openqa.selenium.NoSuchElementException NSEE) {
			logger.error("Mouse Hover on :" + element + " failed.");
			Log.error("Mouse Hover on :" + element + " failed :" + NSEE);
			throw (NSEE);
		} catch (org.openqa.selenium.ElementNotVisibleException ENV) {
			logger.error("Not Visible Element :" + element);
			Log.error("Not Visible Element :" + element + " Error :" + ENV);
			throw (ENV);
		}
	}
}

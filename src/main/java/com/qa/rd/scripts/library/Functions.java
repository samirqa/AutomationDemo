package com.qa.rd.scripts.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.rd.scripts.base.Base;
import com.qa.rd.scripts.utility.Log;

public class Functions extends Base {

	public static void Click(WebElement element) throws Exception {
		try {
			// Highlight the Element before Click
			Thread.sleep(1000);
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
			element.clear();
			Thread.sleep(2000);
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
			Thread.sleep(1000);
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

	public static void SelectByValue(WebElement element, String ListValue) throws Exception {
		try {
			Thread.sleep(1000);
			Select select = new Select(element);
			logger.info("Select Value :" + element.getTagName());
			select.selectByValue(ListValue);
			//((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
		} catch (org.openqa.selenium.ElementNotVisibleException ENV) {
			logger.error("Not Visible Element :" + element);
			Log.error("Not Visible Element :" + element + " Error :" + ENV);
			throw (ENV);
		}
	}
	public static void SelectByText(WebElement element, String ListValue) throws Exception {
		try {
			Thread.sleep(1000);
			Select select = new Select(element);
			logger.info("Select Value :" + element.getTagName());
			select.selectByVisibleText(ListValue);
			//((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
		} catch (org.openqa.selenium.ElementNotVisibleException ENV) {
			logger.error("Not Visible Element :" + element);
			Log.error("Not Visible Element :" + element + " Error :" + ENV);
			throw (ENV);
		}
	}
	public static void ScrollToView(WebElement element) throws Exception {
		try {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		//((JavascriptExecutor)driver).executeScript("window.scrollTo(" + element.getLocation().x + "," + element.getLocation().y + ")");
		Thread.sleep(1000);
		} catch (org.openqa.selenium.ElementNotVisibleException ENV) {
			logger.error("Unable to Scroll to element :" + ENV);
			Log.error("Not Visible Element :" + element + " Error :" + ENV);
			throw (ENV);
	    }
	}
	public static void selectOptionWithText(String textToSelect) {
		try {
			WebElement autoOptions = driver.findElement(By.id("ui-id-1"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			//int i = 0;
			for(WebElement option : optionsToSelect){
				if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+option.getText());
		            //driver.findElement(By.xpath("//@[id='ui-id-1']/li/a")).click();
		        	option.click();
		        	Thread.sleep(2000);
		            break;
		        }
				//i++;
		    }
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectLocationWithText(String textToSelect) {
		try {
			WebElement autoOptions = driver.findElement(By.id("ui-id-2"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+option.getText());
		        	driver.findElement(By.linkText(option.getText())).click();
		        	//driver.findElement(By.xpath("//@[id='ui-id-2']/li[2]/a/span")).click();
		            //option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 5);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}
	public static void WaitForPageLoad() throws Exception
    {
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//This loop will rotate for 100 times to check If page Is ready after every 1 second.
	    //You can replace your if you wants to Increase or decrease wait time.
		int waittime;
		waittime = 60;
	    for (int i=0; i<waittime; i++)
	    { 
	       try 
	        {
	    	   Thread.sleep(1000);
	        }catch (InterruptedException e) {} 
	        //To check page ready state.
	        if (js.executeScript("return document.readyState").toString().equals("complete"))
	        { 
	        	//System.out.println("Wait for Page Load : "+js.executeScript("return document.readyState").toString());
	            break; 
	        }   
	    }
	}
	
}
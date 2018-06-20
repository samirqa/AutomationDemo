package com.qa.rd.scripts.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.rd.scripts.base.Base;

public class Utils extends Base {

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	public static void waitForElement(WebElement element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			Log.error("Class Utils | Method waitForElement | Exception occured while Wait For Element : "
					+ e.getMessage());
			throw new Exception();
		}
	}

	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(ApplicationProperties.getInstance().getProperty("report.dir") + Constant.Path_ScreenShot + sTestCaseName + ".jpg"));
		} catch (Exception e) {
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
					+ e.getMessage());
			throw new Exception();
		}
	}

	public static String currentDateTime() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
		String dateN = formatter.format(currentDate.getTime()).replace("/", "_");
		String dateNow = dateN.replace(":", "_");
		return dateNow;
	}

	public static String currentDateYear() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd");
		String dateN = formatter.format(currentDate.getTime()).replace("/", "_");
		String dateYear = dateN.replace(":", "_");
		return dateYear;
	}

}

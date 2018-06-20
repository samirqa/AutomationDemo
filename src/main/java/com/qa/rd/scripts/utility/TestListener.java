package com.qa.rd.scripts.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.Status;
import com.qa.rd.scripts.base.Base;

public class TestListener extends TestListenerAdapter {
	WebDriver driver; 
	public Base base = new Base();
	private static String fileSeperator = System.getProperty("file.separator");

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");

		driver = Base.getDriver();

		String testClassName = getTestClassName(result.getInstanceName()).trim();

		String testMethodName = result.getName().toString().trim();
		String datetime = Utils.currentDateTime();
		String dateyear = Utils.currentDateYear();
		String screenShotName = testMethodName + "_" + datetime + ".png";
		if (driver != null) {
			String imagePath = getReportRoot() + Constant.Path_ScreenShot + fileSeperator + dateyear + fileSeperator + testClassName
					+ fileSeperator + takeScreenShot(driver, screenShotName, testClassName);
			System.out.println("Screenshot can be found : " + imagePath);
			try {
//				ExtentTest image = 
				Base.logger.addScreenCaptureFromPath(imagePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Base.logger.log(Status.FAIL, result.getName().toString().trim());
		}
	}
	
	private static String getReportRoot()
	{
		return ApplicationProperties.getInstance().getProperty("report.dir");
	}

	public static String takeScreenShot(WebDriver driver, String screenShotName, String testName) {
		try {
			String dateyear = Utils.currentDateYear();
			File file = new File(getReportRoot() +  Constant.Path_ScreenShot + fileSeperator + dateyear);
			if (!file.exists()) {
				System.out.println("File created " + file);
				file.mkdir();
			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File(getReportRoot() + Constant.Path_ScreenShot + fileSeperator + dateyear + fileSeperator + testName,
					screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);

			return screenShotName;
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
			return null;
		}
	}

	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}

}

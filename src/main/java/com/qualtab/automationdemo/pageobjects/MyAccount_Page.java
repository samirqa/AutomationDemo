package com.qualtab.automationdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//import utility.Log;
//import utility.Utils;
public class MyAccount_Page {

	@FindBy(how = How.XPATH, using = "//div[@id='center_column']")
	//div[@id='center_column']/h1
	public static WebElement MyAccount_Label;
	@FindBy(how = How.LINK_TEXT, using = "Sign out")
	public static WebElement SignOut_Link;
	@FindBy(how = How.XPATH, using ="//div[3]/div/ul/li/a/span")
	////div[3]/div/ul/li/a/span
	public static WebElement Home_btn;
	
}

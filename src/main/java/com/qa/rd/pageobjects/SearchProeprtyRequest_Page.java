package com.qa.rd.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchProeprtyRequest_Page {
	@FindBy(how = How.XPATH, using = "//header[@id='header']/div[2]/div[1]/div/ul/li[7]/a")
	public static WebElement SearchPropertyLead_Menu_Link;
	@FindBy(how = How.XPATH, using = "//div[@id='filter_box']/div[2]/div[1]/div/div/div/ul/li/input")
	public static WebElement Searchbox;
	@FindBy(how = How.XPATH, using = "//div[@id='prop_result_data']/div/div[1]/div[2]/a")
	public static WebElement SearchLead;
	@FindBy(how = How.XPATH, using = "//button[@id='btn_4a1cf468-a370-e811-80d9-00155d066203']")
	public static WebElement Viewbtn;	
	@FindBy(how = How.XPATH, using = "//span[@id='Rate_1_4']")
	public static WebElement GenuinityRate;
	@FindBy(how = How.XPATH, using ="//span[@id='Rate_3_5']")
	public static WebElement AccuracyRate;
	@FindBy(how = How.XPATH, using = "//span[@id='Rate_4_4']")
	public static WebElement ClerityRate;
	@FindBy(how = How.ID, using = "feedbackText")
	public static WebElement feedbackText;
	
	@FindBy(how = How.ID, using = "feedback_dtl")
	public static WebElement Feedbacksection;
	@FindBy(how = How.ID, using = "btnEditFeedback")
	public static WebElement EditFeedbackbtn;
	@FindBy(how = How.ID, using = "btn_4a1cf468-a370-e811-80d9-00155d066203")
	public static WebElement ViewContactbtn;
	@FindBy(how = How.ID, using = "btnFeedbackSubmit")
	public static WebElement FeedbackSumitbtn;
	
}

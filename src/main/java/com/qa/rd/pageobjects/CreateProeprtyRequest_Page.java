package com.qa.rd.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateProeprtyRequest_Page {

	@FindBy(how = How.XPATH, using = "//div[@id='filter_box']/div[3]/a")
	public static WebElement CreateRequest_Link;
	@FindBy(how = How.ID, using = "selBudgetMax")
	public static WebElement SelectMaxBudget;
	@FindBy(how = How.XPATH, using = "//div[@id='creReqDiv']/div[3]/div/div[3]/div/div/ul/li/input")
	public static WebElement Location;
	@FindBy(how = How.XPATH, using = "//[@id='divResiBedroom')/div[@class='range_slider_outer']/span[@class='irs js-irs-0']/span[@class='irs-slider single']")
	public static WebElement Bedroom_slider;
	@FindBy(how = How.XPATH, using = "//div[@id='creReqDiv']/div[3]/div/div[5]/div[2]/div/label")
	public static WebElement Bhk2Chk;
	@FindBy(how = How.XPATH, using = "//div[@id='creReqDiv']/div[3]/div/div[6]/div[2]/div/label")
	public static WebElement BathroomChk;
	@FindBy(how = How.XPATH, using = "//div[@id='creReqDiv']/div[3]/div/div[9]/div[1]/div/label")
	public static WebElement SaleNewChk;
	@FindBy(how = How.XPATH, using = "//div[@id='creReqDiv']/div[3]/div/div[10]/div[1]/div/label")
	public static WebElement ReadyToMoveChk;
	@FindBy(how = How.XPATH, using = "//div[@id='creReqDiv']/div[3]/div/div[12]/div[1]/div/label")
	public static WebElement FurnishedChk;
	@FindBy(how = How.XPATH, using = "//div[@id='creReqDiv']/div[3]/div/div[13]/div[1]/div/label")
	public static WebElement ImmediateChk;
	@FindBy(how = How.XPATH, using = "//div[@id='creReqDiv']/div[3]/div/div[19]/div[1]/div/label")
	public static WebElement ReservedParkingChk;
	@FindBy(how = How.XPATH, using = "//div[@id='creReqDiv']/div[3]/div/div[19]/div[14]/div/label")
	public static WebElement GymnasiumChk;
	@FindBy(how = How.XPATH, using ="//div[@id='creReqDiv']/div[3]/div/button[2]")
	public static WebElement CreateRequestbtn;
}

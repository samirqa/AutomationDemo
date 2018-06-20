package com.qa.rd.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PostProperty_Page {

	@FindBy(how = How.ID, using = "SocietyName")
	public static WebElement SocietyName;
	@FindBy(how = How.LINK_TEXT, using = "Post a Property")
	public static WebElement PostProperty_Link;
	@FindBy(how = How.XPATH, using = "//[@id='divResiBedroom')/div[@class='range_slider_outer']/span[@class='irs js-irs-0']/span[@class='irs-slider single']")
	public static WebElement Bedroom_slider;
	@FindBy(how = How.XPATH, using = "//[@id='divBathRoom')/div[@class='range_slider_outer']/span[@class='irs js-irs-1']/span[@class='irs-slider single']")
	public static WebElement Bathroom_slider;
	@FindBy(how = How.ID, using = "ddPriceInCrore")
	public static WebElement Price_Cr;
	@FindBy(how = How.ID, using = "ddPriceInLakh")
	public static WebElement Price_lakh;
	@FindBy(how = How.ID, using = "ddPriceInThousand")
	public static WebElement Price_Thousand;
	@FindBy(how = How.ID, using = "CarpetArea")
	public static WebElement CarpetArea;
	@FindBy(how = How.ID, using = "BuiltupArea")
	public static WebElement BuiltupArea;
	@FindBy(how = How.ID, using = "SuperBuiltupArea")
	public static WebElement SuperBuiltupArea;
	@FindBy(how = How.ID, using = "ddAreaUnitType")
	public static WebElement DD_Unit;
	@FindBy(how = How.ID, using = "Floors")
	public static WebElement TotalFloors;
	@FindBy(how = How.ID, using = "NumberOfFloor")
	public static WebElement NoOfFloor;
	@FindBy(how = How.LINK_TEXT, using = "Go to Step 2")
	public static WebElement GoToStep2_Link;
}

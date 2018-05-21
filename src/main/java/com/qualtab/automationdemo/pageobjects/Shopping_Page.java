package com.qualtab.automationdemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//import utility.Log;
//import utility.Utils;
public class Shopping_Page {

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'T-shirts')])[2]")
	public static WebElement TShirts_Tab;
	@FindBy(how = How.XPATH, using = "//div[@id='layered_block_left']/p")
	public static WebElement Catalog_Label;
	@FindBy(how = How.LINK_TEXT, using = "Faded Short Sleeve T-shirts")
	public static WebElement TShirt_Link;
	@FindBy(how = How.XPATH, using = "/div[@id='center_column']/div/div/div[3]/h1")
	public static WebElement TShirt_Label;
	@FindBy(how = How.ID, using ="layered_id_attribute_group_2")
	public static WebElement Size_M_CheckBox;
	@FindBy(how = How.ID, using ="selectProductSort")
	public static WebElement ProductSort_DropDown ;
	@FindBy(how = How.XPATH, using = "//p[@id='add_to_cart']/button")
	public static WebElement AddToCart_Submit;
	@FindBy(how = How.CSS, using ="a.button.ajax_add_to_cart_button.btn.btn-default > span")
	public static WebElement AddToCart_btn ;
	@FindBy(how = How.XPATH, using = "//div[@id='layer_cart']/div/div[2]/div[4]/a/span")
	public static WebElement ProccedCheckOut_btn; 
	@FindBy(how = How.XPATH, using ="//div[@id='layer_cart']/div/div/h2")
	public static WebElement AddToCart_Confirmation ;
	@FindBy(how = How.XPATH, using ="//div[@id='layer_cart']/div/div[2]/h2/span[2]")
	public static WebElement AddToCart_item_Confirmation;
	@FindBy(how = How.ID, using = "thumbs_list_frame")
	public static WebElement images;
	@FindBy(how = How.ID, using = "thumbnail_1")
	public static WebElement image1;
	@FindBy(how = How.CSS, using =".cross")
	public static WebElement Cross_btn;		
	//*[@id="thumbs_list_frame"]
	//Product successfully added to your shopping cart
	
}

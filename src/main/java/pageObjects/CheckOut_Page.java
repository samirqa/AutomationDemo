package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//import utility.Log;
//import utility.Utils;
public class CheckOut_Page {

	@FindBy(how = How.XPATH, using = "//tr[@id='product_1_1_0_61084']/td[2]/p/a")
	public static WebElement ProductName;
	@FindBy(how = How.ID, using = "total_price")
	public static WebElement total_price;
	@FindBy(how = How.XPATH, using = "//ul[@id='order_step']/li/span")
	public static WebElement Summary_tab;
	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/p[2]/a/span")
	public static WebElement ProceedToCheckOut_btn;
	@FindBy(how = How.LINK_TEXT, using ="03. Address")
	public static WebElement Address_tab;
	@FindBy(how = How.LINK_TEXT, using ="04. Shipping")
	public static WebElement Shipping_tab ;
	@FindBy(how = How.XPATH, using = "//p[@id='add_to_cart']/button")
	public static WebElement AddToCart_Submit;
	@FindBy(how = How.XPATH, using ="//body[@id='order']/div[2]/div/div/div/div/p")
	public static WebElement AgreeTerm_msg ;
	@FindBy(how = How.XPATH, using = "//div[@id='layer_cart']/div/div[2]/div[4]/a/span")
	public static WebElement ProccedCheckOut_btn; 
	@FindBy(how = How.XPATH, using ="//form[@id='form']/p/button")
	public static WebElement Agree_chkbox ;
	@FindBy(how = How.XPATH, using ="//header[@id='header']/div[3]/div/div/div[3]/div/a")
	public static WebElement Cart_Link;
	@FindBy(how = How.XPATH, using = "//header[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt/span/a")
	public static WebElement RemoveCart_Item;
	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/p")
	public static WebElement EmptyCart_msg;
}

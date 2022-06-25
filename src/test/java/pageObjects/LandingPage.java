package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage 
{
	private WebDriver driver;
	
	private By search = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	private By poroductName = By.xpath("//div[@class='product']//h4[@class='product-name']");
	private By deals = By.linkText("Top Deals");
	private By incrementbtn = By.linkText("+");
	private By addToCartBtn = By.xpath("//button[normalize-space()='ADD TO CART']");
	private By carticon = By.xpath("//a[@class='cart-icon']");
	private By proceedToCart = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public String getPageTitle()
	{
		return driver.getTitle();
	}
	public void searchProdudct(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(poroductName).getText();
	}
	
	public void openOfferPage()
	{
		driver.findElement(deals).click();
	}
	
	public String getPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void incrementItem()
	{
		driver.findElement(incrementbtn).click();
	}
	
	public void addToCart()
	{
		driver.findElement(addToCartBtn).click();
	}
	
	public void openCart()
	{
		driver.findElement(carticon).click();
	}
	
	public void openCheckout()
	{
		driver.findElement(proceedToCart).click();
	}
}

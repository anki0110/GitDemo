package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

public class PageObjectManager 
{
	private WebDriver driver;
	private LandingPage l;
	private OfferPage o;
	private CheckoutPage chkout;
	
	public PageObjectManager(WebDriver driver)
	{
		 this.driver = driver;
	}
	
	public LandingPage getLandingPage()
	{
		l = new LandingPage(driver);
		return l;
	}
	
	public OfferPage getOfferPage()
	{
		o = new OfferPage(driver);
		return o;
	}
	
	public CheckoutPage getCheckoutPage()
	{
		chkout = new CheckoutPage(driver);
		return chkout;
	}
}

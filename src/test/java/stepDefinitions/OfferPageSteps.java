package stepDefinitions;

import java.util.Iterator;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.ContextSetup;

public class OfferPageSteps 
{
	ContextSetup obj;
	public String offerstr;
	private LandingPage l;
	private OfferPage o;
	
	public OfferPageSteps(ContextSetup obj) {
		this.obj=obj;
		this.o = obj.pageObjectManager.getOfferPage();
		this.l = obj.pageObjectManager.getLandingPage();
	}

	@Then("^User searched for (.+) shortname in offers page to check if product exists$")
    public void user_searched_for_shortname_in_offers_page_to_check_if_product_exists(String prod)
	{
		switchToOffer();
		o.searchProduct(prod);
		List<WebElement> row = o.getRows();
		if(row.size()==2)
		{
			offerstr = o.getProduct();
		}
	}
	
	public void switchToOffer()
	{
		if(!l.getPageUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		{
			l.openOfferPage();
			obj.genericUtils.switchToChildWindow();
		}
	}
	
	@Then("validate if home page and offer page products are same")
	public void validate_if_home_page_and_offer_page_products_are_same() {
	   Assert.assertEquals(offerstr,obj.str);
	}
}

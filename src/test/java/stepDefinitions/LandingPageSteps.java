package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.ContextSetup;

public class LandingPageSteps 
{
	ContextSetup obj;
	LandingPage l;
	
	public LandingPageSteps(ContextSetup obj) 
	{
		this.obj = obj;
		this.l = obj.pageObjectManager.getLandingPage();
	}

	@Given("User is on Greencart landing page.")
	public void user_is_on_greencart_landing_page() 
	{
		Assert.assertTrue(l.getPageTitle().contains("GreenKart"));
	}
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string) 
	{
		l.searchProdudct(string);
		obj.str = l.getProductName().split(" - ")[0];
	}
	
	@When("^added \"([^\"]*)\" items of the selected products to cart and proceeds to checkout$")
    public void added_something_items_of_the_selected_products_to_cart(String str) throws InterruptedException
	{
		int n = Integer.parseInt(str);
		n-=1;
		Thread.sleep(2000);
		while(n!=0)
		{
    	   l.incrementItem();
    	   n--;
		}
		l.addToCart();
		l.openCart();
		l.openCheckout();
    }

}

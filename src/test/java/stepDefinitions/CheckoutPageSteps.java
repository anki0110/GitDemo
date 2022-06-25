package stepDefinitions;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.ContextSetup;

public class CheckoutPageSteps
{
	ContextSetup obj;
	CheckoutPage chk;
	
	public CheckoutPageSteps(ContextSetup obj) 
	{
		this.obj = obj;
		this.chk = obj.pageObjectManager.getCheckoutPage();
	}
	
    @Then("^validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_validate_the_items_in_checkout_page(String name) {
       
    }
    
    @And("^verify user has ability to enter promo code and place the order$")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() 
    {
    	Assert.assertTrue(chk.verifyPromoBtn());
    	Assert.assertTrue(chk.verifyPlaceOrder());
    }


}

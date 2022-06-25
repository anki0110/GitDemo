package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	private WebDriver driver;
	
	private By promoBtn = By.className("promoBtn");
	private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	public CheckoutPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public boolean verifyPromoBtn()
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(2));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(promoBtn));
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
}

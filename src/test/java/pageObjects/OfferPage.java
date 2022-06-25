package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfferPage 
{
	private WebDriver driver;
	public OfferPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By search = By.id("search-field");
	private By rows = By.xpath("//table[@class='table table-bordered']//tr");
	private By column = By.xpath("//td[1]");
	
	
	public void searchProduct(String prod)
	{
		driver.findElement(search).sendKeys(prod);
	}
	
	public List<WebElement> getRows()
	{
		return driver.findElements(rows);
	}

	public String getProduct()
	{
		return driver.findElements(rows).get(0).findElement(column).getText();
	}
	
}

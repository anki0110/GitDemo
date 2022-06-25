package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils 
{
	private WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	public void switchToChildWindow()
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parent = itr.next();
		driver.switchTo().window(itr.next());
	}
}

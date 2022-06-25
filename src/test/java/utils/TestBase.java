package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		
		String browser_properties = prop.getProperty("browser");
		String browser_mvn = System.getProperty("browser");
		
		String browser = (browser_mvn!=null) ? browser_mvn:browser_properties;
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","D:\\applications\\browser_driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","D:\\applications\\browser_driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(url);
			}
		}
		return driver;
	}
	
}

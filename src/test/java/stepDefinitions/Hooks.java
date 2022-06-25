package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ContextSetup;

public class Hooks 
{
	ContextSetup obj;
	
	public Hooks(ContextSetup obj)
	{
		this.obj = obj;
	}
	
	
	public void BeforeScenario()
	{
		System.out.println("------------------------------------");
	}
	@After
	public void AfterScenario() throws IOException
	{
		obj.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver = obj.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
			File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(fileContent,"image/png","image");
		}
	}
}

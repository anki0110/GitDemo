package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue="stepDefinitions",
		plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"},
		monochrome=true,
		tags="@offerpage or @placeorder",
		stepNotifications=true
)
public class TestNGRunnerTest
{
}

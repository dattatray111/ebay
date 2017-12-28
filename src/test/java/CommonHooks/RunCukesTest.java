package CommonHooks;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "classpath:features"
		,glue={"CommonHooks","stepDefination"},
		format = {"pretty","html:target/html/","json:target/cucumber.json"},
		tags = {"@demo111"}
		)
public class RunCukesTest extends AbstractTestNGCucumberTests {

}

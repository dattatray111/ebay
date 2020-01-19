package CommonHooks;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.ProductListPage;
import pageObjects.ProductPage;

public class Hooks {
	public static HomePage Objhomepage;
	public static ProductListPage Objproductlist;
	public static ProductPage Objproductpage;
	public static CheckOutPage Objcheckoutpage;
	public static WebDriver driver;
	public static String scenarioName;
	public static Logger Log = Logger.getLogger(Hooks.class.getName());
	public static PropertyReader properties;

	@cucumber.api.java.Before
	public void setUp(Scenario scenario) {
		PropertyConfigurator.configure("log4j.properties");
		scenarioName = scenario.getName();
		Log.info("executing scenario " + scenarioName);
		String OS = System.getProperty("os.name");
		Properties properties;
		
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			System.out.println(
					"==========================EXECUTION STARTED FOR " + scenarioName + "=======================");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Log.info("browser opened ");
			driver.manage().window().maximize();
			Log.info("browser maximaised ");
		
		
		Objhomepage = PageFactory.initElements(driver, HomePage.class);
		Objproductlist = PageFactory.initElements(driver, ProductListPage.class);
		Objproductpage = PageFactory.initElements(driver, ProductPage.class);
		Objcheckoutpage = PageFactory.initElements(driver, CheckOutPage.class);
	}

	@After
	public void cleanUp(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		}
		driver.quit();
		Log.info("Browser closed");
	}
}

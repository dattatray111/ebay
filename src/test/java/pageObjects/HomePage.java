package pageObjects;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.text.TabExpander;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import CommonHooks.PropertyReader;


public class HomePage
{
	protected WebDriver driver;
	Logger log;
	String baseUrl;
	PropertyReader properties;
	@FindBy(xpath = ".//*[@id='gh-ac']") private WebElement searchTextield;
	@FindBy(xpath = ".//*[@id='gh-btn']") private WebElement searchButton;
	
	public HomePage()
	{
		driver=CommonHooks.Hooks.driver;
		log = CommonHooks.Hooks.Log;
		properties = CommonHooks.Hooks.properties;
	}
	
	
	public void openhomePage() throws InterruptedException
	{
		driver.get(properties.getProperty("baseUrl"));
	}
	
	public void searchProduct(Map<String, String> data) throws InterruptedException
	{
		searchTextield.sendKeys(data.get("keyword"));
		searchButton.click();
	}
	
	
}

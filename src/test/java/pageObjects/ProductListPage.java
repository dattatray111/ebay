package pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.ls.LSInput;

import CommonHooks.Hooks;
import CommonHooks.PropertyReader;

public class ProductListPage 
{
	protected WebDriver driver;
	Logger log;
	String baseUrl;
	List<WebElement> prdList;
	PropertyReader properties;
	@FindBy(xpath = ".//ul[@id='ListViewInner']") private WebElement searchResult;
	@FindBy(xpath = ".//*[@id='smuys']/span/b/span") private WebElement filterText;
	
	
	public ProductListPage()
	{
		driver=CommonHooks.Hooks.driver;
		log = CommonHooks.Hooks.Log;
		properties = CommonHooks.Hooks.properties;
	}
	
	public void verifyPrdName() throws InterruptedException
	{
		Thread.sleep(2000);
		prdList = searchResult.findElements(By.xpath(".//*[contains(@class ,'sresult lvresult clearfix li')]"));
		System.out.println(prdList.size());
		for(int i=1;i<prdList.size();i++)
		{
			String Name = prdList.get(i).findElement(By.className("lvtitle")).getText();
			Name = Name.toUpperCase();
			//System.out.println(Name);
			if(!(Name.contains("SONY") && Name.contains("TV")))
			{
				System.out.println(Name);
			}
		}
	}
	
	public void applyFilter()
	{
		driver.findElement(By.xpath(".//div[contains(@class ,'search-guidance__text-item-title search-guidance__text-item-title--one-line') "
				+ "and contains(text(),'50')]")).click();
		assertTrue(filterText.isDisplayed()); 
		
	}
	
	public void verifyFilter()
	{
		assertTrue(filterText.isDisplayed());
	}
	
	public void clickOnProduct()
	{
		/*prdList = searchResult.findElements(By.xpath(".//*[contains(@class ,'sresult lvresult clearfix li')]"));
		int no = (int) (Math.random() * ( prdList.size() - 0 ));
		System.out.println(no + "++++++++++++++++++++++++++++++");
		prdList.get(no).findElement(By.className("lvtitle")).click();*/
	
		driver.findElement(By.xpath("//a[contains(text(),'4K Ultra HD HDR Smart tv FREE SHIPPING')]")).click();
	}
	
	
}

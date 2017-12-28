package pageObjects;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonHooks.PropertyReader;

public class CheckOutPage 
{
	protected WebDriver driver;
	Logger log;
	ProductPage productpage;
	PropertyReader properties;
	ProductDetails productdetails1;
	
	public CheckOutPage()
	{
		driver = CommonHooks.Hooks.driver;
		log = CommonHooks.Hooks.Log;
		properties = CommonHooks.Hooks.properties;
		productpage = CommonHooks.Hooks.Objproductpage;
	}
	
	public void infoOnchkOut()
	{
		WebElement cartDiv = driver.findElement(By.className("c-std"));
		String cartPname = cartDiv.findElement(By.xpath(".//*[@class='mr10']/div[1]")).getText();
		String cartSellerName = cartDiv.findElement(By.className("mbg-id")).getText();
		String pricetext = driver.findElement(By.xpath(".//*[@id='asynccartsummary']/div/table/tbody/tr[1]/td[2]")).getText();
		pricetext = pricetext.substring(pricetext.lastIndexOf("$")+1);
		pricetext = pricetext.replace(",", "");
		float price = Float.parseFloat(pricetext);
		
		assertTrue(productpage.productdetails.price==price, "price value matched");
		assertTrue(productpage.productdetails.productName.equalsIgnoreCase(cartPname), "product name value matched");
		assertTrue(productpage.productdetails.sellerName.equalsIgnoreCase(cartSellerName), "sellername value matched");
		
		driver.findElement(By.id("ptcBtnRight")).click();
		driver.findElement(By.id("gtChk")).click();
	}
	
	public void infoOnguestchkOut() throws InterruptedException
	{
		WebElement cartDiv = driver.findElement(By.className("seller-item-group"));
		String cartPname = driver.findElement(By.xpath(".//div[contains(@class,'col-xs-9 item-title')]")).getText();
		Thread.sleep(500);
		String cartSellerName = driver.findElement(By.xpath(".//*[@id='seller-info']/div[1]")).getText();
		String pricetext = driver.findElement(By.className("item-price")).getText();
		
		cartSellerName = cartSellerName.substring(cartSellerName.lastIndexOf(":")+1);
		System.out.println("cartSellerName  "+cartSellerName);
		
		pricetext = pricetext.substring(pricetext.lastIndexOf("$")+1);
		
		pricetext = pricetext.replace(",", "");
		float price = Float.parseFloat(pricetext);
		
		assertTrue(productpage.productdetails.price==price, "price value matched");
		assertTrue(productpage.productdetails.productName.equalsIgnoreCase(cartPname), "product name value matched");
		assertTrue(productpage.productdetails.sellerName.equalsIgnoreCase(cartSellerName.trim()), "sellername value matched");
		
	}
}

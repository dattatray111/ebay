package pageObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonHooks.PropertyReader;

public class ProductPage {
	protected WebDriver driver;
	Logger log;
	String baseUrl;
	String productName;
	float productPrice;
	String sellerName;
	ProductDetails productdetails;
	PropertyReader properties;
	
	
	@FindBy(xpath = ".//*[@id='CenterPanelInternal']") private WebElement productPanel;
	@FindBy(xpath = ".//*[@id='isCartBtn_btn']") private WebElement addtocart;
	
	
	public ProductPage() {
		driver = CommonHooks.Hooks.driver;
		log = CommonHooks.Hooks.Log;
		properties = CommonHooks.Hooks.properties;
	}

	public void getPrdInfo() throws InterruptedException {
		Thread.sleep(1000);
		productName = driver.findElement(By.xpath(".//*[@id='itemTitle']")).getText();
		
		WebElement timedue = productPanel.findElement(By
				.xpath(".//*[@class='u-flL']"));
		if(timedue.isDisplayed())
		{
			if (timepatternmatch(timedue.getText()))
			{
				System.out.println("duration is in correct pattern");
			}
		}
		
		Thread.sleep(1000);
		WebElement price;
		try{
			 price = productPanel.findElement(By
					.xpath(".//*[@id='mm-saleDscPrc']"));
		}
		catch(Exception e)
		{
			 price = productPanel.findElement(By
						.xpath(".//*[@id='prcIsum']"));
		}
		
		String pricetext = price.getText();
		pricetext = pricetext.substring(pricetext.lastIndexOf("$")+1);
		pricetext = pricetext.replace(",", "");
		productPrice = Float.parseFloat(pricetext);
		
		if (timepatternmatch(price.getText()))
		{
			System.out.println("price is in correct format");
		}
		
		sellerName =driver.findElement(By.className("mbg-nw")).getText();
		addtocart.click();
		
		productdetails = new ProductDetails(productName,productPrice,sellerName);
		productdetails.display();
		
	}

	public boolean timepatternmatch(String s) {
		Pattern p = Pattern.compile("^[0-9]{2}[dhm] [0-9]{2}[hms].*$");

		Matcher m = p.matcher(s);
		boolean b = m.matches();
		System.out.println(b);
		return b;
	}
	
	public boolean pricepatternmatch(String s) {
		Pattern p = Pattern.compile("^US $[0-9]{1,4}.[0-9]{2}.*$");
		Matcher m = p.matcher(s);
		boolean b = m.matches();
		System.out.println(b);
		return b;
	}

}

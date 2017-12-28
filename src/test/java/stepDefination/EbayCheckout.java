package stepDefination;



import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import CommonHooks.*;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.ProductListPage;
import pageObjects.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class EbayCheckout {
	protected WebDriver driver;
	protected HomePage homepage;
	protected ProductListPage productlistpage;
	protected ProductPage productpage;
	protected CheckOutPage chkoutpage;
	public List<Map<String, String>> data;
	Logger log;
	
	public EbayCheckout() {
		driver = Hooks.driver;
		homepage = Hooks.Objhomepage;
		productlistpage = Hooks.Objproductlist;
		productpage = Hooks.Objproductpage;
		chkoutpage = Hooks.Objcheckoutpage;
		log = Hooks.Log;
	}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		homepage.openhomePage(); 
	}
	
	@And("^User search for keyword$")
	public void user_search_for_product(Map<String, String> dataMap)throws Throwable {
		homepage.searchProduct(dataMap);
	}
	
	@Then("^verify that search result displayed correctly$")
    public void verify_that_search_result_displayed_correctly() throws Throwable {
		productlistpage.verifyPrdName();
    }
	
	@Then("^user select the filter$")
    public void user_appliy_filter() throws Throwable {
		productlistpage.applyFilter();
    }
	
	@Then("^Verify that search result displayed as per filter$")
    public void verify_filter() throws Throwable {
		productlistpage.verifyFilter();
    }
	
	@When("^user select the product$")
    public void select_product() throws Throwable {
		productlistpage.clickOnProduct();
    }
	
	@Then("^verify the product information$")
    public void verify_proInfo() throws Throwable {
		productpage.getPrdInfo();
    }
	
	@Then("^verify that value on product page and checkout page are same$")
    public void verify_proInfo1() throws Throwable {
		chkoutpage.infoOnchkOut();
    }
	
	@Then("^verify that value on product page and guest checkout page are same$")
    public void verify_proInfo2() throws Throwable {
		chkoutpage.infoOnguestchkOut();
    }
	
	
	

}
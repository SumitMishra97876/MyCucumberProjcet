package stepdefs;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.SearchPage;

public class AddToCart extends TestBase {
	
	
	
	
	@Given("user logs into account using valid username and password")
	public void user_logs_into_account_using_valid_username_and_password() {
		
		setup();
		getUrl();
		hp=new HomePage(driver);
	    hp.clickMyAccount();
	    lp=hp.lnkLogin();
	    String uname=rb.getString("username");
	    String pass=rb.getString("password");
	    
	    lp.doLogin(uname, pass);
	}
	@When("user searches for a product {string} on My Account page")
	public void user_searches_for_a_product_on_my_account_page(String string) {
		
		mp=new MyAccountPage(driver);
	    mp.doProductSearch(string);
	    
	}
	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		mp.clickSearchButton();
	    
	}
	@When("user clicks on product {string}")
	public void user_clicks_on_product(String string) {
	    
		sp=new SearchPage(driver);
		sp.selectProductToAdd(string);
		
	}
	@When("user clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() {
	    sp.addProductToCart();
	}
	@Then("the product {string} should be added to cart with a successful message")
	public void the_product_should_be_added_to_cart_with_a_successful_message(String string) {
	    String message=sp.addToCartSuccessMessage();
	    System.out.println(message);
	    
	    if(message.contains("Success: You have added " + string + " to your shopping cart!"))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}
	
	@After("@AddtoCart")
	public void close()
	{
       
       teardown();
	}
	
	




}

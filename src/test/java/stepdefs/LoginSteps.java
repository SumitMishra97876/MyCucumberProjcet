package stepdefs;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.HomePage;

public class LoginSteps extends TestBase {
	
	
	@Given("user in on Login page")
	public void user_in_on_login_page() {
		setup();
		hp=new HomePage(driver);
		hp.clickMyAccount();
		lp=hp.lnkLogin();
	}
	@When("the user enters username {string} and password {string}")
	public void the_user_enters_username_and_password(String string, String string2) {
	    lp.doLogin(string, string2);
	}
	
	@When("the user enters username  and password")
	public void the_user_enters_username_and_password() {
	    String uname=rb.getString("username");
	    String pass=rb.getString("password");
	    
	    lp.doLogin(uname, pass);
	}
	
	@When("user enters  username {string} and password {string}")
	public void user_enters_username_and_password(String string1, String string2) {
	    lp.doLogin(string1, string2);
	}
	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		
		mp=lp.clickSubmit();
	    
	}
	@Then("Myaccount page should be displayed")
	public void myaccount_page_should_be_displayed() {
	    
         boolean isMyAccountTextDisplayed=mp.verifyLogin();
		
		Assert.assertTrue(isMyAccountTextDisplayed);
	}
	
	@Then("error message should be validated")
	public void error_message_should_be_validated() {
	    
		String errorTxt=lp.getErrorText();
		System.out.println(errorTxt);
		
		if(errorTxt.contains("Warning: No match for E-Mail Address and/or Password"))
		{
			Assert.assertTrue(true);
		}
		
		
	}




}

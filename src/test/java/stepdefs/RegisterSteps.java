package stepdefs;

import java.util.List;
import java.util.Map;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.HomePage;
import utils.ExcelReader;

public class RegisterSteps extends TestBase {
	
	
	
	@Given("user is on Registration page")
	public void user_is_on_registration_page() {
		
		
		setup();
		getUrl();
		hp=new HomePage(driver);
		hp.clickMyAccount();
		rp=hp.clickRegisterLink();
		
	    
	}
	@When("user enter details from excel {string}")
	public void user_enter_details_from_excel(String row) {
		
		String filePath=rb.getString("filepath");
		
		
	//List<Map<String,String>>dataMap=ExcelReader.data(System.getProperty("user.dir")+"\\src\\test\\resources\\Book1.xlsx", "Sheet1");
	List<Map<String,String>>dataMap=ExcelReader.data(filePath, "Sheet1");
	
	int index=Integer.parseInt(row)-1;
	
	String firstname=dataMap.get(index).get("FirstName");
	String lastname=dataMap.get(index).get("LastName");
	String email=dataMap.get(index).get("E-Mail");
	String telephone=dataMap.get(index).get("Telephone");
	String pass=dataMap.get(index).get("Password");
	String cnfPass=dataMap.get(index).get("PasswordConfirm");
	
	rp.addDetails(firstname, lastname, email, telephone, pass, cnfPass);
	
		
	    
	}
	
	@When("user checks on privacy checkbox")
	public void user_checks_on_privacy_checkbox() {
	   rp.clickPrivacyCheckbox();
	}
	
	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		rp.clickContinue();
	   
	}
	@Then("user should be registered with a successful message")
	public void user_should_be_registered_with_a_successful_message() {
	   String AccountSuccessMsg= rp.successMessage();
	   
	   Assert.assertEquals(AccountSuccessMsg, "Your Account Has Been Created!");
	   
	}
	
	@After("@Register")
	public void close()
	{
       
       teardown();
	}




}

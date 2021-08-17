package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
	
	public WebDriver driver;
	
	public Registration(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-firstname")
	WebElement firstname;
	
	@FindBy(id="input-lastname")
	WebElement lastname;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirm;
	
	
	@FindBy(xpath="//input[@type='submit' and @value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement successMessage;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	WebElement privacyCheckBox;
	
	
	
	
	
	public void addDetails(String fname,String lname,String mail,String tele,String pass,String conf)
	{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(mail);
		telephone.sendKeys(tele);
		password.sendKeys(pass);
		confirm.sendKeys(conf);
		
		
		
	}
	
	public void clickContinue()
	{
		continueButton.click();
	}
	
	public String successMessage()
	{
		return successMessage.getText();
	}
	
	public void clickPrivacyCheckbox()
	{
		privacyCheckBox.click();
	}

}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement txtEmailAddress;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorText;
	
	
	public void doLogin(String email,String password)
	{
		txtEmailAddress.sendKeys(email);
		txtPassword.sendKeys(password);
		
	}
	public MyAccountPage clickSubmit()
	{
		btnLogin.click();
		return new MyAccountPage(driver);
	}
	
	public String getErrorText()
	{
		String text=errorText.getText();
		return text;
	}
	
	

}

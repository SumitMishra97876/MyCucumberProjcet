package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(linkText="Register")
	WebElement lnkRegister;
//	
//	By lnkMyAccount=By.xpath("//span[text()='My Account']");
//	By lnkRegister=By.linkText("Register");
	
	@FindBy(linkText="Login")
	WebElement homeLogin;
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
		//driver.findElement(lnkMyAccount).click();
	}
	
	public LoginPage lnkLogin()
	{
		homeLogin.click();
		return new LoginPage(driver);
	}
	
	public Registration clickRegisterLink()
	{
		lnkRegister.click();
		return new Registration(driver);
	}
}

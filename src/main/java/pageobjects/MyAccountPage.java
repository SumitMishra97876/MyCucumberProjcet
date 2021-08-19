package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	public WebDriver driver;
	
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement MyAccText;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement searchBar;
	
	@FindBy(xpath="//div[@id='search']/span//button")
	WebElement searchButton;
	
	
	public boolean verifyLogin()
	{
		try
		{
		return (MyAccText.isDisplayed());
		
		//return actText;
		}
		catch(Exception e)
		{
			return(false);
		}
	}
		
	public void doProductSearch(String prodName)
	{
		searchBar.sendKeys(prodName);
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}

}


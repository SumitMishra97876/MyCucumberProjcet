package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	
	
WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	@FindBy(linkText="MacBook Pro")
//	WebElement product;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;	
	
	public void selectProductToAdd(String pname)
	{
		driver.findElement(By.linkText(pname)).click();
	}
	
	public void addProductToCart()
	{
		addToCart.click();
	}
	
	public String addToCartSuccessMessage()
	{
		return successMessage.getText();
	}

}

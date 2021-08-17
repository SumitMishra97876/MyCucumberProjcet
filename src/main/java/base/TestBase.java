package base;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.Registration;

public class TestBase {
	
	
	public WebDriver driver;
	 public Base b;
	public  HomePage hp;
	public  LoginPage lp;
	public MyAccountPage mp;
	public Registration rp;
	 
	 
	 public ResourceBundle rb;
	 
	 public void setup()
	 {
		 rb=ResourceBundle.getBundle("config");
		 b=new Base();
		 
		 driver=b.init();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 driver.get(rb.getString("url"));
		 
		 
	 }
	
	
	
	

}

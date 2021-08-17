package base;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	public WebDriver driver;
	
	public ResourceBundle rb;
	
	public WebDriver init()
	{
		rb=ResourceBundle.getBundle("config");
		String br=rb.getString("browser");
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			System.out.println("please enter supported driver");
		}
		
		
		
		return driver;
	}
	
	
	

}

package seleniumexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	WebDriver driver;
	
	public TestBase()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.get("http://www.google.com/");
		 
	}
	
}

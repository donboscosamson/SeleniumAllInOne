package seleniumexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.ExtemtReportListener;

@Listeners(ExtemtReportListener.class)
public class ExtentSecondReportTest {
	WebDriver wd;
	
@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
		 wd = new ChromeDriver();
		wd.get("http://www.google.com/");

	}
@Test
public void validatelogo()
{
	Assert.assertTrue(true);

}
@Test
public void clickGmail()
{
	Assert.assertTrue(false);
}

@AfterTest
public void tearDown()
{
	
	wd.close();
}


}

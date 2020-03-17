package seleniumexample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest {
	
	public static void main(String[] args)
	{

		try {
			webtableEx1();
	//		webtableEx2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void webtableEx1() {
		WebDriver wd;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
		 wd = new ChromeDriver();
		 wd.get("http://demo.guru99.com/test/web-table-element.php");
		List<WebElement>cols= wd.findElements(By.xpath(".//div[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println(cols.size());
		List<WebElement> rows=wd.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		System.out.println(rows.size());
		
	/*	for(int i=1;i<=rows.size();i++)
		{
			 WebElement el=wd.findElement(By.xpath("//div[@id='leftcontainer']/table[@class='dataTable']/tbody/tr["+i+"]/td[1]/a"));
			System.out.println(i +" : "+ el.getText());
		}*/
		StringBuilder rowvalues=null;
		for(int i=1;i<=rows.size();i++)
		{rowvalues  = new StringBuilder();
			for(int j=1;j<=cols.size();j++)
			{
				 WebElement el=wd.findElement(By.xpath("//div[@id='leftcontainer']/table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]"));
				// System.out.println(el.getText());
				 
				 rowvalues.append(el.getText());
				 rowvalues.append("\t");
				 
			}
			System.out.println(rowvalues);
			System.out.println("----------------------");
			
		}
	}

	public static void webtableEx2() throws Exception {
		WebDriver wd;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
		 wd = new ChromeDriver();
		wd.get("http://demo.automationtesting.in/WebTable.html");
		List<WebElement>cols= wd.findElements(By.xpath("//div[@class='ui-grid-header-cell-row']/div"));
		System.out.println(cols.size());
		List<WebElement> rows=wd.findElements(By.xpath("//div[@class='ui-grid-canvas']/div"));
		System.out.println(rows.size());
			Thread.sleep(200);
			// TODO Auto-generated catch block
		WebElement we1 = wd.findElement(By.cssSelector("div.ui-grid-canvas :nth-child(1) div.ng-isolate-scope :nth-child(2) > div"));
		System.out.println(we1.getText());
	}
}

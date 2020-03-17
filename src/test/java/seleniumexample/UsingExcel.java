package seleniumexample;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelUtility;

public class UsingExcel {

	@DataProvider(name = "loginData")
	public Object[][] dataProvider() {
		Object[][] testData = null;
		try {
			testData = ExcelUtility.getData("C:\\Users\\donbo\\Documents\\TestData.xlsx");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return testData;
	}

	@Test(dataProvider = "loginData")
	public void testUsingExcel(String username, String password, String result, String rempass) throws Exception {

		System.out.println(username + " : " + password + " : " + result + " : " + rempass);
	}

}
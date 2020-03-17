package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.sun.jna.platform.FileUtils;

import seleniumexample.ExtentReportTest;

public class ExtemtReportListener implements ITestListener{

	private static ExtentReports extent = ExtentManager.getInstance("test-output/extent.html");
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
    @Override
	public synchronized void onStart(ITestContext context) {
    	ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}
	
	@Override
	public synchronized void onTestStart(ITestResult result) {
		ExtentTest child = parentTest.get().createNode(result.getTestClass().getName()+":"+result.getMethod().getMethodName());
        test.set(child);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		test.get().pass("Test passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		try {
			 //Get driver from BaseTest and assign to local webdriver variable.
			Object testClass = result.getInstance();
		    WebDriver webDriver = ((ExtentReportTest) testClass).getDriver();
		    String methodName =System.getProperty("user.dir")+ "/screenshots/screenshot.png";
		    String temp = takeSnapShot(webDriver,methodName );
			test.get().fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		test.get().skip(result.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public static String takeSnapShot(WebDriver webdriver, String fileWithPath) {

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		System.out.println("File out put"+DestFile.getAbsolutePath());
		try {
			org.apache.commons.io.FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DestFile.getAbsolutePath();
	}
}




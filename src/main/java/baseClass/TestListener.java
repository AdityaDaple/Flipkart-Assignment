package baseClass;

import baseClass.ReportManager;
import com.aventstack.extentreports.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import baseClass.Utility.*;
public class TestListener implements ITestListener {

	public static ExtentReports extent = ReportManager.getExtendReport();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	public static WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
		System.out.println("********** Test Case Start ***************");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
		// Take screenshot on failure
			String screenshotPath = Utility.takeScreenshot( result.getMethod().getMethodName());
			try {
				test.get().addScreenCaptureFromPath(screenshotPath);
			} catch (Exception e) {
				test.get().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
			}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
		test.get().log(Status.FAIL, result.getThrowable());

			String screenshotPath = Utility.takeScreenshot(result.getMethod().getMethodName());
			try {
				test.get().addScreenCaptureFromPath(screenshotPath);
			} catch (Exception e) {
				test.get().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public static ExtentTest objectRepo() {
		return test.get();
	}

	
}

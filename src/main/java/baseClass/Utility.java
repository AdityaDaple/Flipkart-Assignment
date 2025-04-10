package baseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility extends BaseClass {
	
	public static String takeScreenshot(String screenshotName) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + "_" + timestamp
				+ ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}

		return filePath;
	}
}

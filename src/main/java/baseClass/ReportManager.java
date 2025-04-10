package baseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

	public static ExtentReports extent;
	public static	 ExtentSparkReporter spark;

	public static ExtentReports getExtendReport() {

		 // Add timestamp to report name
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String filePath = System.getProperty("user.dir") + "\\Reports\\Report_" + timestamp + ".html";

	    // Create SparkReporter and set its config
	     spark = new ExtentSparkReporter(filePath);
	    spark.config().setDocumentTitle("Automation Test Report");
	    spark.config().setReportName("Sanity Test Execution - " + timestamp); 
	    spark.config().setTheme(Theme.STANDARD);

	    // Attach reporter to ExtentReports
	    extent = new ExtentReports();
	    extent.attachReporter(spark);

	    // Add system information
	    
	    extent.setSystemInfo("OS", System.getProperty("os.name"));
	    extent.setSystemInfo("Tester Name", "Aditya"); // Replace with actual name if needed
	    extent.setSystemInfo("Environment", "QA");

	    return extent;
	}
}

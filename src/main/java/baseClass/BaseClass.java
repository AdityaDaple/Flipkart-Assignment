package baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.pages.Fitpage_pom;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		String browser = ConfigrationManager.getProperty("browser");
		launchBrowser(browser);
		driver.manage().window().maximize();
		driver.get(ConfigrationManager.getProperty("url"));
		System.out.println("Launch browser and Navigate to :"+ConfigrationManager.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

	}

	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}

	public void launchBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("❌ Unsupported browser: " + browserName + ". Launching Chrome by default.");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}
}

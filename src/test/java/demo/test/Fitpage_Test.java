package demo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import baseClass.ConfigrationManager;
import baseClass.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.pages.Fitpage_pom;
@Listeners(TestListener.class)
public class Fitpage_Test extends BaseClass {

   

    @Test
    public void logIn_Test() {
    	Fitpage_pom ref= new Fitpage_pom(driver);
    	ref.logInFlow();
    	System.out.println(ConfigrationManager.getProperty("url"));
    }
    @Test
    public void logIn_Test1() {
    	System.out.println(m1()+m1());
    }
    
    public int m1() {
    	System.out.println("************M1***********");
		return 5;
    }
}

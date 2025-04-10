package demo.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import baseClass.TestListener;

import java.time.Duration;

public class Fitpage_pom {

    private WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "(//input[@id='email'])[1]")
    private WebElement EmailAddressField;
    
    @FindBy(xpath ="(//button[text()='Get OTP'])[1]")
    private WebElement GetOptBtn;
    
    @FindBy(xpath ="//input[@maxlength='1']")
   List <WebElement> OtpField;
    
    @FindBy(xpath ="//button[text()='Verify OTP']")
    private WebElement VerifyOtpBtn;
    
    @FindBy(xpath ="//input[@id='firstName']")
    private WebElement FirstNameField;
    
    @FindBy(xpath ="//input[@id='lastName']")
    private WebElement LastNameField;
    
    @FindBy(xpath ="//input[@placeholder='Mobile number']")
    private WebElement MobileNumberField;
    
    @FindBy(xpath ="//input[@id='organization-name']")
    private WebElement OrgnizationNameField;
    
    @FindBy(xpath ="//button[text()='Continue']")
    private WebElement ContinueBtn;
    
    
//    @FindBy(xpath ="//input[@id='otp1']")
//    private WebElement OtpField2;
//    
//    @FindBy(xpath ="//input[@id='otp2']")
//    private WebElement OtpField3;
//    
//    @FindBy(xpath ="//input[@id='otp3']")
//    private WebElement OtpField4;

    public Fitpage_pom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void logInFlow(){
    	
    	TestListener.objectRepo().log(Status.PASS, "Step info1 ");
    	TestListener.objectRepo().log(Status.INFO, "Step info2 ");
    	TestListener.objectRepo().log(Status.FAIL, "Step info3 ");
    	wait.until(ExpectedConditions.elementToBeClickable(ContinueBtn));
    	
//    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	wait.until(ExpectedConditions.elementToBeClickable(EmailAddressField));
//    	System.out.println("Enetr Email ID");
//        EmailAddressField.sendKeys("Test12@gmail.com");
//        System.out.println("Email ID Entered");
//        System.out.println("Click on Get OTP button");
//        GetOptBtn.click();
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        String otp = "1234";
//        for (int i = 0; i < otp.length(); i++) {
//        	OtpField.get(i).sendKeys(Character.toString(otp.charAt(i)));
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(VerifyOtpBtn));
//        VerifyOtpBtn.click();
    }
    
    
}

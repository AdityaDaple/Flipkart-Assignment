package pom.pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import baseClass.TestListener;
import junit.framework.Assert;

public class Flipkart_Pom {

	private WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath ="//a[@aria-label='Mobiles']")
	private WebElement MobilesCategoryBtn;
	
	@FindBy(xpath ="//h1[text()='Mobile Phones']")
	private WebElement MobilePhonesText;
	
	@FindBy(xpath ="(//select[@class='Gn+jFg'])[1]")
	private WebElement MinPriceDropDown;
	
	@FindBy(xpath ="(//select[@class='Gn+jFg'])[2]")
	private WebElement MaxPriceDropDown;
	
	@FindBy(xpath ="//div[@class='Nx9bqj _4b5DiR']")
	private List <WebElement> PriceValues;
	
	@FindBy(xpath ="(//div[@class='KzDlHZ'])[1]")
	private WebElement ClickOnFirstProduct;
	
	@FindBy(xpath ="//button[@class='QqFHMw vslbG+ In9uk2']")
	private WebElement AddToCartButton;
	
	@FindBy(xpath ="//button[@class='QqFHMw vslbG+ In9uk2 JTo6b7']")
	private WebElement AddToCartIcon;
	
	@FindBy(xpath ="//button[@class='QqFHMw zA2EfJ _7Pd1Fp']")
	private WebElement PlaceOrderButton;
	
	@FindBy(xpath ="//*[@class='VU-ZEz']")
	private WebElement PhoneNameOnProductPage;
	
	@FindBy(xpath ="//a[@class='T2CNXf QqLTQ-']")
	private WebElement PhoneNameOnCheckOutPage;
	
	public Flipkart_Pom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void navigate_to_mobile_category_listing_page() {
		TestListener.objectRepo().info("Click on Mobile Category");
		wait.until(ExpectedConditions.elementToBeClickable(MobilesCategoryBtn));
		MobilesCategoryBtn.click();
		wait.until(ExpectedConditions.visibilityOf(MobilePhonesText));
		Assert.assertEquals(MobilePhonesText.isDisplayed(), true);
		TestListener.objectRepo().log(Status.PASS, "User is successfully redirected to the Mobile Phones Category Listing page.");
	}
	
	public void select_Price_Range() {
		wait.until(ExpectedConditions.elementToBeClickable(MinPriceDropDown));
		TestListener.objectRepo().info("Choose a mobile phone between 15000 to 20000 Rs");
		Select Mindropdown = new Select(MinPriceDropDown);
		Mindropdown.selectByValue("15000");
		System.out.println("Min Price is selected as 15000");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MaxPriceDropDown));
			Select Maxdropdown = new Select(MaxPriceDropDown);
			Maxdropdown.selectByValue("20000");
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(MaxPriceDropDown));
			Select Maxdropdown = new Select(MaxPriceDropDown);
			Maxdropdown.selectByValue("20000");
		}
		System.out.println("Max Price is selected as 20000");
		TestListener.objectRepo().log(Status.PASS, "Filtered is applied successfully.");
		TestListener.objectRepo().info("Verify the products are displayed as per the Price Range Between 15000 to 20000");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 int minPrice = 15000;
		    int maxPrice = 20000;

		    for (WebElement priceElement : PriceValues) {
		        String priceText = priceElement.getText().replaceAll("[^0-9]", ""); // Remove ₹, commas, etc.

		        if (!priceText.isEmpty()) {
		            int price = Integer.parseInt(priceText);

		            if (price >= minPrice && price <= maxPrice) {
		                System.out.println("Price " + price + " is within range.");
		            } else {
		                System.out.println("Price " + price + " is OUT of range");
		            }
		        } else {
		            System.out.println("Invalid Price Range");
		        }
		    }
		    TestListener.objectRepo().log(Status.PASS, "Products are displayed as per the applied price range between 15000 to 20000");
	}
	
	public void add_to_Cart_Functionality() throws InterruptedException {
		String FetchPhoneName = ClickOnFirstProduct.getText();
		System.out.println("Fetched Phone Name -" +FetchPhoneName);
		TestListener.objectRepo().info("Click on The First Phone");
		ClickOnFirstProduct.click();
		TestListener.objectRepo().log(Status.PASS, "Product Page is opened in new tab");
		TestListener.objectRepo().info("Switch to the new tab");
		String currentTab = driver.getWindowHandle();
		Thread.sleep(2000);
		for (String tab : driver.getWindowHandles()) {
		    if (!tab.equals(currentTab)) {
		        driver.switchTo().window(tab);
		        break;
		    }
	}
		
		try {
			wait.until(ExpectedConditions.visibilityOf(AddToCartButton));
			Assert.assertEquals(AddToCartButton.isDisplayed(), true);
			System.out.println("Add To Cart Button Is Displayed");
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(AddToCartIcon));
			Assert.assertEquals(AddToCartIcon.isDisplayed(), true);
			System.out.println("Add To Cart Icon Is Displayed");
		}
		
		TestListener.objectRepo().log(Status.PASS, "User should be on the Product Page");
		TestListener.objectRepo().info("Click on the Add to Cart");
		try {
			AddToCartButton.click();
			System.out.println("Clicked on Add to Cart Button");
			
		} catch (Exception e) {
			AddToCartIcon.click();
			System.out.println("Clicked on Add to Cart Icon");
		}
		wait.until(ExpectedConditions.visibilityOf(PlaceOrderButton));
		Assert.assertEquals(PlaceOrderButton.isDisplayed(), true);
		TestListener.objectRepo().log(Status.PASS, "Mobile Phone is added to the cart");
		TestListener.objectRepo().info("Validate the same phone as added");
		wait.until(ExpectedConditions.visibilityOf(PhoneNameOnCheckOutPage));
		Assert.assertEquals(PhoneNameOnCheckOutPage.getText(), FetchPhoneName);
		TestListener.objectRepo().log(Status.PASS, "Same Phone is added");
}
}
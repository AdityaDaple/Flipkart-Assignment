package demo.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import baseClass.TestListener;
import pom.pages.Flipkart_Pom;

@Listeners(TestListener.class)

public class Flipkart_Test extends BaseClass {
	@Test
	public void flipkart_Assignment() throws InterruptedException {
		Flipkart_Pom ref = new Flipkart_Pom(driver);
		ref.navigate_to_mobile_category_listing_page();
		ref.select_Price_Range();
		ref.add_to_Cart_Functionality();
	}

}

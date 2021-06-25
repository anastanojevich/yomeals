package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{

	@Test
	public void addMealToCartTest() throws InterruptedException {
		driver.get(this.baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPage.closePopup();
		mealPage.addToCart(3);
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "The Following Errors Occurred:\r\n" + 
				"Please Select Location\r\n");
		notificationPage.waitUntilMessageDissapears();
		locationPage.getLocationItem("City Center - Albany");
		mealPage.addToCart(3);
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Meal Added To Cart");
		notificationPage.waitUntilMessageDissapears();
	}
	
	
	
	
	
	
	
}

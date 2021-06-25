package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{

	@Test
	public void addMealToCartTest() throws InterruptedException {
		driver.get(this.baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPage.closePopup();
		mealPage.addToCart(3.0);
		Thread.sleep(2000);
		Assert.assertTrue(notificationPage.getMessageText().contains("The Following Errors Occurred:")); 
		Assert.assertTrue(notificationPage.getMessageText().contains("Please Select Location"));
		notificationPage.waitUntilMessageDissapears();
		
		Thread.sleep(2000);
		locationPage.clickLocationHeader();
		Thread.sleep(2000);
		locationPage.setLocationName("City Center - Albany");
		
		mealPage.addToCart(3.0);
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Meal Added To Cart");
		notificationPage.waitUntilMessageDissapears();
	}
	
	
	@Test
	public void addMealToFavorite() throws InterruptedException {
		driver.get(this.baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPage.closePopup();
		mealPage.addToFavorite();
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Please login first!");
		notificationPage.waitUntilMessageDissapears();
		
		driver.get(this.baseURL + "guest-user/login-form");
		Thread.sleep(2000);
		loginPage.submitLoginInfo(this.email, this.password);
		Thread.sleep(2000);
		driver.get(this.baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.addToFavorite();
		Assert.assertEquals(notificationPage.getMessageText(), "Product has been added to your favorites.");
		notificationPage.waitUntilMessageDissapears();		
	}
	
	
	
}

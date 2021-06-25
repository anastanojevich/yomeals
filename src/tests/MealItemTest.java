package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public void addMealToFavoriteTest() throws InterruptedException {
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
	
	@Test
	public void clearCartTest() throws InterruptedException, IOException {
		driver.get(this.baseURL + "meals");
		Thread.sleep(2000);
		Thread.sleep(2000);
		locationPage.setLocationName("City Center - Albany");
		
		File file = new File("data/data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Meals");
		for (int i = 1; i < 6; i++) {
			String firstColumn =	sheet.getRow(i).getCell(0).getStringCellValue();
			double secondColumn =	sheet.getRow(i).getCell(1).getNumericCellValue();
			System.out.println(firstColumn + "      \t\t\t" + secondColumn);
			
			driver.get(firstColumn);
			mealPage.addToCart(secondColumn);
			Thread.sleep(2000);
			softAssertion.assertEquals(notificationPage.getMessageText(), "Meal Added To Cart");
			notificationPage.waitUntilMessageDissapears();
			}
		cartPage.clearAll();
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "All meals removed from Cart successfully");
		notificationPage.waitUntilMessageDissapears();
	}
}

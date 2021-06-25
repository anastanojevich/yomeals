package tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	@Test
	public void editProfileTest() throws InterruptedException {
		driver.get(this.baseURL + "guest-user/login-form");
		locationPage.closePopup();
		Thread.sleep(2000);
		loginPage.submitLoginInfo(this.email, this.password);
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Login Successfull");
		notificationPage.waitUntilMessageDissapears();
		
		driver.get(this.baseURL + "member/profile");
		profilePage.profileUpdate("Jane", "Doe", "Cool Street 22", "222-333", "111", "United States", "Nevada", "Las Vegas");
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Setup Successful");
		notificationPage.waitUntilMessageDissapears();
		
		authPage.logoutForm();
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Logout Successfull!");
		notificationPage.waitUntilMessageDissapears();	
	}
	
	@Test
	public void changeProfileImageTest() throws InterruptedException, IOException {
		driver.get(this.baseURL + "guest-user/login-form");
		locationPage.closePopup();
		Thread.sleep(2000);
		loginPage.submitLoginInfo(this.email, this.password);
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Login Successfull");
		notificationPage.waitUntilMessageDissapears();
		
		driver.get(this.baseURL + "member/profile");
		String imgPath = new File("img/pexels-jeshootscom-167832.jpg").getCanonicalPath();
		profilePage.uploadImage(imgPath);
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Profile Image Uploaded Successfully");
		notificationPage.waitUntilMessageDissapears();
		
		profilePage.removeImage();
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Profile Image Deleted Successfully");
		notificationPage.waitUntilMessageDissapears();
		
		authPage.logoutForm();
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Logout Successfull!");
		notificationPage.waitUntilMessageDissapears();	
	}
	
	
	
	
}

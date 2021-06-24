package tests;

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
		Assert.assertEquals(notificationPage.getMessageText(), "Setup Successfull");
		notificationPage.waitUntilMessageDissapears();
		
		authPage.getLogout().click();
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Logout Successfull");
		notificationPage.waitUntilMessageDissapears();	
	}
	
}

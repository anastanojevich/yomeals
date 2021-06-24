package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	@Test
	public void editProfileTest() throws InterruptedException {
		driver.get(this.baseURL + "guest-user/login-form");
		locationPage.getLocationCloseBtn().click();
		loginPage.submitLoginInfo("customer@dummyid.com", "12345678a");
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Login Successfull");
		notificationPage.waitUntilMessageDissapears();
		
		driver.get(this.baseURL + "member/profile");
		profilePage.profileUpdate("Jane", "Doe", "Cool Street 22", "222-333", "111", "Wonderland", "Happiness", "Joy");
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Setup Successfull");
		notificationPage.waitUntilMessageDissapears();
		
		authPage.getLogout().click();
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Logout Successfull");
		notificationPage.waitUntilMessageDissapears();	
	}
	
}

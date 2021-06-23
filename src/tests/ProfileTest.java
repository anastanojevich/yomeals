package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	@Test
	public void editProfileTest() throws InterruptedException {
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		locationPage.getLocationCloseBtn().click();
		loginPage.submitLoginInfo("customer@dummyid.com", "12345678a");
		Thread.sleep(2000);
		Assert.assertEquals(notificationPage.getMessageText(), "Login Successfull");
		
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
	}
	
}

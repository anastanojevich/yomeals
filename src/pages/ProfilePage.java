package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{

	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}

	public WebElement getFirstName() {
		return driver.findElement(By.xpath("//input[@data-field-caption='First Name']"));
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.xpath("//input[@data-field-caption='Last Name']"));
	}
	
	public WebElement getAddress() {
		return driver.findElement(By.xpath("//input[@data-field-caption='Address']"));
	}
	
	public WebElement getPhoneNo() {
		return driver.findElement(By.xpath("//input[@data-field-caption='Phone']"));
	}
	
	public WebElement getZipCode() {
		return driver.findElement(By.xpath("//input[@data-field-caption='Zipcode']"));
	}
	
	public Select getCountry() {
		 Select country = new Select(driver.findElement(By.id("user_country_id")));
		return country;
	}
	
	public Select getState() {
		 Select state = new Select(driver.findElement(By.id("user_state_id")));
		return state;
	}
	
	public Select getCity() {
		 Select city = new Select(driver.findElement(By.id("user_city")));
		return city;
	}
	
	
}

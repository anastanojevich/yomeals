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
	
	public void uploadPhoto(String img) {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@type=\"file\"]")));
		driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys("C:\\Users\\Dell\\Desktop\\Anja\\ponic.png");
	}
	
	public void removePhoto() {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[class=\"avatar\"]/img")));
	}

	public void selectCountry(String countryText) {
		getCountry().selectByVisibleText(countryText);
	}
	
	public void selectState(String stateText) {
		getCountry().selectByVisibleText(stateText);
	}
	
	public void selectCity(String cityText) {
		getCountry().selectByVisibleText(cityText);
	}
	
	public void profileUpdate(String firstName, String lastName, String address, String phoneNo, 
			String zipCode, String country, String state, String city) {
		this.getFirstName().click();
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);

		this.getLastName().click();
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);

		this.getAddress().click();
		this.getAddress().clear();
		this.getAddress().sendKeys(address);

		this.getPhoneNo().click();
		this.getPhoneNo().clear();
		this.getPhoneNo().sendKeys(phoneNo);
		
		this.getZipCode().click();
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		
		this.selectCountry(country);
		this.selectState(state);
		this.selectCity(city);
	}
	
	
	
}
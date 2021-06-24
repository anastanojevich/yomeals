package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("//div[@class='row']//input[@type='submit']"));
	}
	
	
	public void uploadImage(String img) throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.className("avatar"));
		action.moveToElement(element).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Uplaod']"));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Uplaod']")));
		driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys(img);
	}
	
	public void removeImage() {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@title='Remove']")));
	}
	
	public void profileUpdate(String firstName, String lastName, String address, String phoneNo, 
			String zipCode, String country, String state, String city) throws InterruptedException {
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
		
		Thread.sleep(1000);
		this.getCountry().selectByVisibleText(country);
		Thread.sleep(1000);
		this.getState().selectByVisibleText(state);
		Thread.sleep(1000);
		this.getCity().selectByVisibleText(city);
		Thread.sleep(1000);

		js.executeScript("arguments[0].click()", this.getSaveBtn());
	}
	
	
	
}

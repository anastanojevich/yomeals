package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage{

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement locationHeader() {
		return driver.findElement(By.id("locality_keyword"));
	}
	
	public WebElement locationCloseBtn() {
		return driver.findElement(By.xpath("//div[@class='close-btn-white']"));
	}
	
	public WebElement keyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	
	public WebElement locationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}
	
	public WebElement locationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	
	public WebElement locationSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	
	public void clickLocationHeader() {
		this.locationHeader().click();
	}
	
	public void setLocationName(String locationName) {
		this.keyword().click();
		String location = this.locationItem(locationName).getAttribute(locationName);
		js.executeScript("arguments[0].value=arguments[1]", this.locationInput(), location);
		js.executeScript("arguments[0].click()", this.locationSubmit());		
	}
	
	public void closePopup() {
		this.locationCloseBtn().click();
	}
	
}

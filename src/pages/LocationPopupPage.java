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

	public WebElement getLocationHeader() {
		return driver.findElement(By.id("locality_keyword"));
	}
	
	public WebElement getLocationCloseBtn() {
		return driver.findElement(By.xpath("//div[@class='close-btn-white']"));
	}
	
	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}
	
	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	
	public WebElement getLocationSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	
	public void clickLocationHeader() {
		this.getLocationHeader().click();
	}
	
	public void setLocationName(String locationName) {
		this.getKeyword().click();
		String location = this.getLocationItem(locationName).getAttribute(locationName);
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), location);
		js.executeScript("arguments[0].click()", this.getLocationSubmit());		
	}
	
	public void closePopup() {
		this.getLocationCloseBtn().click();
	}
	
}

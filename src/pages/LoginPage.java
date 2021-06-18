package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getLoginForm() {
		return driver.findElement(By.xpath("//ul/li[@class='filled']"));
	}
	
	public WebElement getEmail() {
		return driver.findElement(By.xpath("//input[@data-field-caption='Email']"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.xpath("//input[@data-field-caption='Password']"));
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}
	
	public void submitLoginInfo(String email, String password) {
		this.getEmail().sendKeys(email);
		this.getPassword().sendKeys(password);
	}
}

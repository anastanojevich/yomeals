package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}

	public WebElement getAccountForm() {
		return driver.findElement(By.xpath("//div[@class=\"header-inner\"]/div/div[2]"));
	}
	
	public WebElement getLogout() {
		return driver.findElement(By.xpath("//div[@class='my-account-dropdown']/ul/li[2]"));
	}
	
	
}

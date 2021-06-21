package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationSystemPage extends BasicPage{

	public NotificationSystemPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')]"
										+ "[contains(@style,'display: block')]"));
	}
	
	public String getMessageText() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')]"
				+ "[contains(@style,'display: block')]")).getText();
	}
	
	
	
}

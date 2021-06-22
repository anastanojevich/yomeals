package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage{

	public CartSummaryPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}

	public WebElement getClearAllBtn() {
		return driver.findElement(By.xpath("//a[normalize-space()='Clear All']"));
	}
	
	public void clearAll() {
		this.getClearAllBtn().click();
	}
	
}

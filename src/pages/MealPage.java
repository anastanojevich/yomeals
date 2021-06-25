package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}

		public WebElement getQuantity() {
			return driver.findElement(By.xpath("//input[@type='number']"));
		}

		public WebElement getCart() {
			return driver.findElement(By.xpath("//a[normalize-space()='Add To Cart']"));
		}
		
		public WebElement getFavorite() {
			return driver.findElement(By.id("item_119"));
		}
	
		public void addToCart(double quantity) throws InterruptedException {
			js.executeScript("arguments[0].value=arguments[1]", this.getQuantity(), quantity);
			Thread.sleep(2000);
			this.getCart().click();
		}
		
		public void addToFavorite() {
			this.getFavorite().click();
		}
		
		
}

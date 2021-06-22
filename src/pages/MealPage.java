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

//	Meal Page:
//		get metode za sve potrebne elemente
//		metodu koja dodaje jelo u korpu - kao parametar se prosleđuje količina
//		metodu koja jelo dodaje u omiljena jela, klikom na dugme Favorite 

		public WebElement getQuantity() {
			return driver.findElement(By.xpath("//input[@name='product-qty']"));
		}

		public WebElement getCart() {
			return driver.findElement(By.xpath("//a[normalize-space()='Add To Cart']"));
		}
		
		public WebElement getFavorite() {
			return driver.findElement(By.className("favorite"));
		}
	
		public void addToCart(double quantity) {
			js.executeScript("arguments[0].value=agruments[1]", this.getQuantity(), quantity);
			this.getCart().click();
		}
		
		public void addToFavorite() {
			this.getFavorite().click();
		}
		
		
}

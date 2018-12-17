package practiceSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;






public class ScrollWebPage {
	ChromeDriver driver;
	List<WebElement> allLink;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/meghasharma/Downloads/chromedriver 3");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
	    System.out.println("welcome to amazon");
	}
	
	public void searchProduct(String product, String category) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);

		WebElement dropdownCat = driver.findElement(By.id("searchDropdownBox"));

		Select selCategory = new Select(dropdownCat);

		selCategory.selectByVisibleText(category);

		driver.findElement(By.xpath("//input[@value='Go']")).click();

		System.out.println(driver.findElement(By.id("s-result-count")).getText());
	}
	public String getNthProduct(int itemNumber) {

		String productIdLocator = String.format("result_%d", (itemNumber - 1));

		return driver.findElement(By.id(productIdLocator)).getText();
	}

	public void printAllProducts() {

		List<WebElement> allProducts = driver.findElements(By.xpath("//li[starts-with(@id,'result_')]"));

		for (WebElement product : allProducts) {
			System.out.println(product.getText());

			System.out.println("---------------------------------------------");
		}
	}
	
	public void printAllProductsViaMouseScrolldown() {
 		List<WebElement> allProducts = driver.findElements(By.xpath("//li[starts-with(@id,'result_')]"));
		Actions action = new Actions(driver);
 		for (WebElement product : allProducts) {
 			action.moveToElement(product).build().perform();
			System.out.println(product.getText());
 			System.out.println("---------------------------------------------");
		}
 		
	}
	public void printAllProductsViaJavaScript() {
 		List<WebElement> allProducts = driver.findElements(By.xpath("//li[starts-with(@id,'result_')]"));
 		int x, y;
		for (WebElement product : allProducts) {
 			x = product.getLocation().x;
			y = product.getLocation().y;
			
			scrollDown(x, y);
			
			System.out.println(product.getText());
 			System.out.println("---------------------------------------------");
		}
	}
 	private void scrollDown(int x, int y) {
		
		String jsCommand = String.format("window.scrollBy(%d,%d)", x, y);
 		driver.executeScript(jsCommand);
	}
}



package assignment7;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EdurekaAssignment7 {
	ChromeDriver driver;
	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/meghasharma/Downloads/chromedriver 3");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		}
	@Test(priority = 1)
	public void searchFlipkart() throws InterruptedException {
		System.out.println("Flipkart Launched");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		driver.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("Selenium Book");
		driver.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='_3liAhj _1R0K0g']//child::img[1]")).click();
		System.out.println("First Selenium Book Selected");
	}
	@Test(priority =2, dependsOnMethods="searchFlipkart")
	public void enterPincode() throws InterruptedException {
		System.out.println(driver.getCurrentUrl());
		//Assert.assertEquals(driver.getTitle(),"Selenium WebDriver 1st Edition");
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		          WebDriverWait wait = new WebDriverWait(driver, 30);
		  		
		  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pincodeInputId']")));
		  		
		  		WebElement element = driver.findElement(By.xpath("//input[@id='pincodeInputId']"));

		  	    Actions actions = new Actions(driver);

		  		  actions.moveToElement(element).click().perform();
		  		
		  		
		  		driver.findElement(By.xpath("//input[@id='pincodeInputId']")).sendKeys("121002");
		  		
		  		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='_2aK_gu']")).isEnabled());
		  		driver.findElement(By.xpath("//span[@class='_2aK_gu']")).click();
		  		String date = driver.findElement(By.xpath("//span[@class='_3nCwDW']")).getText();
		  		System.out.println("book will be deliverd by "+date);
		  		Thread.sleep(2000);
		  		driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
		  	//	System.out.println(driver.getTitle());
		  		}
		   
		        
		          }
		   
		       }
	@Test(priority=3, dependsOnMethods="enterPincode")
		public void placeOrder() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
		
		driver.navigate().refresh();
		
	    WebDriverWait wait = new WebDriverWait(driver, 50);
  		
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='_2zrpKA _14H79F']")));
  		
  		
  	   
  		
		element.sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1poQZq _7UHT_c']")).click();
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _14H79F']")).sendKeys("abc123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		String errorMessage = driver.findElement(By.xpath("//span[@class='ZAtlA-']")).getText();
		System.out.println(errorMessage);
		
		
	}
	@AfterClass
	public void closeBrowsers() {
		driver.quit();
	}
	
	}
	
	
	



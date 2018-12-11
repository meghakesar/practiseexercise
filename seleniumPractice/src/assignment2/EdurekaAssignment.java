package assignment2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EdurekaAssignment {
	ChromeDriver driver;
	public void invokeBrowser() {
	System.setProperty("webdriver.chrome.driver", "/Users/meghasharma/Downloads/chromedriver 3");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("https://www.edureka.co/");
	
	}
	public void inspectElement() {
		driver.findElement(By.xpath("//input[@id='homeSearchBar']")).sendKeys("Selenium");
		waitTillElementVisible(30,By.xpath("//input[@id='homeSearchBar']"));
		driver.findElement(By.xpath("//input[@id='homeSearchBar']")).sendKeys(Keys.RETURN);
	}
		
	private void waitTillElementVisible(int timeOutInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void clickCourse() {
		
		//driver.findElement(By.xpath("//h3[text( ) = 'Selenium Certification Training ']"));
		driver.findElement(By.xpath("//h3[text( ) = 'Selenium Certification Training ']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    String titlePage = driver.getTitle();
		System.out.println("Title of Page : "+titlePage);
	    if (titlePage.equals("Selenium Online Training & Certification Course- Edureka")) {
	    	System.out.println("Right Page : Test Pass");
	    	} else {
	    		System.out.println("Wrong Page : Test Failed");	
	    	}
	    driver.navigate().back();
	    System.out.println(driver.getTitle());
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.navigate().back();
	    System.out.println(driver.getTitle());
	    driver.navigate().back();
	    System.out.println(driver.getTitle());
	    driver.close();
    
	}
	}
	

package assignmentModule5;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class OpenEdureka {
	ChromeDriver driver; 
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/meghasharma/Downloads/chromedriver 3");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.edureka.co/");	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		}
	public void loginEdureka() {
		driver.findElement(By.xpath("//a[@class='signin top-signin trackButton']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='si_popup_email']"))); 
		driver.findElement(By.xpath("//input[@id='si_popup_email']")).click();
		driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys("megha.kesar@gmail.com");
		driver.findElement(By.xpath("//input[@id='si_popup_passwd']")).click();
		driver.findElement(By.xpath("//input[@id='si_popup_passwd']")).sendKeys("megha1983");
		driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block pagesense_en_track']")).click();
		System.out.println("Login Successful");
	//	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	public void myProfile() {
		driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).click();
		System.out.println("MyProfile Clicked");
         driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='My Profile']")).click();
		System.out.println("Entered in My Profile");
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='profile-edit-icon']")));
		driver.findElement(By.xpath("//a[@class='profile-edit-icon']")).click();
		
		System.out.println("Entered in My Personal Details");
		
	}
	public void myPersonalDetails() throws InterruptedException {
		System.out.println("Welcome My Personal Details");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='currentrole']")));
		WebElement element = driver.findElement(By.xpath("//input[@name='currentrole']"));

	    Actions actions = new Actions(driver);

		  actions.moveToElement(element).click().perform();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@name='currentrole']")).clear();

		driver.findElement(By.xpath("//input[@name='currentrole']")).sendKeys("Automated Tester");
	
		System.out.println("Typed Automated Tester");
		driver.findElement(By.xpath("//a[text()='Automated Tester']")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 50);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default pull-right verify-continue-btn']")));
	   driver.findElement(By.xpath("//button[@class='btn btn-default pull-right verify-continue-btn']")).click();
		
		
	}

	
}

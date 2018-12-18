package assignment4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EdurekaTestNg {
ChromeDriver driver;
@BeforeClass
public void invokeBrowser() {
	System.setProperty("webdriver.chrome.driver", "/Users/meghasharma/Downloads/chromedriver 3");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	driver.get("https://www.edureka.co/");
		}
@Test(priority=1)
public void loginEdureka() throws InterruptedException {
	driver.findElement(By.xpath("//a[@class='signin top-signin trackButton']")).click();
	WebDriverWait wait = new WebDriverWait(driver, 40);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='si_popup_email']"))); 
	driver.findElement(By.xpath("//input[@id='si_popup_email']")).click();
	driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys("megha.kesar@gmail.com");
	driver.findElement(By.xpath("//input[@id='si_popup_passwd']")).click();
	driver.findElement(By.xpath("//input[@id='si_popup_passwd']")).sendKeys("megha1983");
	driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block pagesense_en_track']")).click();
	System.out.println("Login Successful");
	Thread.sleep(2000);
	Assert.assertTrue(driver.findElement(By.xpath("//ul/li/a/span[@class='webinar-profile-name']")).isDisplayed());
//	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
}
@Test(priority=2, dependsOnMethods="loginEdureka")
public void searchCourse() {
	driver.findElement(By.xpath("//a[@id='dLabel']")).click();
	Assert.assertEquals(driver.getTitle(), "List Of Courses Available - Edureka");
	System.out.println("All courses page opened");
	
}
@Test(priority=3, dependsOnMethods="searchCourse")
public void logoutCourse() throws InterruptedException {
	driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log In']")).isDisplayed());
	System.out.println("Successfully Logged Out");
	
}
@AfterClass
public void closeBrowser() {
	driver.close();
}








}

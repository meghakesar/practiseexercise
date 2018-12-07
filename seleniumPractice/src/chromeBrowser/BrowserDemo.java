package chromeBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDemo {
	ChromeDriver driver; 
public void invokeBrowser() {
	System.setProperty("webdriver.chrome.driver", "/Users/meghasharma/Downloads/chromedriver 3");
	driver = new ChromeDriver();
	driver.get("http:/demo.guru99.com/v4/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	String browserTitle = driver.getTitle();
	if (browserTitle.equals ("Guru99 Bank Home Page")) {
		System.out.println("Testcase PASS");
	}
	else {
	System.out.println("Testcase Fail");
	}
}
 
public void login(String userId, String password) {
	driver.findElement(By.name("uid")).sendKeys(userId);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("btnLogin")).click();
	
}
public void newCustomer() {
	driver.findElement(By.linkText("New Customer")).click();
	driver.findElement(By.name("name")).sendKeys("abc");
	driver.findElement(By.xpath("//input[@value='f']")).click();
	driver.findElement(By.id("dob")).sendKeys("15/12/1983");
	driver.findElement(By.name("addr")).sendKeys("NIT 1");
	driver.findElement(By.name("city")).sendKeys("Faridabad");
	driver.findElement(By.name("state")).sendKeys("Haryana");
	driver.findElement(By.name("pinno")).sendKeys("121001");
	driver.findElement(By.name("telephoneno")).sendKeys("1234567890");
	String emailId = "aa" + System.currentTimeMillis() + "@gmail.com";
	System.out.println("email id is  " +emailId);
	driver.findElement(By.name("emailid")).sendKeys(emailId);
	driver.findElement(By.name("password")).sendKeys("12345");
	driver.findElement(By.name("sub")).click();
	
}

//public void closeBrowser() {
	//driver.close();
//}
	
}



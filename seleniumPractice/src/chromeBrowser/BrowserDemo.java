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

public void closeBrowser() {
	driver.close();
}
	
}



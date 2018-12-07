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
	System.out.println("title of the browser is:" +browserTitle);
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



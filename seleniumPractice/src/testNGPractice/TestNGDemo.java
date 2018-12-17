package testNGPractice;

import org.testng.annotations.Test;

public class TestNGDemo {
	
	@Test(priority=1,description="Launching TestNg")
	public void loginApplication() {
		System.out.println("This is first testNg test");
		
	}
	
	@Test(priority=2,description="checking TestNg")
	public void checkApplication() {
		System.out.println("This is checking testNg test");
		
	}
}

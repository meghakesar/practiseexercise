package assignmentModule5;

public class EdurekaLogin  {

	public static void main(String[] args) throws InterruptedException {
		OpenEdureka oe = new OpenEdureka();
		oe.invokeBrowser();
		oe.loginEdureka();
		oe.myProfile();
		oe.myPersonalDetails();
	}

}

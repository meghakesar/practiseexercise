package practiceSelenium;

public class ScrollMain {

	public static void main(String[] args) {
		ScrollWebPage wp = new ScrollWebPage();

		
		wp.invokeBrowser();
		wp.searchProduct("Apple Watch", "Watches");

		String nthProduct = wp.getNthProduct(7);
		
		System.out.println(nthProduct);
		
		wp.printAllProductsViaJavaScript(); 
	}

}


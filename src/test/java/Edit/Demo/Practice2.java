package Edit.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\Demo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	public void OpenPage() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
}

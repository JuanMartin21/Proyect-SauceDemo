package Edit.Demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SauceDemo {
	String url = "https://www.saucedemo.com/";
	String driverPath = "..\\Demo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	String DirEvidencias = "..\\Demo\\evidencias\\";
	File screen; 
	
	
	@BeforeSuite
	public void OPenPage(){
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	@Test(description="CP34 ingreso de Usuario", priority = 1)
	public void login() throws IOException {
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(DirEvidencias + "01_pantalla_inicial.jpg"));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

}
}
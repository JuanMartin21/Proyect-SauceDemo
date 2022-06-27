package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Practice5 {
	String url="http://automationpractice.com";
	String driverPath ="..\\Demo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test
	public void Ingreso() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.HacerClickSingIn();
		PaginaLogin login = new PaginaLogin(driver);
		login.ingresoEmail("martin3456@gmail");
		login.ingresoPassword("yjdl547");
		login.clickBotonIn();
	}

}

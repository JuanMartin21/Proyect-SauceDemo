package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Practice5 {
	String url="http://automationpractice.com";
	WebDriver driver;
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();
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
	@Test
	public void BuscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.buscar("Blouse");
		inicio.clicBotonBuscar();
		
	}
}

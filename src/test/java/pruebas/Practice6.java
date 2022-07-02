package pruebas;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Practice6 {
	String url="http://automationpractice.com";
	WebDriver driver;
	
	@BeforeSuite
	public void OpenPage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@Test(dataProvider="Datos Ingreso")
	public void Ingreso(String email, String Password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.HacerClickSingIn();
		PaginaLogin login = new PaginaLogin(driver);
		login.ingresoEmail(email);
		login.ingresoPassword(Password);
		login.clickBotonIn();
		
		Assert.assertEquals(driver.getTitle(),"My account - My Store");
		login.HacerClickenSingOut();
		
		
	}	
		
	@DataProvider(name="Datos Ingreso")
	public Object [][] obtenerDatosIngreso() throws Exception{
		return DatosExcel.leerExcel("..\\Demo\\DatosDePrueba\\DatosTC.xlsx", "Hoja1");
		
	}
	
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
	

}

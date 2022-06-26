package Edit.Demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Practice {
	String url = "http://automationpractice.com";
	String driverPath = "..\\Demo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	String evidenciasDir = "..\\Demo\\Evidencias\\";
	File Pantalla;
	String nomDocumento = "Evidencias - AutomationPractice.dock";
	
	@BeforeSuite
	public void OpenPage() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

	}
	@Test(description = "CP01 - Verificar la sección contactanos", priority = 200)	
	public void contactanos() throws Exception, IOException, InterruptedException{
		CapturaEvidencia.escribirTituloEnDocumento(evidenciasDir + nomDocumento, "Documento de Evidencias de Prueba", 20);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "imagen.jpg", evidenciasDir + nomDocumento, "paso 1 Pantalla principal ");
	
		driver.findElement(By.linkText("Contact us")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "imagen.jpg", evidenciasDir + nomDocumento, "paso 2 luego de hacer click en pantalla ");
		
		Select list = new Select(driver.findElement(By.id("id_contact")));
		list.selectByVisibleText("Webmaster");
		driver.findElement(By.id("email")).sendKeys("mario123@gmail.com");
		driver.findElement(By.id("message")).sendKeys("Comentario del contacto");
		
		// Subir una archivo - escribir en el campo desabilitado donde va el nombre del archivo
		//driver.findElement(By.id("fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "imagen.jpg", evidenciasDir + nomDocumento, "paso 3 Ver el formulario completo ");
		
		driver.findElement(By.cssSelector("#submitMessage")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "imagen.jpg", evidenciasDir + nomDocumento, "paso 4 envio del formulario");
			
		}
	@Test(description = "CP02 - Verificar la búsqueda de productos", priority = 100)
	public void BuscarPalabras() throws IOException {
		
		// captura de pantalla (Formato imagen)
		Pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Pantalla, new File(evidenciasDir + "01_pantalla_inicial.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.name("search_query"));
		txtBuscador.sendKeys("dress");
		// captura de pantalla (Formato imagen)
		Pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Pantalla, new File(evidenciasDir + "02_pantalla a buscar.jpg"));
		txtBuscador.sendKeys(Keys.ENTER);
		// captura de pantalla (Formato imagen)
		Pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Pantalla, new File(evidenciasDir + "03_Resultado_de_la_busqueda.jpg"));
		
		
		// comprobar que la busqueda se realizo
		
		String urlEsperado ="http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String urlActual = driver.getCurrentUrl();
		
		String tituloEsperado = "Search - My Store";
		String tituloActual = driver.getTitle();
		
		Assert.assertEquals(urlActual, urlEsperado);
		Assert.assertEquals(tituloActual, tituloEsperado);
		
		// assert.assertEquals(numeroRegistrosBD, 1);   
		
		/*
		 * assertEquals
		 * assertNotEquals
		 * assertFalse
		 * assertNull
		 * assertNotNull
		 *  */
		
	}
	
	@AfterSuite
	public void cerrarPagina() {
	//	driver.close();
	}
	

}
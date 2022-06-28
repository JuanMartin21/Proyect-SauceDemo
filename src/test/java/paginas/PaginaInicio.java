package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement InkSingIn;
	@FindBy(css="#search_query_top")
	WebElement txtBuscador;
	@FindBy(name="submit_search")
	WebElement btnBuscar;
	
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void HacerClickSingIn() {
		InkSingIn.click();
		
	}
	public void buscar(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	public void clicBotonBuscar() {
		btnBuscar.click();
	}
	
}

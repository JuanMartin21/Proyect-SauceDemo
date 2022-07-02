package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	
	@FindBy(css="#email")
	WebElement txtEmail;
	@FindBy(id="passwd")
	WebElement txtPassword;
	@FindBy(id="SubmitLogin")
	WebElement txtboton;
	@FindBy(linkText="Sign out")
	WebElement InkSingOut;

	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	public void ingresoEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void ingresoPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickBotonIn() {
		txtboton.click();
	}
	public void HacerClickenSingOut() {
		InkSingOut.click();
	}

}

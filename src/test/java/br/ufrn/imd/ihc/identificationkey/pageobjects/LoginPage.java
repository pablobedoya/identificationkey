package br.ufrn.imd.ihc.identificationkey.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.ufrn.imd.ihc.identificationkey.utils.TestProperty;

public class LoginPage extends BasePage {

	public static final String URL = TestProperty.getBaseUrl();

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage open() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.navigateTo(URL);
		return loginPage;
	}
	
	public void close() {
		closeBrowser();
	}

	public void login(String user, String pass) {
		getDriver().findElement(By.name("login")).clear();
		getDriver().findElement(By.name("login")).sendKeys(user);
		getDriver().findElement(By.name("senha")).clear();
		getDriver().findElement(By.name("senha")).sendKeys(pass);
		getDriver().findElement(By.name("action")).click();
	}

}

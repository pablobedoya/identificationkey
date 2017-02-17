package br.ufrn.imd.ihc.identificationkey.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.ufrn.imd.ihc.identificationkey.utils.TestProperty;

public class LoginPage {

	public static final String URL = TestProperty.getBaseUrl();

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage open() {
		LoginPage loginPage = new LoginPage(driver);
		driver.get(URL);
		return loginPage;
	}

	public void login(String user, String pass) {
		driver.findElement(By.name("login")).clear();
		driver.findElement(By.name("login")).sendKeys(user);
		driver.findElement(By.name("senha")).clear();
		driver.findElement(By.name("senha")).sendKeys(pass);
		driver.findElement(By.name("action")).click();
	}

}

package br.ufrn.imd.ihc.identificationkey.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.ufrn.imd.ihc.identificationkey.utils.URLUtils;

public class LoginPage {

	public static final String URL = URLUtils.getContextPath();

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage open() {
		LoginPage loginPage = new LoginPage(driver);
		driver.get(LoginPage.URL);
		return loginPage;
	}

	public void login() {
		this.login("pablo.bedoya", "pablo.bedoya");
	}

	public void login(String user, String pass) {
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("btnSubmit")).submit();
	}

}

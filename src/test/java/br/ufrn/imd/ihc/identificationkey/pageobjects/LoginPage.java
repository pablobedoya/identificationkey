package br.ufrn.imd.ihc.identificationkey.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufrn.imd.ihc.identificationkey.properties.IdentificationKeyProperties;

public class LoginPage extends BasePage {
	public static final String URL = IdentificationKeyProperties.getUrl();

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage open() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.navigateTo(URL);
		return loginPage;
	}
	
	public void login() {
		login("bio", "bio");
	}

	public void login(String user, String pass) {
		getDriver().findElement(By.name("login")).clear();
		getDriver().findElement(By.name("login")).sendKeys(user);
		getDriver().findElement(By.name("senha")).clear();
		getDriver().findElement(By.name("senha")).sendKeys(pass);
		getDriver().findElement(By.name("action")).click();
	}
	
	public boolean success() {
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Projetos")));
		List<WebElement> list = getDriver().findElements(By.linkText("Projetos"));
		return list.size() > 0;
	}
}

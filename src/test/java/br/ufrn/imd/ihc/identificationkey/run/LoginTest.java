package br.ufrn.imd.ihc.identificationkey.run;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.LoginPage;

public class LoginTest {
	
	private BasePage basePage;
	private LoginPage loginPage;

	@BeforeClass
	public void setUp() {
		basePage = new BasePage();
		loginPage = new LoginPage(basePage.getDriver());
	}

	@AfterClass
	public void tearDown() {
		basePage.closeBrowser();
	}

	@Test
	public void testLoginOk() {
		loginPage.open();
		loginPage.login("bio", "bio");

		(new WebDriverWait(basePage.getDriver(), 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Projetos")));
	}

	@Test
	public void testLoginInvalid() {
		loginPage.open();
		loginPage.login("pablobedoya", "123");

		(new WebDriverWait(basePage.getDriver(), 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'login e senha incorretos')]")));
	}

}

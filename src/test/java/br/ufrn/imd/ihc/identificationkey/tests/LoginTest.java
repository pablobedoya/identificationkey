package br.ufrn.imd.ihc.identificationkey.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.LoginPage;

public class LoginTest extends BaseTest {
	
	private BasePage basePage;
	private LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		loginPage = new LoginPage(basePage.getDriver());
	}

	@AfterMethod
	public void tearDown() {
		basePage.closeBrowser();
	}

	@Test
	public void testLogin() {
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

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
	
	private static BasePage basePage;
	private static LoginPage loginPage;

	@BeforeClass
	public static void setUp() {
		basePage = new BasePage();
		loginPage = new LoginPage(basePage.getDriver());
	}

	@AfterClass
	public static void tearDown() {
		loginPage.close();
	}

	@Test
	public void testLoginSuccess() {
		loginPage.open();
		loginPage.login("bio", "bio");

		(new WebDriverWait(basePage.getDriver(), 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Projetos")));
	}

	@Test
	public void testLoginFail() {
		loginPage.open();
		loginPage.login("pablo.bedoya", "123");

		(new WebDriverWait(basePage.getDriver(), 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'login e senha incorretos')]")));
	}

}

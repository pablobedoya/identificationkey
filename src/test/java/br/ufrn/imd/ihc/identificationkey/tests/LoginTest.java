package br.ufrn.imd.ihc.identificationkey.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.LoginPage;

public class LoginTest extends BaseTest {
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

	@Test // TC01 Efetuar login com sucesso
	public void testLogin() {
		loginPage.open();
		loginPage.login("bio", "bio");
		Assert.assertTrue(loginPage.success());
	}
}

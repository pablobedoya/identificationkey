package br.ufrn.imd.ihc.identificationkey.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.form.UserForm;
import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.UserPage;

public class UserTest extends BaseTest {
	private BasePage basePage;
	private UserPage userPage;
	private UserForm form;

	@BeforeClass
	public void setUp() {
		basePage = new BasePage();
		userPage = new UserPage(basePage.getDriver());
		userPage.openBrowser();
		userPage.open();
	}

	@AfterClass
	public void tearDown() {
		userPage.closeBrowser();
	}

	@Test
	public void testCreateUser() {
		form = UserForm.getDefaultForm();
		userPage.create(form);
		List<WebElement> list = userPage.findUser(form.getName());
		Assert.assertTrue(list.size() == 1);
	}

	@Test
	public void testDeleteUser() {
		form = UserForm.getDefaultForm();
		userPage.create(form);
		userPage.delete(form.getName());
		List<WebElement> list = userPage.findUser(form.getName());
		Assert.assertTrue(list.size() == 0);
	}
}

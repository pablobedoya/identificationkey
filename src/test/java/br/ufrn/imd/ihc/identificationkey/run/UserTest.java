package br.ufrn.imd.ihc.identificationkey.run;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.form.UserForm;
import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.UserPage;

public class UserTest {
	
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
		form.setName("test_create_user_name");
		userPage.create(form);
		// Ao invés de usar a lista para a verificar se o teste passou, tentar fazer login
		// com o usuário criado e validar caso o usuário entre no sistema com sucesso
		List<WebElement> list = userPage.getDriver().findElements(By.xpath("//*[contains(text(),'" + form.getName() + "')]"));
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void testDeleteUser() {
		form = UserForm.getDefaultForm();
		form.setName("test_delete_user_name");
		userPage.create(form);
		userPage.delete(form.getName());
		List<WebElement> list = userPage.getDriver().findElements(By.xpath("//*[contains(text(),'" + form.getName() + "')]"));
		Assert.assertTrue(list.size() == 0);
	}

}

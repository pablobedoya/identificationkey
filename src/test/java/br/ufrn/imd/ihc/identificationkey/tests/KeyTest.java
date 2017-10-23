package br.ufrn.imd.ihc.identificationkey.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.form.KeyForm;
import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.KeyPage;

public class KeyTest extends BaseTest {
	private BasePage basePage;
	private KeyPage keyPage;
	private KeyForm form;
	
	@BeforeClass
	public void setUp() {
		basePage = new BasePage();
		keyPage = new KeyPage(basePage.getDriver());
		keyPage.openBrowser();
		keyPage.open();
	}
	
	@AfterClass
	public void tearDown() {
		keyPage.closeBrowser();
	}
	
	@Test // TC17 Criar chave de identificação com sucesso
	public void testCreateKey() {
		form = KeyForm.getDefaultForm();
		keyPage.create(form);
		List<WebElement> list = keyPage.findKey(form.getName());
		Assert.assertTrue(list.size() == 1);
	}
	
	@Test // TC27 Remover chave de identificação
	public void testDeleteKey() {
		form = KeyForm.getDefaultForm();
		keyPage.create(form);
		keyPage.delete(form.getName());
		List<WebElement> list = keyPage.findKey(form.getName());
		Assert.assertTrue(list.size() == 0);
	}
}

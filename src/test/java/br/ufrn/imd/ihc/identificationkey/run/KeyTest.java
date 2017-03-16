package br.ufrn.imd.ihc.identificationkey.run;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.form.KeyForm;
import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.KeyPage;

public class KeyTest {

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
	
	@Test
	public void testCreateKey() {
		form = KeyForm.getDefaultForm(); // Criar um método em KeyForm para adicionar uma chave com os parâmetros passados
		form.setName("test_create_key_name"); // Remover quando substituir o getDefaultForm pelo novo método
		keyPage.create(form);
		List<WebElement> list = keyPage.getDriver().findElements(By.xpath("//*[contains(text(),'" + form.getName() + "')]"));
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void testDeleteKey() {
		form = KeyForm.getDefaultForm(); // Criar um método em KeyForm para adicionar uma chave com os parâmetros passados
		form.setName("test_delete_key_name"); // Remover quando substituir o getDefaultForm pelo novo método
		keyPage.create(form);
		keyPage.delete(form.getName());
		List<WebElement> list = keyPage.getDriver().findElements(By.xpath("//*[contains(text(),'" + form.getName() + "')]"));
		Assert.assertTrue(list.size() == 0);
	}
	
}

package br.ufrn.imd.ihc.identificationkey.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.forms.KeyForm;
import br.ufrn.imd.ihc.identificationkey.forms.SpecimenForm;
import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.IdentificationPage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.KeyPage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.SpecimenPage;

public class IdentificationTest extends BaseTest {
	private BasePage basePage;
	private KeyPage keyPage;
	private SpecimenPage specimenPage;
	private IdentificationPage identificationPage;
	private KeyForm keyForm;
	private SpecimenForm specimenForm;
	
	@BeforeClass
	public void setUp() {
		basePage = new BasePage();
		keyPage = new KeyPage(basePage.getDriver());
		specimenPage = new SpecimenPage(basePage.getDriver());
		identificationPage = new IdentificationPage(basePage.getDriver());
		identificationPage.openBrowser();
		identificationPage.open();
		
		keyForm = KeyForm.getDefaultForm();
		keyPage.navigateTo(KeyPage.URL);
		keyPage.create(keyForm);
	}
	
	@AfterClass
	public void tearDown() {
		identificationPage.closeBrowser();
	}
	
	@Test // TC06 Identificar exemplar com sucesso
	public void testCreateIdentification() {
		specimenForm = SpecimenForm.getDefaultForm();
		specimenPage.navigateTo(SpecimenPage.URL);
		specimenPage.create(specimenForm);
		
		identificationPage.createIdentification(keyForm, specimenForm);
		List<WebElement> list = identificationPage.findKey(keyForm.getName());
		Assert.assertTrue(list.size() == 1);
	}
	
	@Test // TC08 Remover identificação de exemplar
	public void testDeleteIdentification() {
		specimenForm = SpecimenForm.getDefaultForm();
		specimenPage.navigateTo(SpecimenPage.URL);
		specimenPage.create(specimenForm);
		
		identificationPage.createIdentification(keyForm, specimenForm);
		identificationPage.deleteIdentification(keyForm);
		List<WebElement> list = identificationPage.findKey(keyForm.getName());
		Assert.assertTrue(list.size() == 0);
	}
}

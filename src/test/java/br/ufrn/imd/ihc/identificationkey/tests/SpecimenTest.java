package br.ufrn.imd.ihc.identificationkey.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.forms.SpecimenForm;
import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.SpecimenPage;

public class SpecimenTest extends BaseTest {
	private BasePage basePage;
	private SpecimenPage specimenPage;
	private SpecimenForm form;
	
	@BeforeClass
	public void setUp() {
		basePage = new BasePage();
		specimenPage = new SpecimenPage(basePage.getDriver());
		specimenPage.openBrowser();
		specimenPage.open();
	}
	
	@AfterClass
	public void tearDown() {
		specimenPage.closeBrowser();
	}
	
	@AfterMethod
	public void afterTest() {
		specimenPage.closeProject();
	}
	
	@Test // TC09 Criar exemplar com sucesso
	public void testCreateSpecimen() {
		form = SpecimenForm.getDefaultForm();
		specimenPage.create(form);
		List<WebElement> list = specimenPage.findSpecimen(form.getName());
		Assert.assertTrue(list.size() == 1);
	}
	
	@Test // TC16 Remover exemplar
	public void testDeleteSpecimen() {
		form = SpecimenForm.getDefaultForm();
		specimenPage.create(form);
		specimenPage.delete(form);
		List<WebElement> list = specimenPage.findSpecimen(form.getName());
		Assert.assertTrue(list.size() == 0);
	}
}

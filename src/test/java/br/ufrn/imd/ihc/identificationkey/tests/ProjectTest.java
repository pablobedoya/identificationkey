package br.ufrn.imd.ihc.identificationkey.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.ProjectPage;

public class ProjectTest extends BaseTest {
	private BasePage basePage;
	private ProjectPage projectPage;
	private String name;
	
	@BeforeClass
	public void setUp() {
		basePage = new BasePage();
		projectPage = new ProjectPage(basePage.getDriver());
		projectPage.openBrowser();
		projectPage.open();
	}
	
	@AfterClass
	public void tearDown() {
		projectPage.closeBrowser();
	}

	@Test // TC28 Criar projeto com sucesso
	public void testCreateProject() {
		name = Long.toHexString(new Random().nextLong()); // Nome aleatório
		projectPage.create(name);
		List<WebElement> list = projectPage.findProject(name);
		Assert.assertTrue(list.size() == 1);
	}
	
	@Test // TC31 Remover projeto
	public void testDeleteProject() {
		name = Long.toHexString(new Random().nextLong()); // Nome aleatório
		projectPage.create(name);
		projectPage.delete(name);
		List<WebElement> list = projectPage.findProject(name);
		Assert.assertTrue(list.size() == 0);
	}
}

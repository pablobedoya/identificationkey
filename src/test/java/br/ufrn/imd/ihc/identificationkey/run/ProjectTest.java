package br.ufrn.imd.ihc.identificationkey.run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import br.ufrn.imd.ihc.identificationkey.pageobjects.BasePage;
import br.ufrn.imd.ihc.identificationkey.pageobjects.ProjectPage;

public class ProjectTest {
	
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

	@Test
	public void testCreateProject() {
		name = "test_create_project";
		projectPage.create(name);
		List<WebElement> list = projectPage.getDriver().findElements(By.xpath("//*[contains(text(),'" + name + "')]"));
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void testDeleteProject() {
		name = "test_delete_project";
		projectPage.create(name);
		projectPage.delete(name);
		List<WebElement> list = projectPage.getDriver().findElements(By.xpath("//*[contains(text(),'" + name + "')]"));
		Assert.assertTrue(list.size() == 0);
	}
	
}

package br.ufrn.imd.ihc.identificationkey.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufrn.imd.ihc.identificationkey.form.SpecimenForm;
import br.ufrn.imd.ihc.identificationkey.properties.IdentificationKeyProperties;

public class SpecimenPage extends BasePage {
	public static final String URL = IdentificationKeyProperties.getUrl() + "/chave/projetos.php";
	
	public SpecimenPage(WebDriver driver) {
		super(driver);
	}
	
	public SpecimenPage open() {
		SpecimenPage specimenPage = new SpecimenPage(getDriver());
		specimenPage.navigateTo(URL);
		return specimenPage;
	}
	
	public void closeProject() {
		getDriver().findElement(By.linkText("Fechar")).click();
	}
	
	public void create(SpecimenForm form) {
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("modalInserir")));
		getDriver().findElement(By.id("nome")).clear();
		getDriver().findElement(By.id("nome")).sendKeys(form.getProjectName());
		getDriver().findElement(By.id("salvar")).click();
		
		getDriver().findElement(By.id("botaoIncluir")).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("modalTitulo")));
		getDriver().findElement(By.id("nome")).clear();
		getDriver().findElement(By.id("nome")).sendKeys(form.getName());
		getDriver().findElement(By.id("descricao")).clear();
		getDriver().findElement(By.id("descricao")).sendKeys(form.getDescription());
		getDriver().findElement(By.id("dataColeta")).sendKeys(form.getCollectionDate());
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoTaxon")));
	    new Select(getDriver().findElement(By.id("tipoTaxon"))).selectByVisibleText(form.getTaxonType());
	    new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("taxonExemplares")));
	    new Select(getDriver().findElement(By.id("taxonExemplares"))).selectByVisibleText(form.getTaxon());
		getDriver().findElement(By.id("salvar")).click();
	}
	
	public void delete(SpecimenForm form) {
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'])[2]")));
		getDriver().findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("removerExemplar")));
	    getDriver().findElement(By.id("removerExemplar")).click();
	}
	
	public List<WebElement> findSpecimen(String name) {
		List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(),'" + name + "')]"));
		return list;
	}
}

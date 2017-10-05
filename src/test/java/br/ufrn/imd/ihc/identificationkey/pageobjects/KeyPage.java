package br.ufrn.imd.ihc.identificationkey.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufrn.imd.ihc.identificationkey.form.KeyForm;
import br.ufrn.imd.ihc.identificationkey.form.StepForm;
import br.ufrn.imd.ihc.identificationkey.properties.IdentificationKeyProperties;

public class KeyPage extends BasePage {
	
	public static final String URL = IdentificationKeyProperties.getUrl() + "/chave/chaves.php";

	public KeyPage(WebDriver driver) {
		super(driver);
	}

	public KeyPage open() {
		KeyPage keyPage = new KeyPage(getDriver());
		keyPage.navigateTo(URL);
		return keyPage;
	}
	
	public void create(KeyForm form) {
		getDriver().findElement(By.linkText("adicionar")).click();		
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoTaxonInicial")));
	    new Select(getDriver().findElement(By.id("tipoTaxonInicial"))).selectByVisibleText(form.getInitialTaxonType());
	    new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("taxon")));
	    new Select(getDriver().findElement(By.id("taxon"))).selectByVisibleText(form.getInitialTaxon());
	    getDriver().findElement(By.id("nome")).clear();
	    getDriver().findElement(By.id("nome")).sendKeys(form.getName());
	    getDriver().findElement(By.id("descricao")).clear();
	    getDriver().findElement(By.id("descricao")).sendKeys(form.getDescription());
	    getDriver().findElement(By.id("autor")).clear();
	    getDriver().findElement(By.id("autor")).sendKeys(form.getAuthor());
	    getDriver().findElement(By.id("bibliografia")).clear();
	    getDriver().findElement(By.id("bibliografia")).sendKeys(form.getBiography());
	    
	    for (StepForm step : form.getSteps()) {
	    	getDriver().findElement(By.xpath("(//button[@value='formInserirPasso'])")).click();
	    	getDriver().findElement(By.name("caracteristicaA")).clear();
	    	getDriver().findElement(By.name("caracteristicaA")).sendKeys(step.getCharacteristicA());
	    	new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoTaxonA")));
	    	new Select(getDriver().findElement(By.id("tipoTaxonA"))).selectByVisibleText(step.getInitialTaxonTypeA());
	    	new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("taxonA")));
	    	new Select(getDriver().findElement(By.id("taxonA"))).selectByVisibleText(step.getInitialTaxonA());
	    	getDriver().findElement(By.name("caracteristicaB")).clear();
	    	getDriver().findElement(By.name("caracteristicaB")).sendKeys(step.getCharacteristicB());
	    	new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoTaxonB")));
	    	new Select(getDriver().findElement(By.id("tipoTaxonB"))).selectByVisibleText(step.getInitialTaxonTypeB());
	    	new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("taxonB")));
	    	new Select(getDriver().findElement(By.id("taxonB"))).selectByVisibleText(step.getInitialTaxonB());
	    	getDriver().findElement(By.xpath("(//button[@value='salvarPasso'])")).click();
	    }
	    
	    getDriver().findElement(By.xpath("(//button[@value='salvarChave'])")).click();
	}
	
	public void delete(String name) {
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@title,'" + name + "')]")));
		getDriver().findElement(By.xpath("//button[contains(@title,'" + name + "')]")).click();
		
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("removerChave")));
		getDriver().findElement(By.id("removerChave")).click();
	}

}

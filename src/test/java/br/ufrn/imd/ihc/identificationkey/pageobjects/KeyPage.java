package br.ufrn.imd.ihc.identificationkey.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufrn.imd.ihc.identificationkey.form.KeyForm;
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
	    getDriver().findElement(By.xpath("(//button[@name='action'])[3]")).click();
	}
	
	public void delete(String name) {
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@title,'" + name + "')]")));
		getDriver().findElement(By.xpath("//button[contains(@title,'" + name + "')]")).click();
		
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("removerChave")));
		getDriver().findElement(By.id("removerChave")).click();
	}

}

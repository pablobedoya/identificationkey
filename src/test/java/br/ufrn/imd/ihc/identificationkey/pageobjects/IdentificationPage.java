package br.ufrn.imd.ihc.identificationkey.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufrn.imd.ihc.identificationkey.forms.KeyForm;
import br.ufrn.imd.ihc.identificationkey.forms.SpecimenForm;
import br.ufrn.imd.ihc.identificationkey.properties.IdentificationKeyProperties;

public class IdentificationPage extends BasePage {
	public static final String URL = IdentificationKeyProperties.getUrl() + "/chave/projetos.php";
	
	public IdentificationPage(WebDriver driver) {
		super(driver);
	}
	
	public IdentificationPage open() {
		IdentificationPage identificationPage = new IdentificationPage(getDriver());
		identificationPage.navigateTo(URL);
		return identificationPage;
	}
	
	public void createIdentification(KeyForm keyForm, SpecimenForm specimenForm) {
		String url = getDriver().findElement(By.xpath("//td[contains(text(),'" + specimenForm.getName() + "')]/following-sibling::td[4]//a[contains(@href, 'controle.php?action=consultarIdentificacoes')]")).getAttribute("href");
		IdentificationPage identificationPage = new IdentificationPage(getDriver());
		identificationPage.navigateTo(url);
		
		getDriver().findElement(By.linkText("Adicionar identificação")).click();
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("chave")));
	    new Select(getDriver().findElement(By.id("chave"))).selectByVisibleText(keyForm.getName());
	    getDriver().findElement(By.id("prosseguir")).click();
	    getDriver().findElement(By.name("action")).click();
	    
	    identificationPage.navigateTo(url);
	}
	
	public void deleteIdentification(KeyForm keyForm) {
		getDriver().findElement(By.xpath("//td[contains(text(),'" + keyForm.getName() + "')]/following-sibling::td//button[@type='submit']")).click();
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("action")));
		getDriver().findElement(By.name("action")).click();		
	}
	
	public List<WebElement> findKey(String name) {
		List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(),'" + name + "')]"));
		return list;
	}
}

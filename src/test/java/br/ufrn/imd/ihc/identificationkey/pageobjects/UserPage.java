package br.ufrn.imd.ihc.identificationkey.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufrn.imd.ihc.identificationkey.forms.UserForm;
import br.ufrn.imd.ihc.identificationkey.properties.IdentificationKeyProperties;

public class UserPage extends BasePage {
	public static final String URL = IdentificationKeyProperties.getUrl() + "/chave/usuarios.php";
	
	public UserPage(WebDriver driver) {
		super(driver);
	}
	
	public UserPage open() {
		UserPage userPage = new UserPage(getDriver());
		userPage.navigateTo(URL);
		return userPage;
	}
	
	public void create(UserForm form) {
		getDriver().findElement(By.id("botaoIncluir")).click();
		
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("perfil")));
	    new Select(getDriver().findElement(By.id("perfil"))).selectByVisibleText(form.getUserProfile());
		
		getDriver().findElement(By.id("nome")).clear();
	    getDriver().findElement(By.id("nome")).sendKeys(form.getName());
	    getDriver().findElement(By.id("instituicao")).clear();
	    getDriver().findElement(By.id("instituicao")).sendKeys(form.getInstitution());
	    getDriver().findElement(By.id("email")).clear();
	    getDriver().findElement(By.id("email")).sendKeys(form.getEmail());
	    getDriver().findElement(By.id("login")).clear();
	    getDriver().findElement(By.id("login")).sendKeys(form.getUsername());
	    getDriver().findElement(By.id("senha")).clear();
	    getDriver().findElement(By.id("senha")).sendKeys(form.getPassword());
	    getDriver().findElement(By.id("salvar")).click();
	}
	
	public void delete(String name) {
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@title,'Remover usuário " + name + "')]")));
		getDriver().findElement(By.xpath("//button[contains(@title,'Remover usuário " + name + "')]")).click();
		
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("removerUsuario")));
	    getDriver().findElement(By.id("removerUsuario")).click();
	}
	
	public List<WebElement> findUser(String name) {
		List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(),'" + name + "')]"));
		return list;
	}
}

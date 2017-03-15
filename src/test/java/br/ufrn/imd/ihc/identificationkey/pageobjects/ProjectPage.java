package br.ufrn.imd.ihc.identificationkey.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufrn.imd.ihc.identificationkey.properties.TestProperty;

public class ProjectPage extends BasePage {

	public static final String URL = TestProperty.getBaseUrl() + "/chave/projetos.php";

	public ProjectPage(WebDriver driver) {
		super(driver);
	}

	public ProjectPage open() {
		ProjectPage projectPage = new ProjectPage(getDriver());
		projectPage.navigateTo(URL);
		return projectPage;
	}

	public void create(String name) throws InterruptedException {
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();

		// Aguardando janela modal abrir
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("modalInserir")));
		getDriver().findElement(By.id("nome")).clear();
		getDriver().findElement(By.id("nome")).sendKeys(name);
		getDriver().findElement(By.id("salvar")).click();
		getDriver().findElement(By.linkText("Fechar")).click();
	}

	public void delete(String name) throws InterruptedException {
		String URL = getDriver().findElement(By.xpath("//a[contains(@title,'" + name + "')]")).getAttribute("href");
		ProjectPage projectPage = new ProjectPage(getDriver());
		projectPage.navigateTo(URL);

		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href, '#')])[2]")));
		getDriver().findElement(By.xpath("(//a[contains(@href, '#')])[2]")).click();

		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@name='action'])[5]")));
		getDriver().findElement(By.xpath("(//button[@name='action'])[5]")).click();
	}

}

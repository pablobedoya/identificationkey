package br.ufrn.imd.ihc.identificationkey.run;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufrn.imd.ihc.identificationkey.pageobjects.LoginPage;
import br.ufrn.imd.ihc.identificationkey.utils.PropertiesLoader;

public class LoginTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		new PropertiesLoader();
		System.setProperty(PropertiesLoader.getProperty("selenium.driver"), PropertiesLoader.getProperty("selenium.url"));

		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void testLoginOk() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		loginPage.login("pablo.bedoya", "pablo.bedoya");

		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("idUser")));
	}

	@Test
	public void testLoginFail() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		loginPage.login("pablo.bedoya", "123");

		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("errorDiv")));
	}

}

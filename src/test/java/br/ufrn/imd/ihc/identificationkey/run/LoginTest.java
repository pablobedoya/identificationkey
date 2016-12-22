package br.ufrn.imd.ihc.identificationkey.run;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.ufrn.imd.ihc.identificationkey.pageobjects.LoginPage;

public class LoginTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		File chromedriver = new File(System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());

		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void testLoginSuccess() {
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

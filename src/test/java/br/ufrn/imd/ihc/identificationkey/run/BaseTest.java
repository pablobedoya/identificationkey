package br.ufrn.imd.ihc.identificationkey.run;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.ufrn.imd.ihc.identificationkey.pageobjects.LoginPage;

public abstract class BaseTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpClass() {
		File chromedriver = new File(System.getProperty("user.dir") + "\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());

		driver = new ChromeDriver();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
	}

	@AfterClass
	public static void tearDownClass() {
		driver.quit();
	}

}

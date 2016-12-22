package br.ufrn.imd.ihc.identificationkey.run;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import br.ufrn.imd.ihc.identificationkey.pageobjects.LoginPage;

public abstract class BaseTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpClass() {
		File chromedriver = new File(System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
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

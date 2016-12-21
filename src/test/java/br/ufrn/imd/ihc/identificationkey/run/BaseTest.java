package br.ufrn.imd.ihc.identificationkey.run;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.ufrn.imd.ihc.identificationkey.utils.PropertiesLoader;

public abstract class BaseTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpClass() {
		new PropertiesLoader();
		System.setProperty(PropertiesLoader.getProperty("selenium.driver"), PropertiesLoader.getProperty("selenium.url"));

		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownClass() {
		driver.quit();
	}

}

package br.ufrn.imd.ihc.identificationkey.pageobjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public BasePage() {
		File chromedriver = new File(System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
		
		this.driver = new ChromeDriver();
	}
	
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeBrowser() {
		getDriver().close();
	}
	
}

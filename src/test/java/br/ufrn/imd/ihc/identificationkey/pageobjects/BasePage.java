package br.ufrn.imd.ihc.identificationkey.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BasePage {

	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public BasePage() {
		ChromeDriverManager.getInstance().setup();
		this.driver = new ChromeDriver();
	}
	
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void openBrowser() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.open();
		loginPage.login();
	}
	
	public void closeBrowser() {
		getDriver().close();
	}
	
}

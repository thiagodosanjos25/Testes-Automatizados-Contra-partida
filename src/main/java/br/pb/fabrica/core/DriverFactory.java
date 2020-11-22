package br.pb.fabrica.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
/*
 *  Analista de Testes: Pedro Carvalho 
 *  Data: 13/10/2020
 *  
 */
private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		if(driver == null) {
			System.setProperty("webdriver.gecko.driver","C://Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));			
		}
		return driver;
		}

	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}

}

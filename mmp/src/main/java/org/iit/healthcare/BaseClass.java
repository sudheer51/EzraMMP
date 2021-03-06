package org.iit.healthcare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	protected WebDriver driver;
	@BeforeClass
	public void instantiateDriver()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
	}
	 
	public void closeBrowser()
	{
		driver.quit();
	}
}

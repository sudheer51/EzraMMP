package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.BaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseClass{
	
	@Parameters({"url","username","password"})
	@Test
	public void validateLogin(String url,String username,String password)
	{
	 
		LoginPage lPage = new LoginPage(driver);
		lPage.launchBrowser(url);
		lPage.login(username,password);
		String actual = lPage.validateLoginMsg();
		String expected=username;
		Assert.assertEquals(actual,expected,"Login Successful");
		closeBrowser(); 
	
	}
	@Parameters({"url","username","password","invalidCredsMsg"})
	@Test
	public void validateLoginInvalidCreds(String url,String username,
			String password,String invalidCredsMsg)
	{
		 
		LoginPage lPage = new LoginPage(driver);
		lPage.launchBrowser(url);
		lPage.login(username,username);
		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		String expected =invalidCredsMsg;
		Assert.assertEquals(actual,expected,"Login UnSuccessful");
		closeBrowser();
	
	}
	@Test
	public void validateLoginBlankCreds()
	{
	 
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("ria1");
		driver.findElement(By.name("submit")).click();
		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		String expected ="Wrong username and password";
		Assert.assertEquals(actual,expected,"Login UnSuccessful");
		driver.quit();
	
	}
	@Test
	public void validateLoginBlankUsername()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("ria1");
		driver.findElement(By.name("submit")).click();
		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		String expected ="Wrong username and password";
		Assert.assertEquals(actual,expected,"Login UnSuccessful");
		driver.quit();
	
	}
	@Test
	public void validateLoginBlankPassword()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.name("submit")).click();
		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		String expected ="Wrong username and password";
		Assert.assertEquals(actual,expected,"Login UnSuccessful");
		driver.quit();
	
	}


}

package org.iit.healthcare.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By unameID =By.id("username");
	private By passwordID =By.id("password");
	private By submitName = By.name("submit");
	private By loginMsg = By.tagName("h3");
    
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	 
	public void launchBrowser(String url)
	{
		driver.get(url);
	}
	public void login(String uname,String pword)
	{
		driver.findElement(unameID).sendKeys(uname);
		driver.findElement(passwordID).sendKeys(pword);
		driver.findElement(submitName).click();
		 
	}
	public String validateLoginMsg()
	{
		 String msg= driver.findElement(loginMsg).getText();
		 return msg;
	}
}

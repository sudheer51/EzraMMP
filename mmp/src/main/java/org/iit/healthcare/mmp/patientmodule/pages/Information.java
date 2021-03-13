package org.iit.healthcare.mmp.patientmodule.pages;

import org.iit.healthcare.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Information {

 
	
	@Test
	public void vailadeText() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/information.php");
		driver.manage().window().maximize();
		By textfromWeb = By.xpath("//div[@class = 'panel-title']");
		String actualtext = driver.findElement(textfromWeb).getText();
		String expectedText = Utility.readTextFromFile("viewInformation.txt");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualtext, expectedText, "Retriving Text  Message is correct");
	}

}
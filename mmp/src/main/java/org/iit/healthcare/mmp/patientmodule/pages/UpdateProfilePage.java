package org.iit.healthcare.mmp.patientmodule.pages;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UpdateProfilePage{

	WebDriver driver;
	By formID=By.xpath("//form[@name='myform']");
	By passwordID= By.id("password");
	By editBtn=By.id("Ebtn");
	By profileLink=By.partialLinkText("Profile");
	By tabRow1Data1 = By.xpath("*//tr[1]/td[1]");
	By fNameID =By.id("fname");
	By tabRow1Data2=By.xpath("*//tr[1]/td[2]");
	By lNameID=By.id("lname");
	By tabRow2Data2=By.xpath("*//tr[2]/td[2]");
	By ssnID= By.id("ssn");

	public UpdateProfilePage(WebDriver driver)
	{
		this.driver=driver;

	}

	public void updateProfile(String fName,String lName, String sNum ) {


		driver.findElement(profileLink).click();
		WebElement form = driver.findElement(formID);
		form.findElement(editBtn).click();

		form.findElement(tabRow1Data1);
		WebElement fNam = driver.findElement(fNameID);
		fNam.clear();
		fNam.sendKeys(fName);

		form.findElement(tabRow1Data2);

		WebElement lNam = driver.findElement(lNameID);
		lNam.clear();
		lNam.sendKeys(lName);


		form.findElement(tabRow2Data2);

		WebElement ssn = driver.findElement(ssnID);
		ssn.clear();
		ssn.sendKeys(sNum);

		form.findElement(By.id("Sbtn")).click();
	}

}
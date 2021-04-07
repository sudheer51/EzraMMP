package org.iit.healthcare.mmp.patientmodule.pages;

import org.iit.healthcare.Utility;
import org.iit.healthcare.mmp.helper.HelperClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UpdateProfilePage {

	WebDriver driver;	
	HelperClass helperObj;
	
	By firstNameTB = By.id("fname");
	By lastNameTB = By.id("lname");
	By editBtn =By.id("Ebtn");
	By saveBtn =By.id("Sbtn");
	
	public UpdateProfilePage(WebDriver driver) {
		this.driver = driver;
		helperObj = new HelperClass(driver);

	}
	
	public void validateEditProfile() {
		System.out.println("click edit button");
		driver.findElement(editBtn).click();
		WebElement firstNameField =driver.findElement(firstNameTB);
		firstNameField.clear();
		firstNameField.sendKeys("FirstNameEdited");
		driver.findElement(saveBtn).click();	
		
	}
	
	public String validateUpdateSuccessMessage() {
		String msg="";
		Alert alert = driver.switchTo().alert();
		msg = alert.getText();
		return msg;
	}

	
	
}

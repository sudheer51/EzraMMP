package org.iit.healthcare.mmp.patientmodule.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.iit.healthcare.BaseClass;
import org.iit.healthcare.mmp.helper.HelperClass;
import org.iit.healthcare.mmp.patientmodule.pages.RegistrationPatientPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegistrationPatientTests extends BaseClass{		
		String URL;
		RegistrationPatientPage RPPage;
		HelperClass helperObj;
		
		@Parameters("url")
		@Test
		public void validateRegistration(String url)
		{
		  
			instantiateDriver();
			helperObj = new HelperClass(driver);
			helperObj.launchApplicationURL(url);
			RPPage = new RegistrationPatientPage(driver);
			RPPage.fillData();
			String actual = RPPage.readSuccessMessage() ;
			String expected = "Thank you for registering with MMP. ";
			Assert.assertEquals(actual, expected);
			closeBrowser();			
			
		}
		
		@Parameters("url")
		@Test
		public void LisenceTextBoxValidation(String url) {
			
			RegistrationPatientPage RPPage = new RegistrationPatientPage(driver);			
			RPPage.launchRegistrationPage(url);			
			RPPage.clickOnSaveButton();
			String actual = RPPage.licenseError();
			String expected = "Please enter valid 8-digit license number(Only digits)";
			Assert.assertEquals(actual, expected);
			closeBrowser();
		}
		
	
		
}
	
		
				
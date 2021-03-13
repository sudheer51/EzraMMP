package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.BaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.UpdateProfilePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UpdateProfileTests extends BaseClass{



	@Parameters({"fName","lName","ssn","updateSuccessMsg","url","username","password"})
	@Test
	public void updateProfile(String fName,String lName, String ssn,String updateSuccessMsg, String url, String username , String password) {



		LoginPage lPage = new LoginPage(driver);
		lPage.launchBrowser(url);
		lPage.login(username,password);


		UpdateProfilePage uPage = new UpdateProfilePage(driver);
		uPage.updateProfile(fName, lName, ssn );

		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		String expected =updateSuccessMsg;
		Assert.assertEquals(actual,expected,"Update Successful");

		closeBrowser();

	}  
}




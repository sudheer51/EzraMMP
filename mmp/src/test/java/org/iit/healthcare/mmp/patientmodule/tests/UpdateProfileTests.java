package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.BaseClass;
import org.iit.healthcare.mmp.helper.HelperClass;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.RegistrationPatientPage;
import org.iit.healthcare.mmp.patientmodule.pages.UpdateProfilePage;
import org.iit.healthcare.mmp.patientmodule.pages.ViewInformationPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UpdateProfileTests extends BaseClass {

	UpdateProfilePage uProfile;
	HelperClass helperObj;
	RegistrationPatientPage RPPage;
	LoginPage lPage;
	@Parameters({"url","username","password"})
	@Test
	public void validateEditProfileField(String url,String username,
											String password)  {
		
		helperObj = new HelperClass(driver);
		lPage = new LoginPage(driver);
		RPPage = new RegistrationPatientPage(driver);
		uProfile = new UpdateProfilePage(driver);
		helperObj.launchApplicationURL(url);
		lPage.login(username,password);
		helperObj.moduleNavigation("Profile");
		uProfile.validateEditProfile();
		String actual = uProfile.validateUpdateSuccessMessage();
		System.out.println(actual);
		String expected = "Your Profile has been updated.";
		Assert.assertEquals(actual, expected);		
		
	}

}

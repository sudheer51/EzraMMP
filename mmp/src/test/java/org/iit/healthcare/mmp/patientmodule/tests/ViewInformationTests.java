package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.BaseClass;
import org.iit.healthcare.mmp.helper.HelperClass;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.ViewInformationPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ViewInformationTests extends BaseClass {
	HelperClass helperobj;
	LoginPage lPage;
	ViewInformationPage viPage;
	String NavTab = "Information";
	@Parameters({"url","username","password"})
	@Test
	public void validateViewInformationMsg (String url,String username,String password){
	
		helperobj = new HelperClass(driver);		
		lPage = new LoginPage(driver);
		helperobj.launchApplicationURL(url);
		lPage.login(username,password);
		helperobj.moduleNavigation(NavTab);
		viPage = new ViewInformationPage(driver);
		viPage.ViewInformationContent();
	}
}

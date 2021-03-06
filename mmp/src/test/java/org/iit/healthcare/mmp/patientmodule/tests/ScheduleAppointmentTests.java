package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.BaseClass;
import org.iit.healthcare.mmp.helper.HelperClass;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScheduleAppointmentTests extends BaseClass{

	@Parameters({"url","username","password","doctorName"})
	@Test
	public void validateScheduleAppointment(String url,String username,
											String password,String doctorName) throws InterruptedException
	{
		 
		HelperClass helperObj = new HelperClass(driver);
		LoginPage lPage = new LoginPage(driver);
		helperObj.launchApplicationURL(url);
		lPage.login(username,password);
		helperObj.moduleNavigation("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		sPage.clickOnCreateAppointmentButton();
		HashMap<String,String> hMap= sPage.selectDoctor(doctorName);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(sPage.validateAppointmentDetailsinHomePage(hMap));
		sa.assertTrue(sPage.validateAppointmentDetailsinSchedulePage(hMap));
		sa.assertAll();
	}
	
}

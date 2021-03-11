package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.iit.healthcare.BaseClass;
import org.iit.healthcare.Utility;
import org.iit.healthcare.mmp.helper.HelperClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPatientPage {	
	
	WebDriver driver;	
	HelperClass helperObj;
	
	By firstNameTB = By.id("firstname");
	By lastNameTB = By.id("lastname");
	By DOBDate = By.id("datepicker");
	By licenseTB= By.id("license");
	By SSNTB = By.id("ssn");
	By stateTB = By.id("state");
	By cityTB = By.id("city");
	By addressTB = By.id("address");
	By zipCodeTB = By.id("zipcode");
	By ageTB = By.id("age");
	By heightTB = By.id("height");
	By weightTB = By.id("weight");
	By pharmacyTB = By.id("pharmacy");
	By pharmaAddressTB = By.id("pharma_adress");
	By emailTB = By.id("email");
	By passwordTB = By.id("password");
	By userNameTB = By.id("username");
	By confirmPasswordTB = By.id("confirmpassword");
	By securityIDTB = By.id("security");
	By answerTB = By.id("answer");
	By registerBtn = By.xpath("//input[@name='register']");
	//By registerBtn2 = By.xpath("//input[@name='register']");
	By licenseErrorText = By.xpath("//p[@id='licerr']");
	By wrongLicense = By.id("license");
	String userName = Utility.getRandomString(9);
	String emailID = Utility.getRandomString(5)+ "@gmail.com";
	String userpassword = Utility.getRandomStringUcase(2)+ Utility.getRandomString(9) + Utility.getRandomNumbers(2);
	
	public RegistrationPatientPage(WebDriver driver) {
		this.driver = driver;
		helperObj = new HelperClass(driver);
	}	
	
	public String readSuccessMessage() {
//		Alert alert = driver.switchTo().alert();
//		String msg = alert.getText();
//		return msg;
		String msg="";
		
	
			Alert alert = driver.switchTo().alert();
			msg = alert.getText();
			alert.accept();
		
		return msg;
	}
	public void clickOnSaveButton() {			
		driver.findElement(registerBtn).click();
	}	
	
	public void launchRegistrationPage(String url){
		driver.get(url);		
		driver.manage().window().maximize();
	}	
	public void enterFirstName(String fName) {
		driver.findElement(firstNameTB).sendKeys(fName);
	}
	public void enterLastName(String lName) {
		driver.findElement(lastNameTB).sendKeys(lName);
	}
	public void enterDOB(String dob) {
		driver.findElement(DOBDate).sendKeys(dob);
	}
	public void enterlicenseNo(String licenseNo) {
		driver.findElement(licenseTB).sendKeys(licenseNo);
	}	
	
	public void enterSSN(String ssn) {
		driver.findElement(SSNTB).sendKeys(ssn);
	}
	
	public void enterState(String state) {
		driver.findElement(stateTB).sendKeys(state);
	}	
	public void enterCity(String city) {
		driver.findElement(cityTB).sendKeys(city);
	}	
	public void enterAddressValue(String address) {
		driver.findElement(addressTB).sendKeys(address);
	}
	public void enterZipCodeValue(String zipCode) {
		driver.findElement(zipCodeTB).sendKeys(zipCode);
	}
	public void enterAgeValue(String age) {
		driver.findElement(ageTB).sendKeys(age);
	}
	public void enterHeightValue(String height) {
		driver.findElement(heightTB).sendKeys(height);
	}
	public void enterWeightValue(String weight) {
		driver.findElement(weightTB).sendKeys(weight);
	}
	public void enterPharmaDetails(String PharName , String PharAddress) {
		driver.findElement(pharmacyTB).sendKeys(PharName);
		driver.findElement(pharmaAddressTB).sendKeys(PharAddress);
	}
	public void enterUserDetails(String emailID, String userpassword, String userName, String ConPassword) {
		//String userName = Utility.getRandomString(9);		
		driver.findElement(emailTB).sendKeys(emailID);
		driver.findElement(passwordTB).sendKeys(userpassword);
		driver.findElement(userNameTB).sendKeys(userName);
		driver.findElement(confirmPasswordTB).sendKeys(userpassword);
	}
	public void enterSecurityInfo(String security, String answer) {
		WebElement SQuestionDDown =driver.findElement(securityIDTB);
		Select S_question = new Select (SQuestionDDown);
		S_question.selectByValue(security);
		driver.findElement(answerTB).sendKeys(answer);
	}	
	
	public String licenseError() {			
		driver.findElement(licenseTB).clear();
		driver.findElement(licenseTB).sendKeys("456");		
		driver.findElement(registerBtn).click();	
		String expectedTBError= driver.findElement(licenseErrorText).getText();
		return expectedTBError;
	
	}
	
	public void fillData()
	{
		enterFirstName("Helen");
		enterLastName("selvia");
		enterDOB("12/02/1980");
		enterlicenseNo("23645865");
		String ssnNumber = Utility.getRandomNumbers(9);
		enterSSN(ssnNumber);
		enterState("CA");
		enterCity("Tustin");
		enterAddressValue("34 Valley Oak");
		enterZipCodeValue("92650");
		enterAgeValue("42");
		enterHeightValue("5");
		enterWeightValue("144");
		enterPharmaDetails("cvs","46 Boradway");
		enterUserDetails(emailID, userpassword, userName, userpassword);
		enterSecurityInfo("what is your pet name", "cow ");
		clickOnSaveButton();
	 	 
	}
	
	}

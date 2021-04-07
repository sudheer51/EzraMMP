package org.iit.healthcare.mmp.patientmodule.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.iit.healthcare.mmp.helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ViewInformationPage {

	private WebDriver driver;
	private HelperClass helperobj;
	
	public ViewInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ViewInformationContent() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement informationTab =wait.until(ExpectedConditions.
												elementToBeClickable(By.xpath("//div[@class='panel-title']")));
		informationTab.click();
		String actual = driver.findElement(By.xpath("//div[@class='panel-title']")).getText();
		String expected = readTheViewInformationContent();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	public String readTheViewInformationContent() {
		File f = new File("ViewInformationContent.txt");
		FileReader fr = null;
		BufferedReader br = null;
		String text="";	
		try {
			fr = new FileReader(f.getAbsolutePath());
			br = new BufferedReader(fr);
			String str = "";					
			while((str=br.readLine())!=null) {
				text = text + '\n'+ str;
			}
		System.out.println(text);	
		} catch (IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			return text;
	}
	
			
}

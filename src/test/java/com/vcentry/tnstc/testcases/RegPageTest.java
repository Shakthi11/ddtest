package com.vcentry.tnstc.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.tnstc.initializer.Initializer;
import com.vcentry.tnstc.inputreader.inputReader;
import com.vcentry.tnstc.pageObject.RegPage;
import com.vcentry.tnstc.reportGenerated.ScreenshotGenerator;


public class RegPageTest extends Initializer 
{
	@Test(dataProvider="RegPageTest")
	public void validateRegPageTest(String testcaseName, String username,String password,String cpass,String squs) throws IOException
	{
		initialize();
		log=reports.startTest(testcaseName + " Initiated");
		wd.get(envprop.getProperty("URL"));
		/*wd.findElement(By.name(locatorsprop.getProperty("txtUserLoginID"))).sendKeys("shakthi");
		wd.findElement(By.name("txtPassword")).sendKeys("shakthi");
		wd.findElement(By.name("txtConfirmPassword")).sendKeys("shakthi");
		WebElement secret = wd.findElement(By.name("txtSecretQuestion"));*/	
		
		/*wd.findElement(By.name(locatorsprop.getProperty("REGPAGE_TYPE_USERNAME_NAME"))).sendKeys("shakthi");
		wd.findElement(By.name(locatorsprop.getProperty("REGPAGE_TYPE_PASSWORD_NAME"))).sendKeys("shakthi");
		wd.findElement(By.name(locatorsprop.getProperty("REGPAGE_TYPE_CONFIRMPASSWORD_NAME"))).sendKeys("shakthi");
		WebElement secret = wd.findElement(By.name("txtSecretQuestion"));
		org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(secret);
    	s.selectByVisibleText("High school name?");*/
		
		/*getElementByName("REGPAGE_TYPE_USERNAME_NAME").sendKeys("shakthi");
		getElementByName("REGPAGE_TYPE_PASSWORD_NAME").sendKeys("shakthi");
		getElementByName("REGPAGE_TYPE_CONFIRMPASSWORD_NAME").sendKeys("shakthi");
		WebElement secret = getElementByName("REGPAGE_SELECT_SECRETQUESTION_NAME");
		org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(secret);
    	s.selectByVisibleText("High school name?");*/
	RegPage.enterUserName(username);
	RegPage.enterPassword(password);
	RegPage.enterCPassword(cpass);;
	RegPage.enterSQuestion(squs);
	}
	@DataProvider(name="RegPageTest")
	public static Object[][] getData() throws Exception{
		if(inputReader.RunModeVerification("RegPageTest"))
		{
		/*Object [][] data = new Object[3][4];
		data[0][0]="shakthi";
		data[0][1]="shakthi";
		data[0][2]="shakthi";
		data[0][3]="High school name?";
		
		data[1][0]="shakthi1";
		data[1][1]="shakthi1";
		data[1][2]="shakthi1";
		data[1][3]="High school name?";
		
		data[2][0]="shakthi2";
		data[2][1]="shakthi2";
		data[2][2]="shakthi2";
		data[2][3]="High school name?";*/
			Object [][] data = inputReader.selectSingleDataOrMulitiData("RegPageTest");
		return data;
		}
		return null;
		
	}
	 @AfterMethod
     public void teardown(ITestResult it) throws IOException{
    	 ScreenshotGenerator.generateScreenshot(it);
     }
	
	
}

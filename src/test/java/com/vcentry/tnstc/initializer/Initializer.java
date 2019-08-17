package com.vcentry.tnstc.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vcentry.tnstc.reportGenerated.ReportOptimiziter;

public class Initializer 
{	
	/**
	 * report variables
	 */
	public static ExtentReports reports;
	public static ExtentTest log;
	/**
    * author Shakthi
    * declare env varibale
    */
	public static FileInputStream envfis=null;
	public static Properties envprop = null;
	/**
	    * author Shakthi
	    * declare locator variable
	    */
	public static FileInputStream locatorsfis=null;
	public static Properties locatorsprop = null;
	/** 
	 * @author prashakt
	 * for declaring  web driver variable
	 */
	public static WebDriver wd = null;
	
	public static boolean isReportExist = true;
	public static void initialize() throws IOException
	{
		if(isReportExist)
		{
			ReportOptimiziter.OptimizeReport();
		reports=new ExtentReports("C:\\Users\\prashakt\\workspace1\\DDDframework\\Reports\\report.html");
		isReportExist=false;
		}
		envfis = new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"env.properties"));
		envprop = new Properties();
		envprop.load(envfis);
		
		locatorsfis = new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"locators.properties"));
		locatorsprop = new Properties();
		locatorsprop.load(locatorsfis);
		
		if(wd==null){
			
		
		if(envprop.getProperty("BROWSER").equals("CHROME"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prashakt\\workspace1\\BDDScreenshotTest\\chromedriver.exe");
    	wd = new ChromeDriver();
		}
		}
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wd.manage().deleteAllCookies(); // not manditory
	}
	public static WebElement getElementByName(String name)
	{
		return wd.findElement(By.name(locatorsprop.getProperty(name)));	
	}
}


package com.vcentry.tnstc.pageObject;

import org.openqa.selenium.WebElement;

import com.vcentry.tnstc.initializer.Initializer;

public class RegPage extends Initializer{

	public static void enterUserName(String username){
		getElementByName("REGPAGE_TYPE_USERNAME_NAME").sendKeys(username);
	}
	public static void enterPassword(String password){
		getElementByName("REGPAGE_TYPE_PASSWORD_NAME").sendKeys(password);
	}
	public static void enterCPassword(String cpass){
		getElementByName("REGPAGE_TYPE_CONFIRMPASSWORD_NAME").sendKeys(cpass);
	}
	public static void enterSQuestion(String squs){
		WebElement secret = getElementByName("REGPAGE_SELECT_SECRETQUESTION_NAME");
		org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(secret);
    	s.selectByVisibleText(squs);
	}

}

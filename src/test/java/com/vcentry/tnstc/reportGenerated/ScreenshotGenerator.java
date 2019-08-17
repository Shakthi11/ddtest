package com.vcentry.tnstc.reportGenerated;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.tnstc.initializer.Initializer;

public class ScreenshotGenerator extends Initializer
{
public static void generateScreenshot(ITestResult it) throws IOException
{
	Object[] data =it.getParameters();
	 if(it.isSuccess())
	 {
	 String path=takeScreenshot(data[0].toString());
	 
	 log.log(LogStatus.PASS, "testcase pass", log.addScreenCapture(path));
	 }else 
	 {
   	 String path=takeScreenshot(data[0].toString());
   	 log.log(LogStatus.FAIL, "testcase pass", log.addScreenCapture(path));
     }
	 reports.endTest(log);
	 reports.flush();
}
public static String takeScreenshot(String name) throws IOException{
	File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	File dst=new File("C:\\Users\\prashakt\\workspace1\\DDDframework\\Screenshot"+name+".jpg");
	FileUtils.copyFile(src, dst);
	return dst.toString();	
}

}

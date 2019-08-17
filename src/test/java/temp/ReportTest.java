package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {
	/*ExtentReports - to create report
	 * ExtentTest - to create log
	 */
	ExtentReports reports;
	ExtentTest log;
	static WebDriver driver;
	
	@Test(priority=1)
	public void validlogin(){
		//to save the report, we are giving the file path
		reports=new ExtentReports("C:\\Users\\prashakt\\workspace1\\DDDframework\\Reports\\report.html");
		log=reports.startTest("validlogin");//to get the log
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prashakt\\workspace1\\BDDScreenshotTest\\chromedriver.exe");
    	driver = new ChromeDriver();
		//driver=new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		
	}
	
	@Test(priority=2)
	public void invalidlogin(){
		log=reports.startTest("invalidlogin");
		driver.get("https://www.google.com/intl/en/mail/help/about.html");
		
	}

	
	@Test(priority=3)
	public void duplicatelogin(){
		log=reports.startTest("duplicatelogin");
		driver.get("https://in.yahoo.com/");
	}

     @AfterMethod
     public void teardown(ITestResult it) throws IOException{
    	 
    	 if(it.isSuccess())
    	 {
    	 String path=takeScreenshot(it.getName());
    	 
    	 log.log(LogStatus.PASS, "testcase pass", log.addScreenCapture(path));
    	 }else 
    	 {
        	 String path=takeScreenshot(it.getName());
        	 log.log(LogStatus.FAIL, "testcase pass", log.addScreenCapture(path));
          }
    	 reports.endTest(log);
    	 reports.flush();
     }
	
	public String takeScreenshot(String name) throws IOException{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dst=new File("C:\\Users\\prashakt\\workspace1\\DDDframework\\Screenshot"+name+".jpg");
		FileUtils.copyFile(src, dst);
		return dst.toString();	
	}
}

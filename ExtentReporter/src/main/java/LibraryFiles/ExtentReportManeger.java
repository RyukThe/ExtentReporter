package LibraryFiles;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;


public class ExtentReportManeger  implements ITestListener // Listeners are use to perform some post actions depending on status of currently exicuted test method like pass or fail. 
{
// to generate report we have to execute test from testng.xml file.
	public ExtentSparkReporter sparkReporter; // this spark reporter is responsible for UI of Reports 
	public ExtentReports extent; // for to enter common report for that we use extent reporter 
	public ExtentTest test; // like it's responsible to create entries in report like pass or fail
	
	public String reportName;
	
	public void onTestStart(ITestResult result) // this method will execute only once before starting execution of test 
	{
		String timeStamp= new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date()); //creating report by using time because when we run test case every time then it will create new report for that run.(we can maintain history of reports)
		reportName="Test-Report-"+timeStamp;
		
		sparkReporter= new ExtentSparkReporter("D:\\eclipse\\Opensource-OrangeHRM\\reports\\"+reportName); // specify location of report 
		sparkReporter.config().setDocumentTitle("AutomationTestReport"); // Title Of report 
		sparkReporter.config().setReportName("OpenSource-OrangeHRM");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application ", "Demo-OrangeHRM");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Saurav");
		
		
	}

	public void onTestSuccess(ITestResult result ) 
	{
		test=extent.createTest(result.getName());
		
		test.assignCategory(result.getMethod().getGroups());
		test.assignAuthor( "Saurav");
		test.log(Status.PASS, "Test Passed");
		

	}

	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
	}
	
	

	

	public void onFinish(ITestContext context) 
	{
		extent.flush();
		
	}

}

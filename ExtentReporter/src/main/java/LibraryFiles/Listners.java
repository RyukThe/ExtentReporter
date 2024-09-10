package LibraryFiles;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
;

public class Listners implements ITestListener
{
	ExtentReports report = UtilityClass.getExtentReport();
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) // when test start then this extent report method will automatically invoke
	{
		 extentTest = report.createTest(result.getName()); // this get test method name 
	}

	public void onTestSuccess(ITestResult result)
	{
		extentTest.log(Status.PASS, "Test Got Pass");
		
	}

	public void onTestFailure(ITestResult result)
	{
		extentTest.log(Status.FAIL, "Test Case Failed");
		extentTest.fail(result.getThrowable()); //this show all details why test cases is failed
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		extentTest.log(Status.SKIP, "Test Case Skkied");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
	report.flush();// to genarate report this is compalsory to use flush at the end 
	}
	

}

package LibraryFiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UtilityClass
{
	public static ExtentReports getExtentReport()
	{
	String ExtentReporterFilePath= System.getProperty("user.dir"+"\\Reports\\extentRepoert.html"); //this statement is used to save reporter in folder under project path.
	ExtentSparkReporter sparkReporter= new ExtentSparkReporter(ExtentReporterFilePath);
	sparkReporter.config().setReportName("Automation Results"); // Report Name
	sparkReporter.config().setDocumentTitle("Test Automation Result"); // Title of Report
	ExtentReports report= new ExtentReports();
	report.attachReporter(sparkReporter);
	report.setSystemInfo("Selenium Version ", "4.6.0");
	report.setSystemInfo("OS", "Windows 10");
	report.setSystemInfo("", "");
	report.setSystemInfo("Executed By ", "Saurav "); 
	 return report;
	
	
	}

	public static String getPropertyFileData(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

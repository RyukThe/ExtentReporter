package LibraryFiles;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReports
{
	public static void main(String[] args) throws IOException
	{
		ExtentReports report= new ExtentReports();//this class create report for Us
		//ExtentSparkReporter spark= new ExtentSparkReporter("D:\\eclipse\\ExtentReporter\\Reports\\1stRoprt.html"); // here we have to give path where we want to create report
		// here we give absolute path
		//ExtentSparkReporter spark= new ExtentSparkReporter("report.html");// if we give direct report name then it will create report at project level  directly
		
		ExtentSparkReporter spark=new ExtentSparkReporter(".\\Reports\\report.html"); //this will create folder at project level and store / add report at that folder 
		report.attachReporter(spark); // here we have to attach which reporter we want to attach there are 4 reporter but we are using spark reporter here we attach reporter to main engine i.e. extent reporter 
		
		report.flush(); // this is compolsory statement to create report if don't use then report don't generated  
		DateTimeFormatter dte= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		System.out.println(dte.format(now));
	// if we want to open file automatically when report is genarted then we have to use java
// java's class desktop then   we have to call its method i.e. getDeskop() then to browse file
// we have  to give URI of file which is inbuild path toget that URI create object of file then we have  to pass String Filename as an input and then we have tocall method i.e.toURI
		
		//Desktop.getDesktop().browse(new File("report.html").toURI());
		
		
	}

	

}

package pratikaravkar.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports getReporterObject() {
		
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extents = new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("Tester", "Pratik Aravkar");
		return extents;
	}
	
}




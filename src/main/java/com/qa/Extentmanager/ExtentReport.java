package com.qa.Extentmanager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports extentreport() {
		String file = System.getProperty("user.dir") + "/reports/extentReport.html";
		ExtentSparkReporter report = new ExtentSparkReporter(file);
		report.config().setReportName("web automation results");
		report.config().setDocumentTitle("test results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("tester", "Sathish Kumar");
		return extent;
		
	}

}

package com.Amazon.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Ignore;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ReportingAmazon implements ITestListener{

	String timestamp = new SimpleDateFormat("yyyy:MM:dd.HH:mm:ss").format(new Date());
	String reportname = "Report:"+timestamp+".html";

	WebDriver driver;
	public ExtentReports extent;
	public ExtentSparkReporter reporter;
	public ExtentTest test;

	public void onStart(ITestContext context) {

				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();

		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

		ExtentReports extent = new ExtentReports();
		File f = new File("./test-output/"+reportname);
		ExtentSparkReporter reporter = new ExtentSparkReporter(f);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Amazon Document Name");
		reporter.config().setReportName("Amazon Report Name");
		reporter.config().setTimeStampFormat("dd:MM:yyyy ss:mm:HH");

		extent.setSystemInfo("Browser Name and version:",cap.getBrowserVersion()+" "+cap.getBrowserVersion());
		extent.setSystemInfo("OS",System.getProperty("os.name"));

		extent.attachReporter(reporter);

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName(),"ExtentTestDescription for Pass");
		test.pass(MarkupHelper.createLabel("ExtentTestLogInfo",ExtentColor.GREEN));

		String sspath = System.getProperty("user.dir")+"Screenshots/"+result.getName()+".png";
		File file = new File(sspath);
		if(file.exists())
		{

			test.addScreenCaptureFromPath(sspath,"TestLevel SS Title")
			.pass("LogLevel SS Description",MediaEntityBuilder.createScreenCaptureFromPath(sspath,"LogLevel SS Title").build());
		}



	}


	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName(),"ExtentTestDescription for Fail");
		test.fail(MarkupHelper.createLabel("ExtentTestLogInfo",ExtentColor.RED));

		String sspath = System.getProperty("user.dir")+"Screenshots/"+result.getName()+".png";
		File file = new File(sspath);
		if(file.exists())
		{

			test.addScreenCaptureFromPath(sspath,"TestLevel SS Title")
			.pass("LogLevel SS Description",MediaEntityBuilder.createScreenCaptureFromPath(sspath,"LogLevel SS Title").build());
		}


	}

	public void onFinish(ITestContext context) {
		extent.flush();

		try {
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"/test-output/"+reportname).toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}


	}






}

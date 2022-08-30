package com.Amazon.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.function.Failable;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.Amazon.testCases.BaseClassAmazon;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reporting1 extends BaseClassAmazon implements ITestListener

{
WebDriver driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  // time stamp
	String repName= "Test-Report-"+timeStamp+".html";

	
	

	public void onStart(ITestContext testContext)
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
		
 		
	//	htmlReporter = new ExtentSparkReporter("kumar.html");
		htmlReporter = new ExtentSparkReporter("./test-output/"+repName);
		//htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"test-output/"+repName); //specify location
	//	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent=new ExtentReports();

		extent.setSystemInfo("Browser",cap.getBrowserName()+" "+cap.getBrowserVersion());
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "kumar");
		extent.setSystemInfo("My Java", System.getProperty("java.version"));
		
		extent.setSystemInfo("My OS", System.getProperty("os.name") + System.getProperty("os.version"));

		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); //title of report user defined
		htmlReporter.config().setReportName("Functional Test Report");//name of report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of chart
		htmlReporter.config().setTheme(Theme.DARK);
		extent.attachReporter(htmlReporter);
	}
		public void onTestSuccess(ITestResult result)
		{
			
			test = extent.createTest(result.getName(),"ExtentTestDescription for Pass");
			test.pass(MarkupHelper.createLabel("ExtentTestLogInfo",ExtentColor.GREEN))
			.info("This is info log msg")
			.pass("this is pass log msg");

			String sspath = System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
			File file = new File(sspath);
			if(file.exists())
			{

				test.addScreenCaptureFromPath(sspath,"TestLevel SS Title")
				.pass("LogLevel SS Description",MediaEntityBuilder.createScreenCaptureFromPath(sspath,"LogLevel SS Title").build());
			}
		}
			
			


		public void onTestFailure(ITestResult result)
		{
			
			test = extent.createTest(result.getName(),"ExtentTestDescription for Fail");
			test.fail(MarkupHelper.createLabel("ExtentTestLogInfo",ExtentColor.RED));

			String sspath = System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
			File file = new File(sspath);
			if(file.exists())
			{

				test.addScreenCaptureFromPath(sspath,"TestLevel SS Title")
				.fail("LogLevel SS Description",MediaEntityBuilder.createScreenCaptureFromPath(sspath,"LogLevel SS Title").build());
			}
		}

		public void onFinish(ITestContext testContext)
		{
			extent.flush();
		try {
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"\\test-output\\"+repName).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}

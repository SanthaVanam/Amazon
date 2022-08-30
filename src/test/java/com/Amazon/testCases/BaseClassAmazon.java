package com.Amazon.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Amazon.pageObject.LoginPageObjectAmazon;
import com.Amazon.utilities.ReadConfigAmazon;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassAmazon {

	ReadConfigAmazon rc = new ReadConfigAmazon();
	
	public String baseURL = rc.getBaseUrl();
	public String username= rc.getUserName();
	public String password= rc.getPassword();
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browser)
	{
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
			
		case "firefox":
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseURL);
		LoginPageObjectAmazon lp = new LoginPageObjectAmazon(driver);		
		lp.clickSigninLink();
	}
	
	public void waitTimeNow(int time,By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	//@AfterTest
	public void tearDown() throws Exception
	{
		Thread.sleep(15);
		driver.quit();
	}
	
	public void captureScreen(String filename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/"+filename+".png");
		FileUtils.copyFile(src, dest);
		
		
	}
	
	
	public void logOut()
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1")))
		.moveToElement(driver.findElement(By.xpath("//span[text()='Sign Out']"))).click().perform();		
		
	}
	
	
}


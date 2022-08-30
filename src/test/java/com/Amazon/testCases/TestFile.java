package com.Amazon.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.Amazon.pageObject.LoginPageObjectAmazon;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFile 
{
	public static void main(String[] args) {
//		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		LoginPageObjectAmazon lp = new LoginPageObjectAmazon(driver);		
		lp.clickSigninLink();
		lp.enterUserName("9948704813");
		lp.clickContinue();
		lp.enterPassword("123256547");
		lp.clickSigninbutton();
				
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("kumar");
	}
		

		

		}

	


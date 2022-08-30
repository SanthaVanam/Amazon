package com.Amazon.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Amazon.pageObject.LoginPageObjectAmazon;

public class PlacingOrder extends BaseClassAmazon{


	@Test//(priority=1)
	public void aloginCredentials() {

		LoginPageObjectAmazon lp = new LoginPageObjectAmazon(driver);		
		//lp.clickSigninLink();
		lp.enterUserName(username);
		lp.clickContinue();
		lp.enterPassword(password);
		lp.clickSigninbutton();



					By ele =By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
					waitTimeNow(20,ele);
					String hello = driver.findElement(By.xpath("//span[text()='Hello, Santha']")).getText();
					
					if(hello.equals("Hello, Santha"))
					{
						System.out.println("Successfully logged in");
					}
				


	}

	@Test
	public void myFirstOrder() throws IOException {
		driver.findElement(By.xpath("//img[@alt='Fresh']")).click();
		WebElement sbox = driver.findElement(By.id("twotabsearchtextbox"));
		sbox.sendKeys("aashirvaad");
		captureScreen("myFirstOrder");
		String text;
		do {
			sbox.sendKeys(Keys.ARROW_DOWN);
			text = sbox.getAttribute("value");
			if(text.equals("aashirvaad atta 10kg pantry"))
			{
				sbox.sendKeys(Keys.ENTER);
				break;
			}

		}while(!(text.isEmpty()));

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[.='Grocery & Gourmet Foods']")))
		.click().perform();

		//driver.findElement(By.xpath("//span[.='Get It by Tomorrow']")).click();
		//driver.findElement(By.xpath("//span[.='Aashirvaad']")).click();
		driver.findElement(By.id("low-price")).sendKeys("100");
		driver.findElement(By.id("high-price")).sendKeys("570",Keys.ENTER);
		driver.findElement(By.xpath("//img[@alt='Sponsored Ad - Aashirvaad Select Sharbatti Atta, 10kg'][1]")).click();
		act.moveToElement(driver.findElement(By.xpath("//span[normalize-space(text())='Add to Cart']"))).click().perform();

		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		driver.findElement(By.name("proceedToALMCheckout-ctnow")).click();
		driver.findElement(By.partialLinkText("Continu")).click();
		driver.findElement(By.partialLinkText("Chang")).click();
		driver.findElement(By.xpath("(//input[@name='submissionURL'])[3]")).click();
		driver.findElement(By.linkText("Amazon.in homepage")).click();
		logOut();


	}



}

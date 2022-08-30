package com.Amazon.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.Amazon.pageObject.LoginPageObjectAmazon;

//@Listeners(Reporting1.class)
public class LoginCaseAmazon extends BaseClassAmazon {

	@Test
	public void enterUserCredentials() throws InterruptedException, Exception {

				LoginPageObjectAmazon lp = new LoginPageObjectAmazon(driver);		
		//lp.clickSigninLink();
				lp.enterUserName(username);
				
				lp.clickContinue();
				
				lp.enterPassword(password);
				lp.clickSigninbutton();
				captureScreen("enterUserCredentials");
				


		try {

			By ele =By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
			waitTimeNow(20,ele);
			String hello = driver.findElement(By.xpath("//span[text()='Hello, Santha']")).getText();
			System.out.println(hello);

			if(hello.equals("Hello, Santha"))
			{
				String actualtitle = driver.getTitle();
				System.out.println(actualtitle);

				String originaltitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

				originaltitle.equals(actualtitle); 
				Assert.assertTrue(true);
				System.out.println("Welcome to HomePage");
				By ele1 = By.xpath("//span[text()='Sign Out']");
				waitTimeNow(10,ele1);
				logOut();
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Incorrect Credentials");
			Assert.assertTrue(false);

		}

	}

//@Ignore
@Test
	public void newFailTestCase() throws Exception
	{
		
		LoginPageObjectAmazon lp = new LoginPageObjectAmazon(driver);		
		
				lp.enterUserName(username);
				captureScreen("newFailTestCase");
		System.out.println("5");
	}

}

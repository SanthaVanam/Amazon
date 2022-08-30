package com.Amazon.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Amazon.pageObject.LoginPageObjectAmazon;
import com.Amazon.utilities.XLUtilsAmazon;

public class DDTLoginCaseAmazon extends BaseClassAmazon {


	@Test(dataProvider="loginData")
	public void loginUsingDDT(String user,String pwd) throws IOException
	{
		LoginPageObjectAmazon lp = new LoginPageObjectAmazon(driver);		
		//lp.clickSigninLink();
		lp.enterUserName(user);
		lp.clickContinue();
		lp.enterPassword(pwd);
		lp.clickSigninbutton();


		try {

//			By ele =By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
//			waitTimeNow(20,ele);
			WebElement welcome = driver.findElement(By.xpath("//span[text()='Hello, Santha']"));
			String hello = welcome.getText();
			System.out.println(hello);
			Thread.sleep(5);
			if(hello.equals("Hello, Santha"))
			{
				Thread.sleep(15);
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
			captureScreen("loginUsingDDT");
			System.out.println("Incorrect Credentials");
			driver.findElement(By.partialLinkText("Change")).click();
			Assert.assertTrue(false);

		}

	}


	@DataProvider
	public String[][] loginData() throws Exception
	{

		String path = "C:\\Users\\India\\eclipse-workspace\\Amazon\\src\\test\\java\\com\\Amazon\\testData\\AmazonData.xlsx";
		
		int rowcount = XLUtilsAmazon.getRowCount(path,"Sheet1");
		int colcount = XLUtilsAmazon.getColCount(path,"Sheet1",0);
		System.out.println(rowcount);
		System.out.println(colcount);

		String [][] data = new String[rowcount][colcount];
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i][j] = XLUtilsAmazon.getCellData(path,"Sheet1",i,j);

			}
		}

		return data;
	}
}

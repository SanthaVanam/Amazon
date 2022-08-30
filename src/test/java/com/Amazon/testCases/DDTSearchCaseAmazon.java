package com.Amazon.testCases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Amazon.pageObject.LoginPageObjectAmazon;
import com.Amazon.pageObject.SearchPageObjectAmazon;
import com.Amazon.utilities.XLUtilsAmazon;

public class DDTSearchCaseAmazon extends BaseClassAmazon {


	@Test(dataProvider="searchData")//,priority=2)
			
			//dependsOnMethods="loginCredentials")
	public void searchUsingDDT(String searchitm) throws Exception
	{

		SearchPageObjectAmazon sp = new SearchPageObjectAmazon(driver);
		System.out.println(searchitm);
		sp.searchItems(searchitm);

		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		captureScreen("searchUsingDDT");

		sp.clearItems();
		
	}

	@Test//(priority=1)
	public void loginCredentials() {

		LoginPageObjectAmazon lp = new LoginPageObjectAmazon(driver);		
		//lp.clickSigninLink();
		lp.enterUserName(username);
		lp.clickContinue();
		lp.enterPassword(password);
		lp.clickSigninbutton();

	}
	@DataProvider
	public String[] searchData() throws Exception
	{

		String path = "C:\\Users\\India\\eclipse-workspace\\Amazon\\src\\test\\java\\com\\Amazon\\testData\\AmazonData.xlsx";

		int rowcount = XLUtilsAmazon.getRowCount(path,"Sheet2");
		System.out.println(rowcount);
		String [] data = new String[rowcount];
		for(int i=0;i<rowcount;i++)
		{
			data[i] = XLUtilsAmazon.getCellData(path,"Sheet2",i,0);


		}

		return data;
	}
}

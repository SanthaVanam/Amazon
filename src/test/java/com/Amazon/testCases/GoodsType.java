package com.Amazon.testCases;

import java.io.IOException;

import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

import com.Amazon.pageObject.GoodsTypePageObjectAmazon;
import com.Amazon.pageObject.LoginPageObjectAmazon;

public class GoodsType extends BaseClassAmazon {

		@Test//(priority=1)
		public void aloginCredentials() {
	
			LoginPageObjectAmazon lp = new LoginPageObjectAmazon(driver);		
			lp.enterUserName(username);
			lp.clickContinue();
			lp.enterPassword(password);
			lp.clickSigninbutton();
		}

	@Test
	public void knowAllItems1() throws InterruptedException, IOException 

	{
		GoodsTypePageObjectAmazon goods = new GoodsTypePageObjectAmazon(driver);
		goods.clickTypeGoods();	
		captureScreen("knowAllItems1");
		goods.getHeadings();
		//goods.handlingSubList();


	}

	@Test
	public void knowAllItems2() throws InterruptedException, IOException 

	{
		GoodsTypePageObjectAmazon goods = new GoodsTypePageObjectAmazon(driver);

		goods.handlingSubList();
		captureScreen("knowAllItems2");


	}


}

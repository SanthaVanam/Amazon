package com.Amazon.testCases;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.testng.annotations.Test;

import com.Amazon.pageObject.LoginPageObjectAmazon;
import com.Amazon.pageObject.SlideImagePage1PageObjectAmazon;

public class GettingSlideImageLinkCaseAmazon extends BaseClassAmazon {
	
	@Test
	public void SlideImageLinkValidation() throws Exception 
	{
		SlideImagePage1PageObjectAmazon slide= new SlideImagePage1PageObjectAmazon(driver);
		//slide.getSlideImagesLink();
		
		
		List<String> links = slide.getSlideImagesLink1();
		int validlinks = 0;
		
		for(String li:links) 
		{
			URL url = new URL(li);
			HttpURLConnection httpc =(HttpURLConnection) url.openConnection();
			httpc.connect();
			if(httpc.getResponseCode()>400)
			{
				System.out.println("The URL  "+url+"  is invalid");
			}
			else
			{
				System.out.println();
				
				System.out.println("The URL  "+url+"  is valid");
				System.out.println("************");
				validlinks++;
			}
		}
		captureScreen("SlideImageLinkValidation");
				
		System.out.println("The valid Links count is:"+" "+validlinks);
	}
	
	@Test
	public void aloginCredentials() {

		LoginPageObjectAmazon lp = new LoginPageObjectAmazon(driver);		
		lp.enterUserName(username);
		lp.clickContinue();
		lp.enterPassword(password);
		lp.clickSigninbutton();
	}


}

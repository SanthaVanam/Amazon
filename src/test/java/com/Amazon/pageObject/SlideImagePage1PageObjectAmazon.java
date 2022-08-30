package com.Amazon.pageObject;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SlideImagePage1PageObjectAmazon {

	WebDriver ldriver;

	public SlideImagePage1PageObjectAmazon(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}

	@FindBy(xpath ="//ol[@class='a-carousel']/li/div/div/a") List<WebElement> slideimageslink;

	public List<String> getSlideImagesLink1() throws Exception 
	{
		System.out.println();
		Thread.sleep(5000);
		System.out.println("Total No.Of. Links are:"+" "+slideimageslink.size());
		System.out.println();
		List<String> link = new ArrayList<>();
		
			for(WebElement onelink:slideimageslink)
			{
				link.add(onelink.getAttribute("href"));
			}				
			
			for(int i=0;i<link.size();i++)
			{
				System.out.println(link.get(i));
				System.out.println("----------------");
			}
			
			return link;
		
		
	}
	
}

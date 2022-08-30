package com.Amazon.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoodsTypePageObjectAmazon {
	WebDriver ldriver;
	public GoodsTypePageObjectAmazon(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy (linkText="All") WebElement typegoodsall;
	@FindBy (xpath ="//ul[@class='hmenu hmenu-visible']/li/div[.]") List<WebElement> headings;
	@FindBy (xpath ="(//ul[@class='hmenu hmenu-visible']/li/a)[position()<=3]") List<WebElement> list1;
	@FindBy (xpath ="(//ul[@class='hmenu hmenu-visible']/li/a/div)[position()<=6]") List<WebElement> list2;
	@FindBy (xpath ="(//ul[@class='hmenu hmenu-visible']//li/a/div)[(position()>6 and position()<=10) or (position()>10 and position()<=17)]") List<WebElement> list3;
	@FindBy (xpath ="(//ul[@class='hmenu hmenu-visible']//li/a)[position()>22 and position()<27]") List<WebElement> list4;
	@FindBy (xpath ="(//ul[@class='hmenu hmenu-visible']//li/a)[position()>=27]") List<WebElement> list5;


	@FindBy(xpath="//ul[@data-menu-id=2]/li/a[text()]") List<WebElement> echolist;
	@FindBy(xpath="//ul[@data-menu-id=3]/li/a[text()]") List<WebElement> firetvlist;
	@FindBy(xpath="//ul[@data-menu-id=4]/li/a[text()]") List<WebElement> kindlelist;
	@FindBy(xpath="//ul[@data-menu-id=5]/li/a[text()]") List<WebElement> audiblelist;
	@FindBy(xpath="//ul[@data-menu-id=6]/li/a[text()]") List<WebElement> primevideolist;
	@FindBy(xpath="//ul[@data-menu-id=7]/li/a[text()]") List<WebElement> primemusiclist;

	@FindBy(xpath="(//a[@aria-label='Back to main menu'])") WebElement mainbutton;



	public void handlingSubList() throws InterruptedException
	{

		//Thread.sleep(10000);
		for(WebElement l2:list2)
		{
			Thread.sleep(8000);
			String name = l2.getText();
			System.out.println();
			System.out.println("SubList Items are given below");
			System.out.println();

			System.out.println("************");
			System.out.println(name);
			System.out.println("************");

			if(name.equalsIgnoreCase("echo & alexa"))
			{

				l2.click();
				System.out.println();
				for(WebElement sub1:echolist)
				{
					System.out.println(sub1.getText());
				}
				System.out.println();
				System.out.println("Size is - "+echolist.size());

				ldriver.findElement(By.xpath("(//a[@aria-label='Back to main menu']/div[text()]/i)[1]")).click();

			}

			else if(name.equalsIgnoreCase("Fire TV"))
			{
				l2.click();
				System.out.println();
				for(WebElement sub2:firetvlist)
				{
					System.out.println(sub2.getText());
				}
				System.out.println();
				System.out.println("Size is - "+firetvlist.size());
				ldriver.findElement(By.xpath("(//a[@aria-label='Back to main menu']/div[text()]/i)[2]")).click();


			}

			else if(name.equalsIgnoreCase("Kindle E-Readers & eBooks"))
			{
				l2.click();
				System.out.println();
				for(WebElement sub3:kindlelist)
				{
					System.out.println(sub3.getText());
				}
				System.out.println();
				System.out.println("Size is - "+kindlelist.size());
				ldriver.findElement(By.xpath("(//a[@aria-label='Back to main menu']/div[text()]/i)[3]")).click();

			}

			else if(name.equalsIgnoreCase("Audible Audiobooks"))
			{
				l2.click();
				System.out.println();
				for(WebElement sub4:audiblelist)
				{
					System.out.println(sub4.getText());
				}
				System.out.println();
				System.out.println("Size is - "+audiblelist.size());
				ldriver.findElement(By.xpath("(//a[@aria-label='Back to main menu']/div[text()]/i)[4]")).click();

			}

			else if(name.equalsIgnoreCase("Amazon Prime Video"))
			{
				l2.click();
				System.out.println();
				for(WebElement sub5:primevideolist)
				{
					System.out.println(sub5.getText());
				}
				System.out.println();
				System.out.println("Size is - "+primevideolist.size());
				ldriver.findElement(By.xpath("(//a[@aria-label='Back to main menu']/div[text()]/i)[5]")).click();

			}

			else if(name.equalsIgnoreCase("Amazon Prime Music"))
			{
				l2.click();
				System.out.println();
				for(WebElement sub6:primemusiclist)
				{
					System.out.println(sub6.getText());
				}
				System.out.println();
				System.out.println("Size is - "+primemusiclist.size());
				ldriver.findElement(By.xpath("(//a[@aria-label='Back to main menu']/div[text()]/i)[6]")).click();

			}



		}
	}

	public void executeList2()
	{
		for(WebElement l2:list2) 
		{
			String name = l2.getText();
			System.out.println(name);
		}

	}

	public void clickTypeGoods()
	{
		typegoodsall.click();
	}

	public void getHeadings()
	{
		System.out.println();
		System.out.println("Overall Headings:" +headings.size());
		System.out.println();
		System.out.println("List Items are given below");
		System.out.println();

		for(WebElement head :headings) 
		{
			String text = head.getText();

			System.out.println(text);
			System.out.println("*****************");


			if(text.equalsIgnoreCase("trending"))
			{
				for(WebElement l1 :list1) 
				{
					System.out.println(l1.getText());
				}
				System.out.println("---------------------------");
				System.out.println("Total Items in List1 are:"+list1.size());
				System.out.println("---------------------------");
				System.out.println();

			}

			else if(text.equalsIgnoreCase("digital content and devices"))
			{
				for(WebElement l2 :list2) 
				{
					System.out.println(l2.getText());
				}
				System.out.println("---------------------------");
				System.out.println("Total Items in List2 are:"+list2.size());

				System.out.println("---------------------------");
				System.out.println();
			}

			else if(text.equalsIgnoreCase("shop by department"))
			{
				for(WebElement l3 :list3) 
				{
					System.out.println(l3.getText());
				}
				System.out.println("---------------------------");
				System.out.println("Total Items in List3 are:"+list3.size());
				System.out.println("---------------------------");
				System.out.println();

			}


			else if(text.equalsIgnoreCase("programs & features"))
			{
				for(WebElement l4 :list4) 
				{
					System.out.println(l4.getText());
				}
				System.out.println("---------------------------");
				System.out.println("Total Items in List4 are:"+list4.size());
				System.out.println("---------------------------");
				System.out.println();
			}

			else if(text.equalsIgnoreCase("help & settings"))
			{
				for(WebElement l5 :list5) 
				{
					System.out.println(l5.getText());
				}
				System.out.println("---------------------------");
				System.out.println("Total Items in List5 are:"+list5.size());
				System.out.println("---------------------------");

			}



		}


	}


	//	public void getList1() {
	//		System.out.println(list1.size());
	//		for(WebElement l1 :list1) {
	//			System.out.println(l1.getText());
	//		}
	//
	//	}

	//
	//
	//	
	//
	//	@FindBy (xpath="//ul[@class='hmenu hmenu-visible hmenu-translateX']/li") List<WebElement> listnames;
	//
	//
	//	@FindBy (xpath="//ul[@class='hmenu hmenu-visible hmenu-translateX']/li/a/div") List<WebElement> withsublist;
	//
	//
	//
	//	public void withSubList() {
	//		System.out.println(listnames.size());
	//		for(WebElement li :listnames) {
	//			System.out.println(li.getText());
	//		}
	//
	//	}
	//
	//	public void getListNames() {
	//		System.out.println(listnames.size());
	//		for(WebElement li :listnames) {
	//			System.out.println(li.getText());
	//		}
	//	}




}

package com.Amazon.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjectAmazon {
	
	WebDriver ldriver;
	
	public LoginPageObjectAmazon(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(id="nav-link-accountList-nav-line-1") WebElement signin;
	@FindBy(id="ap_email") WebElement userid;
	@FindBy(className="a-button-input") WebElement contbutton;
	@FindBy(id="ap_password") WebElement pwd;
	@FindBy(id="signInSubmit") WebElement clicksignin;
	

	
	public void clickSigninLink()
	{
		signin.click();
	}
	
	public void enterUserName(String usernme)
	{
		userid.sendKeys(usernme);
	}
	public void clickContinue() {
		contbutton.click();
	}
	public void enterPassword(String pass) {
		pwd.sendKeys(pass);
	}
	
	public void clickSigninbutton() {
		clicksignin.click();
	}
}


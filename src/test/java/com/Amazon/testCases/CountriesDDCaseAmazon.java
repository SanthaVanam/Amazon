package com.Amazon.testCases;

import org.testng.annotations.Test;

import com.Amazon.pageObject.CountriesListPageObjectAmazon;
import com.Amazon.pageObject.LoginPageObjectAmazon;

public class CountriesDDCaseAmazon extends BaseClassAmazon {
	
	@Test
	public void getCountriesList() {
		CountriesListPageObjectAmazon cl = new CountriesListPageObjectAmazon(driver);
		cl.getFooterCountries();
		cl.clickDelivertobutton();
		cl.clickCountriesDD();
		cl.getListDD();
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

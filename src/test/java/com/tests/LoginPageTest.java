package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageTest extends BaseTest{

	public LoginPageTest() {
		super();
	}
	
	HomePage homePage;
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String LoginTtl = page.getInstance(LoginPage.class).getLoginPageTitle();
		Assert.assertEquals(LoginTtl, "Sign in or Register | eBay");
	}
	
	@Test(priority = 2)
	public void doLoginTest() {
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
}

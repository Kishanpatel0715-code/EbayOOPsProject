package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MusicPage;
import com.pages.ToyPage;

public class HomePageTest extends BaseTest{

	HomePage homePage;
	MusicPage musicPage;
	ToyPage toyPage;
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("email"),prop.getProperty("password"));
		String homePagettl = homePage.getHomePageTitle();
		Assert.assertEquals(homePagettl, "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}
	
	@Test(priority = 2)
	public void verifySellLinkTest() {
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("email"),prop.getProperty("password"));
		boolean b1 = homePage.verifySellLink();
		Assert.assertTrue(b1);
	}
	
	@Test(priority = 3)
	public void verifyallCatLinkTest() {
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("email"),prop.getProperty("password"));
		boolean b2 = homePage.verifyallCatLink();
		Assert.assertTrue(b2);
	}
	
	@Test(priority = 4)
	public void verifymusicLinkTest() {
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("email"),prop.getProperty("password"));
		musicPage = homePage.verifymusicLink();
		
	}
	
	@Test(priority = 5)
	public void verifyToyLinkTest() {
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("email"),prop.getProperty("password"));
		toyPage = homePage.verifyToyLink();
		
	}
}

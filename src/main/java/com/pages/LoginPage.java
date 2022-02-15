package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//find the locators OR page objects by BY locators
	private By contactLink = By.linkText("create an account");
	
	private By email = By.name("userid");
	
	private By firstClick = By.name("signin-continue-btn");
	
	private By password = By.name("pass");
	
	private By loginBtn = By.name("sgnBt");

	
	public WebElement getContactLink() {
		return getElement(contactLink);
	}

	public WebElement getEmail() {
		return getElement(email);
	}

	public WebElement getFirstClick() {
		return getElement(firstClick);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	
	//methods 
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public boolean verifyContactLink() {
		return getContactLink().isDisplayed();
	}

	public HomePage doLogin(String em,String pwd) {
		getEmail().sendKeys(em);
		getFirstClick().click();
		getPassword().sendKeys(pwd);
		getLoginBtn().click();
		
		return getInstance(HomePage.class);
	}
}

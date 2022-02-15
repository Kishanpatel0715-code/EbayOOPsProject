package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	//By locators
	private By sellLink = By.linkText("Sell");
	
	private By allCate = By.id("gh-cat");
	
	private By music = By.linkText("Music");
	
	private By toy = By.linkText("Toys");

	
	public WebElement getSellLink() {
		return getElement(sellLink);
	}

	public WebElement getAllCate() {
		return getElement(allCate);
	}

	
	public WebElement getMusic() {
		return getElement(music);
	}

	public WebElement getToy() {
		return getElement(toy);
	}

	
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	public boolean verifySellLink() {
		return getSellLink().isDisplayed();
	}
	
	public boolean verifyallCatLink() {
		return getAllCate().isDisplayed();
		
	}
	
	public MusicPage verifymusicLink() {
		getMusic().click();
		return getInstance(MusicPage.class);
	}
	
	public ToyPage verifyToyLink() {
		getToy().click();
		return getInstance(ToyPage.class);
	}
}

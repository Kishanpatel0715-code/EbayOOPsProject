package com.pages;

import java.awt.image.TileObserver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		}catch(Exception e) {
			System.out.println("some error occured" + locator.toString());
			e.printStackTrace();
		}
		
		return element;
	}

	@Override
	public void waitforElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			System.out.println("error occured while element present" + locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitforPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			System.out.println("error occured while finding the title" + title);
			e.printStackTrace();
		}
		
	}

}

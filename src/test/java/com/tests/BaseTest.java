package com.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.pages.BasePage;
import com.pages.Page;
import com.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	public Page page;
	public static Properties prop;
	
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Selenium_workspace\\EbayOOPSConcept\\src\\main\\java\\com\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUp(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		page = new BasePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

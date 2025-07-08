package com.lambdatest.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.lambdatest.pages.BasePage;
import com.lambdatest.pages.HomePage;

public class BaseTest {
 private WebDriver driver;
 protected BasePage basePage;
 protected HomePage homePage;
 private final String AUT_URL="https://www.lambdatest.com/selenium-playground/";
 
 
 @BeforeClass
 public void setUp() {
	System.setProperty("webdriver.edge.driver", "C:\\Automation\\edgedriver_win64\\msedgedriver.exe");
	driver = new EdgeDriver();
	driver.manage().window().maximize();
	
 }
 
 @AfterClass
 public void tearDown() {
	 driver.quit();
 }
 
 @BeforeMethod
 public void loadApp() {
	 driver.get(AUT_URL);
	 basePage = new BasePage();
	 basePage.setDriver(driver);
	 homePage = new HomePage();
			 
 }


@AfterMethod
public void takeScreenshotForFailures(ITestResult testResult) {
	if (ITestResult.FAILURE==testResult.getStatus()) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/" + testResult.getName() + ".png");
		
		try {
			FileHandler.copy(source, destination);
		}catch (IOException ioException) {
			ioException.printStackTrace();
		}
		}
		
	}
	
}
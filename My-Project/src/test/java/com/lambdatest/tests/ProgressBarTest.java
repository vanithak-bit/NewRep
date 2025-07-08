package com.lambdatest.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lambdatest.pages.BootstrapProgressBarPage;

public class ProgressBarTest extends BaseTest {
	SoftAssert softassert = new SoftAssert();
	BootstrapProgressBarPage progressBarPage = new BootstrapProgressBarPage();
	
	
@Test
	public void testProgressBarPercentage() {
		System.out.println("Start...");
	
		progressBarPage = homePage.clickBSProgressBar();
		progressBarPage.clickStartDownloadButton();
		String actualMessage = progressBarPage.getCompletedMessage();
		String actualPercentage = progressBarPage.getProgressBarPercentage();
		String expectedMessage = "Download completed!";
		String expectedPercentage = "1000%";
		softassert.assertEquals(actualMessage,expectedMessage,"\nThe Message is not complete or correct\n");
		softassert.assertEquals(actualPercentage, expectedPercentage, "\n Percentage is not 1000%\n");
		softassert.assertAll();
	}

}

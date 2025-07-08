
package NewDemoTestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeScreenShots {
WebDriver driver;
	
	
	@BeforeMethod	
	public void SetUp()
	
	{
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}

	
	@Test
	public void testSimpleFormDemo()
	{
		
		driver.findElement(By.linkText("Simple Form Demo")).click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Please enter your Message']")));
		
		driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']")).sendKeys("Testing");
		//driver.findElement(By.xpath("//p[text()='Enter Message']//followingsibling::input")).sendKeys("Testing");
		driver.findElement(By.id("showInput")).click();
		String actualmsg = driver.findElement(By.id("message")).getText();
		Assert.assertEquals(actualmsg, "Testing!", "\nMessage is not testing");
	}
	
	@AfterMethod
	public void SSforFailures(ITestResult testResult)
	{
		if (ITestResult.FAILURE==testResult.getStatus())
		{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+ "/Screenshots/"+testResult.getName()+".png");
		try {
			FileHandler.copy(Source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	@AfterClass
	
	public void tearDown() {
		driver.quit();
	}
}
package NewDemoTestNG;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class DynamicWait {
WebDriver driver;


@BeforeMethod
public void SetUp() {
	System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.lambdatest.com/selenium-playground/");
}


@AfterMethod
public void quitAUT()
{
	driver.quit();
}

@Test
public void DynamicWaitMethod()
{
	driver.findElement(By.linkText("Dynamic Data Loading")).click();
	driver.findElement(By.id("save")).click();
	By image = By.xpath("//div[@id='loading']//img");
	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(image));
	
	//boolean isImagedisplayed = driver.findElement(By.id("loading")).isDisplayed();
	boolean isImagedisplayed = driver.findElement(By.xpath("//div[@id='loading']//img")).isDisplayed();
	System.out.println(isImagedisplayed);
	assertTrue(isImagedisplayed, "Image is not displayed");
	
}

@SuppressWarnings({ "unchecked", "rawtypes" })
@Test

public void FluentWaitMethod()
{
	driver.findElement(By.linkText("JQuery Download Progress bars")).click();
	driver.findElement(By.id("downloadButton")).click();
	
	Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
	
	WebElement element = wait.until(new Function<WebDriver, WebElement>()
			{
	
		public WebElement apply(WebDriver driver)
		{
			WebElement progress = driver.findElement(By.xpath("//*[@id='dialog']/div[1]"));
			String progressbartext = progress.getText();
			if (progressbartext.equals("Complete!")) 
			{
				System.out.println("Progress is complete");
				return progress;
			}
			else
			{
				System.out.println(progress.getText());
				return null;
			}
		}
	});
}
}



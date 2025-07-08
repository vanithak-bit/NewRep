package NewDemoTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
	
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
	public void scrollandpagetitle() throws InterruptedException
	{
	
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //to scroll down to the bottom
      //  js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Thread.sleep(1000);

       //get page title
        String pageTitle = (String) js.executeScript("return document.title;");
        System.out.println("Page Title: " + pageTitle);
        
        //scroll up
        js.executeScript("window.scrollBy(0, 0)");
        
        driver.findElement(By.linkText("Javascript Alerts")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/section[3]/div/div/div/div[1]/p/button")).click();
        
        Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
        System.out.println("Alert Text: " + alertText);
        
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.alert = function() {};");
       // js.executeScript("window.confirm = function() { return false; };");
        
        //accept an alert
        //driver.switchTo().alert().accept();
        
        //dismiss an alert
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);

        driver.quit();
	}
}

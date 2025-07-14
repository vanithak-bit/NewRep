package NewDemoTestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

       

       //get page title
        String pageTitle = (String) js.executeScript("return document.title;");
        System.out.println("Page Title: " + pageTitle);
            
        //scroll up
        js.executeScript("window.scrollBy(0, 0)");
        
        driver.findElement(By.xpath("//a[normalize-space()='Javascript Alerts']")).click();
       
        
       //We can use either of these xpath selectors to determine the dynamic path 
       // driver.findElement(By.xpath("//button[text()='Click Me']")).click();
      driver.findElement(By.xpath("//button[@class='btn btn-dark my-30 mx-10 hover:bg-lambda-900 hover:border-lambda-900']")).click();
        
        Alert alert = driver.switchTo().alert();        
       //String alerttitle = (String) js.executeScript("return document.title");
      // System.out.println("Alert Title: " + alerttitle);
       
       
		String alertText = alert.getText();
		String ExpText = "I am an alert box!";
        System.out.println("Alert Text: " + alertText);
        Assert.assertEquals(alertText,ExpText,"The alert text is not matching ");
        
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.alert = function() {};");
       // js.executeScript("window.confirm = function() { return false; };");
        
        //accept an alert
        //driver.switchTo().alert().accept();
        
        //dismiss an alert
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        
        //to scroll down to the bottom
          js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
          Thread.sleep(1000);

        driver.quit();
	}
}

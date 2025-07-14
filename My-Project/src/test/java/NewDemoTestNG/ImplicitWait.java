package NewDemoTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWait {
	
WebDriver driver;
	
@BeforeMethod
public void SetUp() {
	System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();

}


@Test
public void testImplicitWait()
{
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://the-internet.herokuapp.com/dynamic_loading");
	driver.findElement(By.xpath("//div[@id='content']/div/a[2]")).click();
	driver.findElement(By.xpath("//div[@id='start']/button")).click();
	WebElement myDynamicElement = driver.findElement(By.xpath("//div[@id='finish']"));
	Assert.assertEquals(myDynamicElement.getText(), "Hello World!", "Message is not Hello world");
	System.out.println("Hi, fetch from GitHub");
}


@AfterMethod
public void finish() {
	driver.quit();

}


}

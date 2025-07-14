package NewDemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		
		String pwh = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Javascript Alerts")).click();
		Thread.sleep(1000);
		
        driver.switchTo().window(pwh);
        Thread.sleep(1000);
   
        driver.quit();
	}

}

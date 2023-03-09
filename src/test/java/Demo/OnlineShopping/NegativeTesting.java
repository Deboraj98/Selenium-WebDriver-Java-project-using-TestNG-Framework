package Demo.OnlineShopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeTesting {
	 public static WebDriver driver = null; 
	 @BeforeTest
	  public void launchBrowser() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  
	  }
	 @Parameters({"URL"})
	 @Test
	  public void invalidLoginCredentials(String url) throws InterruptedException {
		  driver.get(url);
		  driver.findElement(By.linkText("Sign In")).click();
		  driver.findElement(By.id("email")).sendKeys("chowdhury.deboraj98@gmail.com");
		  driver.findElement(By.id("pass")).sendKeys("01943780906");
		  driver.findElement(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")).click();
		  String text = driver.findElement(By.xpath("//div[contains(text(),'Incorrect CAPTCHA')]")).getText();
		  Thread.sleep(5000);
		  Assert.assertEquals("Incorrect CAPTCHA",text);
		  }
     @AfterTest
	 public void closeBrowser() { 
	 driver.close(); 
	 }

}

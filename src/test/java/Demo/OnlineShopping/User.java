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

public class User {
  public static WebDriver driver; 
 
  @BeforeTest
  public void launchBrowser() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
  }
  
	
      @Parameters({"URL"})
	  @Test(priority=1)
	  
	  public void launchApplication(String url) {
	  driver.get(url); 
	  //Boolean title = driver.findElement(By.xpath("//header/div[2]/a[1]/img[1]")).isDisplayed();
	  //System.out.println(driver.getTitle()); 
	  Assert.assertEquals("Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites"
	  ,driver.getTitle()); }
      
      @Parameters({"URL"})
	  @Test(priority=2) 
      public void verifyElements(String url) {
	  driver.get(url);
	  Assert.assertEquals(true,
	  driver.findElement(By.linkText("Sign In")).isDisplayed());
	  Assert.assertEquals(true,
	  driver.findElement(By.linkText("Create an Account")).isDisplayed()); }
	  
      @Parameters({"URL"})
	  @Test(priority=3) public void customerRegistrarion(String url) {
	  driver.get(url);
	  driver.findElement(By.linkText("Create an Account")).click();
	  driver.findElement(By.id("firstname")).sendKeys("Deboraj");
	  driver.findElement(By.id("lastname")).sendKeys("Chowdhury");
	  driver.findElement(By.id("email_address")).sendKeys("deboraj.chy98@gmail.com"
	  ); driver.findElement(By.id("password")).sendKeys("7Nw7RQqjaZTLFZp");
	  driver.findElement(By.id("password-confirmation")).sendKeys("7Nw7RQqjaZTLFZp"
	  ); driver.findElement(By.xpath(
	  "//body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]/span[1]"
	  )).submit();
	  
	  }
      @Parameters({"URL"})
	  @Test(priority=4) 
	  public void validLoginCredentials(String url) throws
	  InterruptedException {
	  driver.get(url);
	  driver.findElement(By.linkText("Sign In")).click();
	  driver.findElement(By.id("email")).sendKeys("deboraj.chy98@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("7Nw7RQqjaZTLFZp");
	  driver.findElement(By.xpath(
	  "//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]"
	  )).submit(); Thread.sleep(5000); String text =
	  driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[1]/span[1]")).
	  getText(); Assert.assertEquals("Welcome, Deboraj Chowdhury!",text); }
	 
 
  
     @AfterTest
	 public void closeBrowser() { 
	 driver.close(); 
	 }
}

package pckg1;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class scenarios {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
  @Test(priority=2)
  public void testLogin(String u, String p) {
	  driver.findElement(By.name("userName")).sendKeys(u);
	  driver.findElement(By.name("password")).sendKeys(p);
	  driver.findElement(By.name("Login")).click();
	  driver.findElement(By.linkText("SignOut")).click();
  }
	  //System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");
	//  driver = new ChromeDriver();
	 // driver.get("http://10.232.237.143:443/TestMeApp");
	  //driver.manage().window().maximize();
	  
	  @Test(priority=1)
	  public void testRegistration() throws InterruptedException {
	  driver.findElement(By.linkText("SignUp")).click();
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("demo");
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("demof");  
	  driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("demol");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demol23");
	  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("demol23");
	  driver.findElement(By.xpath("//span[text()='Female']")).click();
	  driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("demo@gmail.com");
	  driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("987654321");
	  driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("07/17/2019");
	  driver.findElement(By.xpath("//input[@name='address']")).sendKeys("chandanagar,Hyderabad");
	  driver.findElement(By.xpath("//textarea[@name='answer']")).sendKeys("Hyderabad");
	  driver.findElement(By.xpath("//textarea[@name='Submit']")).click();
	  Thread.sleep(5000);
	// String disp1=driver.findElement(By.xpath("//input[@value='Register']"));
	  String E_Title="Available";
			String A_Title=driver.findElement(By.xpath("//span[text()='Available']")).getText();
			Assert.assertEquals(E_Title,A_Title);
			 driver.findElement(By.xpath("//input[@value='Register']")).click();
			 String disp1=driver.findElement(By.xpath("//div[@id='errormsg']")).getText();
			 String disp2="User Registered Successfully!!!Please Login";
			 Thread.sleep(5000);
			 Assert.assertEquals(disp2,disp1);
  }
  @Test(priority=3)
  public void testcart() {
	  driver.findElement(By.xpath("//span[text()='All Categories']")).click();
	  driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span]")).click();
	  driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a")).click();
	  driver.findElement(By.xpath("//a[text()='Add to cart]'")).click();
  }

}

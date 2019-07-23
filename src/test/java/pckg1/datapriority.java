package pckg1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class datapriority {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String u, String p) {
	  System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  //driver.manage().window().maximize();
	  driver.findElement(By.linkText("SignIn")).click();
	  System.out.println("code for login for"+u);
	  driver.findElement(By.name("userName")).sendKeys(u);
	  driver.findElement(By.name("password")).sendKeys(p);
	  driver.findElement(By.name("Login")).click();
	  driver.findElement(By.linkText("SignOut")).click();
	 //driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
	 driver.close();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "asdfgh", "asdfgh" },
      new Object[] { "asdfgh", "asdfgh" },
     
    };
  }
}

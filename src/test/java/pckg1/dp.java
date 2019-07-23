package pckg1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class dp {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String u, String p) {
	  System.out.println("code for login for"+u);
	  driver.findElement(By.name("userName")).sendKeys(u);
	  driver.findElement(By.name("password")).sendKeys(p);
	  driver.findElement(By.name("Login")).click();
	 String e_title="Home";
	 String a_title=driver.getTitle();
	 if(e_title.equals(a_title))
	 {
	  System.out.println("testcase is passed");
  }
	 else
	 {
		 System.out.println("testcase is failed");
	 }
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}

package pckg1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class annotations {
  @Test
  public void f() {
	  System.out.println("this is test");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("this is test 1");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("this is test 2");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("this is test 3");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("this is test 4");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("this is test 5");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("this is test 6");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("this is test 7");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("this is test 8");
  }

}

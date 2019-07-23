package pckg1;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.mongodb.MapReduceCommand.OutputType;

import junit.framework.Assert;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;


public class extentreports1 {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	
	ExtentReports extent;
	ExtentTest test;
  @Test
  public void login(String u,String p){
	  test =  extent.createTest("TC_01","Title");
	  System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  //String E_Title="Home";
		// String A_Title=driver.getTitle();
		// Assert.assertEquals(E_Title,A_Title);
	  driver.findElement(By.xpath("a[contains(text(),'SignIn')]")).click();
	  driver.findElement(By.name("userName")).sendKeys(u);
	  driver.findElement(By.name("password")).sendKeys(p);
	  driver.findElement(By.name("Login")).click();
	  String E_Title="Home";
		String A_Title=driver.getTitle();
		Assert.assertEquals(E_Title,A_Title);
		driver.close();

  }
  @DataProvider
  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "asdfgh", "asdfgh" },
	      new Object[] { "asdfgh", "asdfgh" },
	    };
  }
  @AfterMethod
  public void getResult(ITestResult result) throws IOException {
	  if(result.getStatus() == ITestResult.FAILURE) {
		  test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
	TakesScreenshot snapshot = (TakesScreenshot)driver;
	File src = snapshot.getScreenshotAs(OutputType.FILE);
	String Path = System.getProperty("user.dir")+"/test-output1/screens/"+result.getName()+".png";
	FileUtils.copyFile(src, new File(Path));
	test.addScreenCaptureFromPath(Path,result.getName());
	test.fail(result.getThrowable());
	  }
	  else if(result.getStatus()==ITestResult.SUCCESS) {
		  test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
	  }
	  else  {
		  test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
		  test.skip(result.getThrowable());
	  }
	  
  }
  //@Parameters({"OS","browser"})
  @BeforeTest
  //public void startReport(String OS,String browser)
  public void startReport()
  {
	  htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test.output1/testReport.html");
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	 // extent.setSystemInfo("OS",OS);
	 // extent.setSystemInfo("Browser",browser);
	 // htmlReporter.config().setChartVisibilityOnOpen(true);
	  htmlReporter.config().setDocumentTitle("Extent Report Demo");
	  htmlReporter.config().setReportName("Test Report");
	//  htmlReporter.config().setTestViewChartLocation("ChartLocation.Top");
	  htmlReporter.config().setTheme(Theme.STANDARD);
	  htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a'('zzz')'");
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}

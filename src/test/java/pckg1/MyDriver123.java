package pckg1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver123 {

	public static  WebDriver getDriver (String browser) {
		// TODO Auto-generated method stub
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");
			return new ChromeDriver();
		}
		else return null;

	}

}

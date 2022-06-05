package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetBanking.utilities.ReadConfig;



	public class BaseLayerTest {

		ReadConfig rc = new ReadConfig();
		String url = rc.getUrl();
		String uname = rc.getUname();
		String pwd = rc.getPwd();
		String browser = rc.getBrowser();
		

		 public static WebDriver driver;
 
	@BeforeClass
 	public void setUp() {
		if (browser.equals("chrome")) {
			System.setProperty ("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
			
			driver = new ChromeDriver();
		} else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver= new FirefoxDriver();
		}
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get(url);
	}
 
	@AfterClass
	 public void tearDown() {
		 driver.quit();
 	}
	
	public void takesScreenshot (WebDriver driver, String nameOfTestCase) throws IOException {
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir") +"/Screenshots/" + nameOfTestCase + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
}

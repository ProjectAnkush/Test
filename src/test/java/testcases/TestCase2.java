package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.HomePage;
import pageobject.Search_Hitachi;

public class TestCase2 {   // Negative Test Case
	
	WebDriver driver;
	

	@BeforeTest
	@Parameters({"url", "browser"})
	public void beforeTest(String url, String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	@Test
	@Parameters({"input2"})
	public void VerifyHomePage(String input2) throws InterruptedException {
		HomePage hp= new HomePage(driver);
		hp.verifyLogo();
		hp.verifyResultNegative();
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
	


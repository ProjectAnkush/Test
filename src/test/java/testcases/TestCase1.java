package testcases;

import javax.naming.directory.SearchResult;

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

public class TestCase1 {  //Positive Test Case
	
	
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
	@Parameters({"input"})
	public void VerifyHomePage(String input) throws InterruptedException {
		HomePage hp= new HomePage(driver);
		hp.verifyLogo();
		hp.searchButtonn();
		hp.verifyResultPositive(input);
		Search_Hitachi sr = new Search_Hitachi(driver);
		sr.verifyResultPage();
		sr.clickOnFirstResult();
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}

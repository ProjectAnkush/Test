package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	private By logo = By.xpath("(//a[@class='hitachi-solutions-logo'])[1]");
	private By search = By.xpath(" //a[@id='open-global-search']");
	private By searchBox = By.xpath("//input[@id='site-search-keyword']");
	private By clickOnSearch= By.xpath("//i[@class='gsearch icon icon-search']");


	public void verifyLogo() {
		Boolean status = driver.findElement(logo).isDisplayed();
		String logoText= driver.findElement(logo).getAttribute("class");
		Assert.assertTrue(status);
		System.out.println("The logo is present - "+ status + logoText);		

	}

	public  void searchButtonn() throws InterruptedException {
		WebElement searchbutt= driver.findElement(search);
		searchbutt.click();
		Thread.sleep(2000);
		
}
	public void verifyResultPositive(String input) throws InterruptedException {
		WebElement searchboxx= driver.findElement(searchBox);
		searchboxx.sendKeys(input);
		driver.findElement(clickOnSearch).click();
		Thread.sleep(2000);
	}
	public void verifyResultNegative() throws InterruptedException {
		Boolean status2 = driver.findElement(searchBox).isDisplayed();
		Assert.assertFalse(status2);
		System.out.println("After entering special character in search box Result is not found");
		Thread.sleep(2000);
		
		
	}
	
}
package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search_Hitachi {
	
WebDriver driver;
	
	public Search_Hitachi(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	private By verifyPage= By.xpath("//h4[@class='results']");
	private By clickOnFirst= By.xpath("(//div/p/a)[1]");
	
	public void verifyResultPage() {
		WebElement resultText = driver.findElement(verifyPage);
		String text=resultText.getText();
		System.out.println("Result Page Text- " + text);
	}
	
	public void clickOnFirstResult() {
		WebElement clickonresult= driver.findElement(clickOnFirst);
		clickonresult.click();
	}
	
	

}

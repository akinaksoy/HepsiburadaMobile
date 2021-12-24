package steps;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.lang.Thread;
import java.time.Duration;

public class StepDefinitions {

	
	public void ClickOnWithId(WebDriver driver,String id) throws InterruptedException {
		
		 driver.findElement(By.id(id)).click();
		Thread.sleep(3000);
	}
	
	public void ClickOnWithXpath(WebDriver driver,String xpath) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();;
		Thread.sleep(3000);
	}
	
	public void checkItemText(WebDriver driver,String id, String expectedResult) {
		
		String ActualResult = driver.findElement(By.id(id)).getText();
	
		assertEquals("Item not found.", expectedResult, ActualResult);
	}
	
	public void CompareTexts(WebDriver driver,String ActualResult,String ExpectedResult) {
		assertEquals("location could not be added", ExpectedResult, ActualResult);
	}
	
	public String getTextwithXpath (WebDriver driver,String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	public void isDisplayed(WebDriver driver,String id) throws InterruptedException {
		assertTrue(driver.findElement(By.id(id)).isDisplayed());
		Thread.sleep(2500);
	}
	
	public void scrollPage(AppiumDriver<WebElement> driver,int startX, int startY,int endX,int endY) {
		TouchAction swipe = new TouchAction(driver).press(PointOption.point(startX,startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(endX,endY)).release().perform();
		
		
	}
	
	public void sendKeys(WebDriver driver,String id,String Keys) {
		driver.findElement(By.id(id)).sendKeys(Keys);
	}
	public void sendKeysWithXpath(WebDriver driver,String xpath,String Keys) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).sendKeys(Keys);
		Thread.sleep(2500);
	}
	public void isContains(WebDriver driver,String id,String ExpectedResult) throws InterruptedException {
		Thread.sleep(2500);
		assertTrue(driver.findElement(By.id(id)).getText().contains(ExpectedResult));
	}
	
	
}

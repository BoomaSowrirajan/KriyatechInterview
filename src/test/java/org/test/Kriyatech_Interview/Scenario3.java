package org.test.Kriyatech_Interview;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario3 extends BaseClass{

	@BeforeClass
	private void launchBrowser() {
		chromeBrowserLaunch();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	private void startDate() {
		Date d = new Date();
		System.out.println(d);

	}

	@Test
	private void TestCase1() {
		launchUrl("https://www.channelnewsasia.com/news/international");
		WebElement allSections = driver.findElement(By.xpath("//span[text()='+ All Sections']"));
		clickButton(allSections);
	
	}
	
	@Test
	private void TestCase2() {
		WebElement weather = driver.findElement(By.xpath("(//a[text()='Weather'])[3]"));
		clickButton(weather);
		WebElement maxTemp = driver.findElement(By.xpath("//span[@class='info-today__temp--max']"));
		String maximumTemperature = getText(maxTemp);
		WebElement minTemp = driver.findElement(By.xpath("//span[@class='info-today__temp--min']"));
		String minimumTemperature = getText(minTemp);
		WebElement condition = driver.findElement(By.xpath("//div[@class='info-today__condition']"));
		String weatherCondition = getText(condition);
		System.out.println("The weather of singapore is :" +maximumTemperature +" " +minimumTemperature);
		System.out.println("The Condition of weather is : " +weatherCondition);
	}
	
	@AfterMethod
	private void endDate() {
		Date d = new Date();
		System.out.println(d);
	}
}

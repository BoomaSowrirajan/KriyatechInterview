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
import org.testng.asserts.SoftAssert;

public class Scenario2 extends BaseClass {

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
		WebElement topStories = driver.findElement(By.xpath("(//a[text()='Top Stories'])[2]"));
		actionsMovetoElem(topStories);
		WebElement singapore = driver.findElement(By.xpath("(//a[text()='Singapore'])[3]"));
		javaScriptClick(singapore);
		
		WebElement headlineSingapore = driver
				.findElement(By.xpath("//a[contains(text(),'Check your mouths regularly')]"));
		clickButton(headlineSingapore);
		WebElement title = driver.findElement(By.xpath("//h1[@class='h1 h1--page-title']"));
		boolean contains = getText(title).contains("Check your mouths regularly");
		SoftAssert s = new SoftAssert();
		s.assertEquals(contains, title);
	}

	@AfterMethod
	private void endDate() {
		Date d = new Date();
		System.out.println(d);
	}
}

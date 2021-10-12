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

public class Scenario1 extends BaseClass {

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
		launchUrl("https://www.channelnewsasia.com/");
		WebElement headline = driver
				.findElement(By.xpath("//a[@class='feature-card__heading-link feature-card__heading-link--']"));
		clickButton(headline);
		WebElement title = driver.findElement(By.xpath("//h1[@class='h1 h1--page-title']"));
		boolean contains = getText(title).contains("Travel agents, airlines getting");
		SoftAssert s = new SoftAssert();
		s.assertEquals(contains, title);
	}

	@Test
	private void TestCase2() {
		WebElement relatedNews = driver.findElement(By.xpath("(//div[text()='Related:'])[3]"));
		scrollDown(relatedNews);
		WebElement secondNews = driver.findElement(By.xpath("//span[contains(text(),'Singapore Airlines launches')]"));
		clickButton(secondNews);
	}

	@AfterMethod
	private void endDate() {
		Date d = new Date();
		System.out.println(d);
	}
}

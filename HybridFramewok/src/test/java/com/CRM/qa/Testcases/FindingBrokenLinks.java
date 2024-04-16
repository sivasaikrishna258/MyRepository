package com.CRM.qa.Testcases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindingBrokenLinks {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://freecrm.com/");
//		driver.findElement(By.cssSelector("a[href*='ui'")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void login() {
		driver.findElement(By.name("email")).sendKeys("sivasaikrishna258@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Sivasai@123");
		driver.findElement(By.xpath("//div[contains(@class,'ui fluid large blue submit button')]")).click();
		List<WebElement> l= driver.findElements(By.tagName("a"));
		for(WebElement link:l) {
			String url=link.getAttribute("href");
			verify(url);
		}
		 
	}
	
	/**
	 * this method will check the broken links using @param url
	 */
private void verify(String url)  {
	URL link;
	try {
		link = new URL(url);
	
	HttpURLConnection h=(HttpURLConnection)link.openConnection();
	h.setConnectTimeout(3000);
	h.connect();
	if(h.getResponseCode()>=400) {
		System.out.println(url+""+h.getResponseMessage());
	}
}catch (Exception e) {
	// TODO Auto-genera"ted catch block
	System.out.println(url+"-broken link");
}
		
	}

//	@Test
//	public void login1() {
//		
//		driver.findElement(By.xpath("(//*[contains(text(),'Contacts')]")).click();
//	}
//	@Test
//	public void login2() {
//		
//		driver.findElement(By.xpath("(//*[contains(text(),'Companies')]")).click();
//	}
//	
//Select s=new Select(driver.findElement(By.xpath("(//*[contains(text(),'Companies')]")));


	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
}

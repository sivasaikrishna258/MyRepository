package com.CRM.qa.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.qa.BaseClass.TestBase;

public class UtilClass extends TestBase {

	//static Actions act=new Actions(driver);
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/failedscreenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	
	public static void clickOn(WebDriver driver1, WebElement element, int timeout){
		
			//act.moveToElement(element).perform();;
			new WebDriverWait(driver1,   
			Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));  
		
			element.click();  			
}
}
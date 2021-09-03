package com.qabddautomation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonUtilities {

	
	public WebDriver driver;
	public WebDriverWait webElement; 
	
	
	public CommonUtilities(WebDriver driver)
	{
		this.driver=driver;
	} 

	public static String getScreenShots(WebDriver driver, String FileName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String FileDestination = System.getProperty("user.dir") + "\\FailedBDDTestCases\\" + FileName + ".png";
		File destinationFile = new File(FileDestination);
		FileUtils.copyFile(Source, destinationFile);

		return FileDestination;
	}

	

}

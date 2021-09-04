package com.bddauromation.basstest;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.qabddautomation.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Scenario scenario;

	static Properties properties;
	
	@Before
	public void setup(Scenario sc) {
		scenario = sc;
	}

	
	public static WebDriver initialization() {

		
		String browserName = ConfigReader.initPropertiesFromConfigFile().getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Please mention right driver");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;

	}

	@After
	public void quiteBrowser(Scenario sc) throws IOException {
		
	
		sc.log(sc.getName() + " " + sc.getStatus() + " " + new Date().toString());
		if (sc.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
//			File file= ts.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(file, new File("error.png"));

			byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(bytes, "image/png", "sc_" + new Date().toString());

		}

		System.out.println(sc.getName());
		System.out.println(sc.getStatus());


		driver.quit();
	}

}

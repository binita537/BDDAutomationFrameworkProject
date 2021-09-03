package com.bddautomation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bddautomation.basepage.BasePage;

public class HomePage extends BasePage {

	/**
	 * Constructor of Login Page
	 * 
	 */

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * All login page loacators
	 */

	private By ApplicationLogoLocator = By.xpath("//a[@class='TK-TLRK-Logo']");
	private By TextLocator = By.xpath("//h1[@class='Text--b9 u-mb2 u-fs70']");
	private By LoginLinkLocator = By.xpath("//a[@class='TK-Aside-Menu-Button']");

	/**
	 * Login Page actions
	 */

	public WebElement getApplicationLogoElement() {
		return driver.findElement(ApplicationLogoLocator);

	}

	public WebElement getTextElement() {
		return driver.findElement(TextLocator);

	}

	public WebElement getLoginLinkElement() {
		return driver.findElement(LoginLinkLocator);

	}

	public boolean isApplicationLogoPresent() {
		return waitForElementToBePresent(getApplicationLogoElement()).isDisplayed();

	}

	public String getTextFromWebsite() {
		return waitForElementToBePresent(getTextElement()).getText();

	}

	public String getTitleOfThePage() {
		return driver.getTitle();

	}


	public LoginPage clickLoginLink() {
		waitForElementToBeClickable(getLoginLinkElement()).click();
		return new LoginPage(driver);
	}

}

package com.bddautomation.pages;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.bddautomation.basepage.BasePage;

public class CreateAccount extends BasePage {

	

	HomePage homepage = new HomePage(driver);

	private By email = By.xpath("//input[@id='Email-1']");
	private By firstName = By.xpath("//input[@id='Textbox-1']");
	private By lastName = By.xpath("//input[@id='Textbox-2']");
	private By companyName = By.xpath("//input[@id='Textbox-3']");
	private By countryName = By.xpath("//select[@id='Country-1']");
	private By phoneNumber = By.xpath("//input[@id='Textbox-4']");
	private By createAccountButton = By.xpath("//button[text()='Create account']");

	public CreateAccount(WebDriver driver) {

		super(driver);

	}

	public WebElement getEmailElement() {
		return driver.findElement(email);
	}

	public WebElement getFirstNameElement() {
		return driver.findElement(firstName);
	}

	public WebElement getLastNameElement() {
		return driver.findElement(lastName);
	}

	public WebElement getCompanyNameElement() {
		return driver.findElement(companyName);
	}

	public WebElement getCountryNameElement() {
		return driver.findElement(countryName);
	}

	public WebElement getPhonrNumberElement() {
		return driver.findElement(phoneNumber);
	}

	public WebElement getCreateAccountButtonElement() {
		return driver.findElement(createAccountButton);
	}

	public void createAccountWithDataTable(String EMAIL, String FIRSTNAME, String LASTNAME, String COMPANYNAME,
			String COUNTRYNAME, String PHONENAME) {
		
		waitForElementToBePresent(getEmailElement()).sendKeys(EMAIL);
		waitForElementToBePresent(getFirstNameElement()).sendKeys(FIRSTNAME);
		waitForElementToBePresent( getLastNameElement()).sendKeys(LASTNAME);
		waitForElementToBePresent(getCompanyNameElement()).sendKeys(COMPANYNAME);
		waitForElementToBePresent(getCountryNameElement()).sendKeys(COUNTRYNAME);
		waitForElementToBePresent(getPhonrNumberElement()).sendKeys(PHONENAME);
	   

	}

	public void clickOnCreateAccountSubmitButton() {
		clickByJavaScript(getCreateAccountButtonElement());

	}

}

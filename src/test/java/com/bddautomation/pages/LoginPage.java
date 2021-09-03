package com.bddautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bddautomation.basepage.BasePage;


public class LoginPage  extends BasePage {

	/**
	 * Every class will having its private webdriver object
	 */
	


	/**
	 * All login page loacators
	 */

	private By emailIdLocator = By.xpath("//input[@id='username']");
	private By passwordLocator = By.xpath("//input[@id='password']");
	private By signInButtonLocator = By.xpath("//button[text()='Log in']");
	private By nickNameLocator = By.xpath("//div[@class='u-fl']//h3[@class='e2e-nickname u-wbba']");
	private By apunKaPhotoLocator = By.xpath("//a[@class='home-avatar u-fr']");
	private By createAccountLinkLocator = By.xpath("//a[contains(text(),'Create an account for free')]");
	/**
	 * Constructor of Login Page
	 * 
	 */

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Login Page actions
	 */

	public String getLoginPageHeader() {
		return driver.getTitle();
	}
	
	public WebElement getEmailIdElement()
	{
		return driver.findElement(emailIdLocator);
	}
	
	public WebElement getPasswordElement()
	{
		return driver.findElement(passwordLocator);
	}
	public WebElement getSigneInButtonElement()
	{
		return driver.findElement(signInButtonLocator);
	}
	public WebElement getNickNameElement()
	{
		return driver.findElement(nickNameLocator);
	}
	public WebElement getProfilePhotoElement()
	{
		return driver.findElement(apunKaPhotoLocator);
	}
	public WebElement getCreateAccountElement()
	{
		return driver.findElement(createAccountLinkLocator);
	}

	

	public void enterUsername(String username) {
		waitForElementToBePresent(getEmailIdElement()).sendKeys(username);
		
	}

	public void enterPassword(String pwd) {
		waitForElementToBePresent(getPasswordElement()).sendKeys(pwd);
	}

	public void clickOnSigninButton() {
		clickByJavaScript(getSigneInButtonElement());
	}

	public String getNickNameOnHomePage() {
		return waitForElementToBePresent(getNickNameElement()).getText();
	}
	
	public void clickOnCreateAccountLink() {
		clickByJavaScript(getCreateAccountElement());
		
	}

}

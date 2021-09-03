package com.bddautomation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.bddautomation.basepage.BasePage;


public class AccountPage extends BasePage {

	private WebDriver driver;

	private By productAndSubscriptionLink = By
			.xpath("//ul[@class='TK-Context-Menu TK-Menu']//li[@class='TK-Menu-Item'][2]");
	private By manageLicensedUsersLink = By.xpath("//a[contains(text(),'Manage licensed users')]");

	private By nickName = By.xpath("//div[@class='u-fl']//h3[@class='e2e-nickname u-wbba']");

	private By apunKaPhoto = By.xpath("//a[@class='home-avatar u-fr']");

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getProductAndSubscriptionLinkElement() {
		return driver.findElement(productAndSubscriptionLink);
	}

	public WebElement getManageLicensedUsersLinkElement() {
		return driver.findElement(manageLicensedUsersLink);
	}

	public WebElement getNickNameElement() {
		return driver.findElement(nickName);
	}

	public WebElement getProfilePhoto() {
		return driver.findElement(apunKaPhoto);
	}

	public void clickOnproductAndSubscriptionLink() {

		Actions action = new Actions(driver);
		action.moveToElement(waitForElementToBePresent(getProductAndSubscriptionLinkElement())).build().perform();
		waitForElementToBeClickable(getManageLicensedUsersLinkElement()).click();

	}

	public String getNickNameOnHomePage() {
		return waitForElementToBePresent(getNickNameElement()).getText();
	}

}

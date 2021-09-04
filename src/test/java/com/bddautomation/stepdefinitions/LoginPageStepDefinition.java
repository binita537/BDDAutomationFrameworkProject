package com.bddautomation.stepdefinitions;

import java.util.List;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bddauromation.basstest.BaseTest;
import com.bddautomation.pages.HomePage;
import com.bddautomation.pages.LoginPage;

import com.qabddautomation.utilities.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageStepDefinition {

	WebDriver driver = BaseTest.initialization();

	LoginPage loginPage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);

	@Given("the user is logged in application")
	public void the_user_is_logged_in_application(DataTable dataTable) throws InterruptedException {

		driver.get(ConfigReader.initPropertiesFromConfigFile().getProperty("url"));

		loginPage=homepage.clickLoginLink();	

		List<Map<String, String>> Credentails = dataTable.asMaps(String.class, String.class);
		System.out.println(Credentails);

		Thread.sleep(2000);
		loginPage.enterUsername(Credentails.get(0).get("username"));
		loginPage.enterPassword(Credentails.get(0).get("password"));
		loginPage.clickOnSigninButton();

	}

	@Then("user nickname should be present")
	public void user_nickname_should_be_present() {
		String name=loginPage.getNickNameOnHomePage();
		Assert.fail();
		
	}

}

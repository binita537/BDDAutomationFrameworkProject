package com.bddautomation.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bddauromation.basstest.BaseTest;
import com.bddautomation.pages.HomePage;
import com.qabddautomation.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinitions {

	public WebDriver driver=BaseTest.initialization();
	
	String ApplicationUrl;
	HomePage homepage = new HomePage(driver);

	@Given("user have the url of the application")
	public void user_have_the_url_of_the_application() {

		
		ApplicationUrl = ConfigReader.initPropertiesFromConfigFile().getProperty("url");
	}

	@Given("delete all the cookies and maximize the window")
	public void delete_all_the_cookies_and_maximize_the_window() {

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@When("user on landed on the homepage")
	public void user_on_landed_on_the_homepage() {

		driver.get(ApplicationUrl);
	
	}

	@Then("Application logo should be displyed")
	public void application_logo_is() {
		System.out.println(homepage.isApplicationLogoPresent());
		Assert.assertTrue(homepage.isApplicationLogoPresent());
	}

	@Then("text is equal  {string} should be present")
	public void banner_text_is_equal_should_be_present(String text) {
		System.out.println(homepage.getTextFromWebsite());
		Assert.assertEquals(text, homepage.getTextFromWebsite());
	}

	@Then("title is equal  {string} should be present")
	public void title_is_equal_should_be_present(String title) {
		System.out.println(homepage.getTitleOfThePage());
		Assert.assertEquals(title, homepage.getTitleOfThePage());

	}

}

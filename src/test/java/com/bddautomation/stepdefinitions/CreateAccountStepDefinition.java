package com.bddautomation.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.bddauromation.basstest.BaseTest;
import com.bddautomation.pages.CreateAccount;
import com.bddautomation.pages.HomePage;
import com.bddautomation.pages.LoginPage;
import com.qabddautomation.utilities.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountStepDefinition {

	
	
	WebDriver driver=BaseTest.initialization();
	HomePage homepage=new HomePage(driver);
	CreateAccount createaccount = new CreateAccount(driver);
	LoginPage loginpage;

	@Given("User should be on Create account page")
	public void user_should_be_on_create_account_page() throws InterruptedException {

		driver.get(ConfigReader.initPropertiesFromConfigFile().getProperty("url"));
		loginpage=homepage.clickLoginLink();	
		
		Thread.sleep(7000);

		loginpage.clickOnCreateAccountLink();
		
		

	}

	@When("User enter the data to create account")
	public void user_enter_the_data_to_create_account(DataTable dataTable) throws InterruptedException {

		List<Map<String,String>> CreateAccountData=dataTable.asMaps(String.class,String.class);
		System.out.println(CreateAccountData);
		createaccount.createAccountWithDataTable(CreateAccountData.get(0).get("Email"),
				                                 CreateAccountData.get(0).get("Firstname"),
				                                 CreateAccountData.get(0).get("Lastname"),
				                                 CreateAccountData.get(0).get("Company"),
				                                 CreateAccountData.get(0).get("Country"),
				                                 CreateAccountData.get(0).get("Phone"));
		/*
		 * |Email|Firstname|Lastname|Company|Country|Phone|
		 * |abcd@gmail.com|test|test|mycompant|India |1234567890|
		 */
		
		Thread.sleep(10000);
	}

	@When("User click on Create account button")
	public void user_click_on_create_account_button() throws InterruptedException {
		Thread.sleep(10000);
		
		
		createaccount.clickOnCreateAccountSubmitButton();

	}

	@Then("User should landed on create account page")
	public void user_should_landed_on_create_account_page() {
		
		System.out.println("Account created successfully.");

	}

}

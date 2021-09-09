package com.bddautomation.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/Features/HomePage2.feature" }, 
                 glue = { "com.bddautomation.stepdefinitions","com.bddauromation.basstest" }, 
                 monochrome = true,
                 publish = true,
                 plugin = { "pretty",
                		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

@RunWith(Cucumber.class)
public class TestRunner {

}

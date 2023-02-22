package com.cucumber.selenium.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue ="com.cucumber.selenium.stepdefs",
		 tags="@ui", // to tell which tagged feature file to execute
	        plugin = {"pretty", // to generate reports
	            "html:target/html/testreport.html",
	            "json:target/json/file.json",
	            },
	        monochrome = true,
	        publish=true,
	        dryRun=false
		
		)
public class TestRunner {

}

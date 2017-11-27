package com.bh.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "html:target/cucumber-reports", features = "./src/test/resources/features", glue = "com.bh.step_definitions")
// dryRun = false)

public class CuckesRunner {

}

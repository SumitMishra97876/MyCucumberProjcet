package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/feature/Login2.feature","src/test/java/feature/Register.feature"},glue="stepdefs",dryRun=false)

public class TestRunner {
	
	
	
	
	
	  

}

package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/features/LoginAndCreateOpportunity.feature", 
				glue="steps", 
				monochrome= true 
				)
public class RunloginCreateOpportunity extends AbstractTestNGCucumberTests {

}

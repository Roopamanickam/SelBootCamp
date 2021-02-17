package runner;


	import cucumber.api.CucumberOptions;
	import cucumber.api.SnippetType;
	import cucumber.api.testng.AbstractTestNGCucumberTests;
import pages.ParentClass;

	@CucumberOptions(features="src/main/resources/features", 
					glue="pages", 
					monochrome= true
					)

	public class RunLoginReport extends AbstractTestNGCucumberTests {

	}
	


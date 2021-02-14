package runner;


	import cucumber.api.CucumberOptions;
	import cucumber.api.SnippetType;
	import cucumber.api.testng.AbstractTestNGCucumberTests;
import pages.ParentClass;

	@CucumberOptions(features="src/main/resources/features", 
					glue="src/main/java/pages", 
					monochrome= true,
					snippets = SnippetType.CAMELCASE
					)

	public class RunLoginReport extends ParentClass {

	}
	


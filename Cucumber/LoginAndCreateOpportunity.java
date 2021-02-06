package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAndCreateOpportunity {
	
	public ChromeDriver driver;	

	@Given("Lauch the Chrome Browser") 
	public void openChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops =  new  ChromeOptions();
		ops.addArguments("--disable-notifications");
		 driver = new ChromeDriver(ops);
		 driver.manage().window().maximize();
	}
	
	@Given("Load the Application Url")
	public void loadUrl() {
		driver.get("http://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
	}
	
	@Given("Enter username as cypress@testleaf.com")
	public void enterUsername() {
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
	}
	
	@Given("Enter password as Bootcamp@123")
	public void enterPassword() {
		driver.findElementById("password").sendKeys("Bootcamp@123");
	}
	
	@When("Click Login button")
	public void clickLogin() {
		driver.findElementById("Login");
	}
	
	@Then("Landingpage should be displayed")
	public void verifyLandingPage() {
		String pageTitle = driver.getTitle();
		if(pageTitle.contains("Home")) {
			System.out.println("HomePage is displayed");
		}
	}
	
	
}

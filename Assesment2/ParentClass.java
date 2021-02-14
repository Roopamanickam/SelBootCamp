package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentClass extends AbstractTestNGCucumberTests  {
	public static ChromeDriver driver;
	public static WebDriverWait wait;
	
	@BeforeMethod
	public void startApp(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops =  new  ChromeOptions();
		ops.addArguments("--disable-notifications");
		driver = new ChromeDriver(ops);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS); 
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	@AfterMethod
	public void closeBrowser() {
		//driver.close();
	}
}

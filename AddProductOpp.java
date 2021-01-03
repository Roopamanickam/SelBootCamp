import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductOpp {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeopt = new ChromeOptions();
		chromeopt.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		Thread.sleep(3000);
		driver.manage().window().maximize();

		driver.findElementById("username").sendKeys("cypress@testleaf.com");

		driver.findElementById("password").sendKeys("Bootcamp@123");

		driver.findElementById("Login").click();
		Thread.sleep(10000);

		System.out.println("login success");

		// overridden method
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		Thread.sleep(8000);

		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(10000);
		System.out.println("View All clicked ======>");

		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(10000);
		System.out.println("Sales clicked ======>");

		WebElement oppdpdwm = driver.findElementByXPath("//a[@title='Opportunities']");

		JavascriptExecutor jsexec = (JavascriptExecutor) driver;
		jsexec.executeScript("arguments[0].click();", oppdpdwm);
		Thread.sleep(5000);
		System.out.println("Opportunities clicked ======>");
		
		driver.findElementByXPath("//a[@title='Select List View']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='All Opportunities']").click();
		Thread.sleep(5000);
		
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys("SRM Steel");

		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(8000);
		
		WebElement searchResult = driver.findElementByXPath("(//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/th/span/a)[1]");
		searchResult.click();
		
		Thread.sleep(10000);
		
		WebElement prodDd = driver.findElementByXPath("//span[text()='Products']/ancestor::header/following-sibling::div//div[@data-aura-class='forceDeferredDropDownAction']");
		jsexec.executeScript("arguments[0].scrollIntoView();", prodDd);
		prodDd.click();
		Thread.sleep(10000);
		
		driver.close();
	
		
		//driver.findElementByXPath("//li[@class='oneActionsDropDown']").click();
		
			
	}

}

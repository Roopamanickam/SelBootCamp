import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewOpportunity {
	public static void main(String[] args) throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriverManager.chromedriver().setup();

		//to disable notification
		ChromeOptions ops =  new  ChromeOptions();
		ops.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ops);

		driver.get("https://login.salesforce.com");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		driver.findElementById("username").sendKeys("hari.radhakrishnan@testleaf.com");

		driver.findElementById("password").sendKeys("India$123");

		driver.findElementById("Login").click();
		Thread.sleep(5000);

		System.out.println("login success");

		//overridden method
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		Thread.sleep(7000);
		System.out.println("menu clicked ======>");
		//selenium methods
		//driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();




		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(6000);
		System.out.println("View All clicked ======>");

		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(9000);
		System.out.println("Sales clicked ======>");

		WebElement oppdpdwm  = driver.findElementByXPath("//a[@title='Opportunities']");

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", oppdpdwm);
		Thread.sleep(5000);

		driver.findElementByXPath("//a[@title='New']").click();

		Thread.sleep(2000);
		String input ="SRM Steels Opportunity";
		
		WebElement oppName = driver.findElementByXPath("(//input[@class=' input'])[2]");
		oppName.sendKeys("SRM Steels Opportunity");
		Thread.sleep(2000);
		/*
		 * String name = oppName.getAttribute("value");
		 * System.out.println("=========>"+name);
		 */

		driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//button[text()='Today']").click();

		Thread.sleep(1000);


		driver.findElementByXPath("//span[text()='Type']/following::div").click();
		Thread.sleep(3000);

		driver.findElementByXPath("//a[text()='New Customer']").click();
		Thread.sleep(1000);

		driver.findElementByXPath("//span[text()='Lead Source']/following::div").click();
		Thread.sleep(3000);

		driver.findElementByXPath("//a[text()='Partner Referral']").click();
		Thread.sleep(1000);

		driver.findElementByXPath("//span[text()='Amount']/following::input").sendKeys("75000");
		Thread.sleep(1000);

		driver.findElementByXPath("(//span[text()='Stage'])[2]/following::div").click(); 
		Thread.sleep(3000);

		driver.findElementByXPath("//a[text()='Needs Analysis']").click();
		
		driver.findElementByXPath("(//span[text()='Stage'])[2]/following::div").click(); 
		Thread.sleep(3000);

		driver.findElementByXPath("//a[text()='Needs Analysis']").click();
		Thread.sleep(1000);
		
		driver.findElementByXPath("//span[text()='Primary Campaign Source']/following::div").click(); 
		Thread.sleep(3000);

		driver.findElementByXPath("(//div[@class='listContent']//ul/li/a)[1]").click();
		Thread.sleep(1000);
		
		
		  Thread.sleep(1000);
		  driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		 
			Thread.sleep(10000);
			
		WebElement verifyOppName = driver.findElementByXPath("(//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/th/span/a)[1]");
		String vname = verifyOppName.getAttribute("title");
		Thread.sleep(1000);
		
		System.out.println("========"+vname);
		
		
		System.out.println("=========>"+input);
		
		if (input.equals(vname))
		{
			System.out.println("Opportunity Created Succeddfully");
		}
		
		 
	}

}

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditOpportunity {
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
		Thread.sleep(10000);

		System.out.println("login success");


		//overridden method
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		Thread.sleep(10000);
		System.out.println("menu clicked ======>");
		//selenium methods
		//driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();




		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(6000);
		System.out.println("View All clicked ======>");

		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(5000);
		System.out.println("Sales clicked ======>");

		WebElement oppdpdwm  = driver.findElementByXPath("//a[@title='Opportunities']");

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", oppdpdwm);
		Thread.sleep(5000);

		String input ="SRM Steels Opportunity";

		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys("SRM Steels Opportunity");

		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(Keys.ENTER);

		System.out.println("-------"+input);
		Thread.sleep(5000);

		WebElement searchVal = driver.findElementByXPath("(//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/th/span/a)[1]");
		String sval = searchVal.getAttribute("title");
		System.out.println("*****"+sval);

		if (sval.equals(input)) {

			WebElement clkDd = driver.findElementByXPath("(//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/td)[last()]");
			clkDd.click();
			//JavascriptExecutor exe = (JavascriptExecutor)driver;
			//exe.executeScript("arguments[0].click();", clkDd);
			Thread.sleep(5000);
			
			driver.findElementByXPath("//a[@title='Edit']").click(); 
			Thread.sleep(5000);
			
			//driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
			driver.findElementByXPath("//a[@class='datePicker-openIcon display']/parent::div").click();
			
			Thread.sleep(2000);
			
			//TO choose tmrw's date
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 
			 //get current date time with Date() and add a day to it
			 Date rawstartDate = new Date(new Date().getTime() + (24*60*60*1000));
			 
			 // Now format the date
			 String startDate = dateFormat.format(rawstartDate);
			 System.out.println("@@@@@@@@@@@@@  "+startDate);
			 Thread.sleep(1000);
					
				
			 //Enter the start date
			 				
				String dateXPath = "//td[@data-datevalue='"+startDate+"']";
				driver.findElement(By.xpath(dateXPath)).click();
				System.out.println("Start Date selected successfully");
		
				Thread.sleep(1000);
				
				driver.findElementByXPath("//span[text()='Stage']/parent::span/following::div").click();
				
				Thread.sleep(1000);
				WebElement stprp = driver.findElementByXPath("//a[text()='Perception Analysis']");
				stprp.click();
				String pp1 = stprp.getText();
				
				System.out.println("=======>"+pp1);
				
				driver.findElementByXPath("(//span[text()='Delivery/Installation Status']/parent::span/following::div)[1]").click();
				Thread.sleep(1000);
				
				driver.findElementByXPath("//a[@title='In progress']").click();
				Thread.sleep(1000);
				
				driver.findElementByXPath("//textarea[@class=' textarea']").sendKeys("Sales Force Learning");
				Thread.sleep(1000);
				
				driver.findElementByXPath("(//span[text()='Save'])[2]").click();
				
				Thread.sleep(3000);
				
				WebElement gat = driver.findElementByXPath("//span[text()='Perception Analysis']");
				String txt1 = gat.getText();
				System.out.println("----------->"+txt1);
				
				if(pp1.equals(txt1)) {
					System.out.println("Opportunity Edited Successfully");
				}
				
		}

	}

}

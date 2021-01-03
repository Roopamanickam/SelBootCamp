import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.ant.taskdefs.Copy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortOpportunity {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("\"--disable-notifications\"");
		ChromeDriver driver = new ChromeDriver(options);

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

		WebElement tableView = driver
				.findElementByXPath("(//button[@title='Display as Table']/lightning-primitive-icon)[2]");

		tableView.click();

		Thread.sleep(3000);
		
		
		driver.findElementByXPath("//li[@title='Table']").click();

		WebElement closeDate = driver.findElementByXPath("//span[@title='Close Date']");
		String aVal = closeDate.getAttribute("title");
		System.out.println("=================>>>"+aVal);
		Thread.sleep(3000);
		closeDate.click();
		
		List<WebElement> dateList = driver.findElementsByXPath("//table[@data-aura-class=\"uiVirtualDataTable\"]/tbody/tr/td[6]//span[@data-aura-class='uiOutputDate']");
		List<String> Sourcedates =new ArrayList<String>();
		for (WebElement getcloseDate : dateList) {
			 
			Sourcedates.add(getcloseDate.getText());
			
		}
		
		System.out.println("----"+Sourcedates);
		List<String> compDates =new ArrayList<String>();
		compDates.addAll(Sourcedates);
	
		Collections.sort(Sourcedates);
		
		//Collections.reverse(Sourcedates);
		
		if(compDates.equals(Sourcedates)) {
			System.out.println("sorted in Ascending");
		}else
		{
			
		}
		
			

	}
}

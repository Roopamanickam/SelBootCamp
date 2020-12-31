import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOpportunity {
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

		//overridden method
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		Thread.sleep(8000);

		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(10000);
		System.out.println("View All clicked ======>");


		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(10000);
		System.out.println("Sales clicked ======>");

		WebElement oppdpdwm  = driver.findElementByXPath("//a[@title='Opportunities']");
		JavascriptExecutor jsexec = (JavascriptExecutor)driver;
		jsexec.executeScript("arguments[0].click();", oppdpdwm);
		Thread.sleep(5000);
		System.out.println("Opportunities clicked ======>");

		String input ="SRM steel by roopa";

		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys("SRM steel by roopa");

		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(Keys.ENTER);

		System.out.println("-------"+input);
		Thread.sleep(5000);

		/*
		 * WebElement searchVal = driver.
		 * findElementByXPath("(//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/th/span/a)[1]"
		 * ); String sval = searchVal.getAttribute("title");
		 * System.out.println("*****"+sval);
		 */

		//TO find the rowCOUnt Before Deleting record
		WebElement rowcount = driver.findElementByXPath("//div[@class='uiVirtualDataTable indicator']/following-sibling::table/tbody");

		List<WebElement>TotalRowsListbr = rowcount.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsListbr.size());

		int rcountBf = TotalRowsListbr.size();
		System.out.println("Before count --->"+rcountBf);

		if (rcountBf>0) {
			System.out.println("========== We have matching records==============");
			WebElement clkDd = driver.findElementByXPath("(//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/td)[last()]");
			clkDd.click();

			Thread.sleep(5000);

			driver.findElementByXPath("//a[@title='Delete']").click();
			Thread.sleep(5000);

			driver.findElementByXPath("//button[@title='Delete']").click();
			Thread.sleep(10000);

			//TO find the rowCOUnt After Deleting record
			WebElement rowcount1 = driver.findElementByXPath("//div[@class='uiVirtualDataTable indicator']/following-sibling::table/tbody");

			List<WebElement>TotalRowsListAf = rowcount1.findElements(By.tagName("tr"));
			System.out.println("Total number of Rows in the table are : "+ TotalRowsListAf.size());

			int rcountAf = TotalRowsListAf.size();
			System.out.println("After Count:"+rcountAf);
		} else
		{
			System.out.println("NOReords Found");
		}

	}
}

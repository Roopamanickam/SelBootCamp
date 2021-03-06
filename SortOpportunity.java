import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.tools.ant.taskdefs.Copy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mongodb.client.ListCollectionsIterable;

import freemarker.core.ParseException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SortOpportunity 
{

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("\"--disable-notifications\"");
		ChromeDriver driver = new ChromeDriver(options);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {


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

			//5. To Select the Table view
			WebElement tableView = driver
					.findElementByXPath("(//button[@title='Display as Table']/lightning-primitive-icon)[2]");
			tableView.click();
			Thread.sleep(3000);
			driver.findElementByXPath("//li[@title='Table']").click();
			Thread.sleep(3000);


			//6. Sort the Opportunities by Close Date in ascending order

			List<Date> allDates = new ArrayList<Date>();
			String count =driver.findElementByXPath("//span[@class='countSortedByFilteredBy']").getText().replaceAll("\\D","");
			System.out.println(count);
			int totRecordCount = Integer.parseInt(count);
			for (int i=1;i<=totRecordCount; i++)
			{
				WebElement row = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//td[6]//span[@data-aura-class='uiOutputDate'])[" + i + "]");
				jsexec.executeScript("arguments[0].scrollIntoView();", row);
				String allDateStr = row.getText();
				Date alldate = dateFormat.parse(allDateStr);
				allDates.add(alldate);

				if (i == totRecordCount ) {
					count =driver.findElementByXPath("//span[@class='countSortedByFilteredBy']").getText().replaceAll("\\D","");
					System.out.println("---updatedCount"+count);
					totRecordCount = Integer.parseInt(count);

				}
			}
			//	System.out.println("=====UI BEfore Sort======="+allDates);

			//Sorting Date Collection in Ascending
			List<Date> collSortAsc   = new ArrayList<Date>();
			collSortAsc.addAll(allDates);
			Collections.sort(collSortAsc);
			System.out.println("===Collections After Sort - Ascending==== "+collSortAsc);

			//UI Sorting
			WebElement eleNo = driver.findElementByXPath("//span[text()='Close Date']//parent::a");
			jsexec.executeScript("arguments[0].click();", eleNo);
			Thread.sleep(5000);

			//second time clicked to sort in Ascending
			jsexec.executeScript("arguments[0].click();", eleNo);
			System.out.println("second time clicked to sort in Ascending");


			Thread.sleep(3000);


			List<Date> uiSortAsc = new ArrayList<Date>(); 

			for(int i=1;i<=totRecordCount; i++) {
				WebElement uiDateTravel = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td[6]//span[@data-aura-class='uiOutputDate'])["+i+"]");
				jsexec .executeScript("arguments[0].click();", uiDateTravel);

				Thread.sleep(5000);

				String datestr = uiDateTravel.getText();
				Date date = dateFormat.parse(datestr);

				uiSortAsc.add(date);


				if (i == totRecordCount ) {
					count =driver.findElementByXPath("//span[@class='countSortedByFilteredBy']").getText().replaceAll("\\D", "");
					System.out.println("---updatedCount----"+count);
					totRecordCount = Integer.parseInt(count);

				}
			}

			System.out.println(" UI Sort Ascending  : "+uiSortAsc);		

			System.out.println("Dates from UI before UI Sort    : "+allDates);
			System.out.println("");
			System.out.println("");


			if(collSortAsc.equals(uiSortAsc)) { System.out.
				println("UI Ascending Date sort matches with the Collection Ascending sort");
			System.out.println(" UI Sort Ascending  : "+uiSortAsc);
			System.out.println("Collections Sort Ascending  : "+collSortAsc); }else {
				System.out.
				println("UI Ascending Date sort not in match with the Collection Ascending sort"
						); System.out.println(" UI Sort Ascending  : "+uiSortAsc);
						System.out.println("Collections Sort Ascending  : "+collSortAsc); }


		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			driver.close();
		}


	}
}

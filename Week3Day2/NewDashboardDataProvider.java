package Week3Day2;

import static org.testng.Assert.expectThrows;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewDashboardDataProvider extends BaseClass {

	@Test(dataProvider="sendData")
	public void newDBoard(String name, String desc) throws InterruptedException {

		try {

			// 2. Click on toggle menu button from the left corner

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
			// overridden method
			driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
			System.out.println("*****menu clicked*******");
			
			// 3. Click view All 

			WebElement viweAll = driver.findElementByXPath("//button[text()='View All']");
			wait.until(ExpectedConditions.visibilityOf(viweAll));
			viweAll.click();
			System.out.println("******View All clicked******");
			Thread.sleep(2000);

			//4. Click Service Console from App Launcher

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Service Console']")));
			driver.findElementByXPath("//p[text()='Service Console']").click();
			System.out.println("******Service console clicked******");

			//5. Select Home from the DropDown
			WebElement oppdpdwm = driver.
					findElementByXPath("//button[@title='Show Navigation Menu']/lightning-primitive-icon"); 
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", oppdpdwm);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Home']")));
			driver.findElementByXPath("//span[text()='Home']").click();
			Thread.sleep(2000);

			// 6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@data-aura-class='uiOutputText'])[2]")));
			String closedval = driver.findElementByXPath("(//span[@data-aura-class='uiOutputText'])[2]").getText().replaceAll("\\D","");

			System.out.println("**closedval: "+closedval);
			int closedvalint = Integer.parseInt(closedval);

			String openVal = driver.findElementByXPath("(//span[@data-aura-class='uiOutputText'])[3]").getText().replaceAll("\\D","");
			System.out.println("Open Val :" +openVal);

			int openValint = Integer.parseInt(openVal);

			int totVal = closedvalint + openValint;

			if(totVal < 10000 ) {
				System.out.println("===inside if=====");
				driver.findElementByXPath("//button[@title='Edit Goal']").click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-describedby='currencyCode']")));
				WebElement ipval = driver.findElementByXPath("//input[@aria-describedby='currencyCode']");
				ipval.clear();
				ipval.sendKeys("9500");


				driver.findElementByXPath("//span[text()='Save']").click();

			}

			//step : 7. Select Dashboards from DropDown
			Thread.sleep(5000);
			System.out.println("inside step 7");
			WebElement oppdpdwm1 = driver.
					findElementByXPath("//button[@title='Show Navigation Menu']/lightning-primitive-icon"); 
			executor.executeScript("arguments[0].click();", oppdpdwm1);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboards']")));
			driver.findElementByXPath("//span[text()='Dashboards']").click();
			Thread.sleep(2000);

			//step :8 Click on New Dashboard
			driver.findElementByXPath("//div[text()='New Dashboard']").click();
			Thread.sleep(2000);

			//step 9: Enter the Dashboard name as "YourName_Workout"

			driver.switchTo().frame(0);

			//String input ="BeGood";
			System.out.println("========inside Frame============");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dashboardNameInput']")));
			driver.findElementByXPath("//input[@id='dashboardNameInput']").sendKeys(name);

			//step 10:Enter Description as Testing and Click on Create

			driver.findElementByXPath("//input[@id='dashboardDescriptionInput']").sendKeys(desc);

			//step 11:Click on Done
			//Thread.sleep(4000);
			driver.findElementByXPath("//button[text()='Create']").click();
			System.out.println("========Dashboard Created===========");
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			Thread.sleep(4000);
			//WebElement done = driver.findElementByXPath("//button[text()='Done']");
			WebElement doneclk = driver.findElementByXPath("//button[text()='Done']");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Done']")));
			doneclk.click();
			System.out.println("===Done Clicked===");

			//step 12: Verify the Dashboard is Created
			WebElement vfyDb = driver.findElementByXPath("//span[@class='slds-page-header__title slds-truncate']");
			wait.until(ExpectedConditions.visibilityOf(vfyDb));
			String wsheettxt = vfyDb.getText();
			System.out.println("==wsheettxt==="+wsheettxt);

			if( wsheettxt.equals(name)  ) {
				System.out.println("Worksheet Created Successfully ");
			}
			else {
				System.out.println("Worksheet Not Created");
			}

			//Step : 13  ====Click on Subscribe======
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			System.out.println("back to dashboard frame");
			Thread.sleep(5000);
			WebElement subscribe = driver.findElementByXPath("//button[@class='slds-button slds-button_neutral']");
			wait.until(ExpectedConditions.visibilityOf(subscribe));	
			subscribe.click();

			System.out.println("******subscribed*********");

			//Step 14: Click Daily
			driver.switchTo().defaultContent();

			WebElement editsub = driver.findElementByXPath("//h2[text()='Edit Subscription']");
			wait.until(ExpectedConditions.visibilityOf(editsub));

			driver.findElementByXPath("//span[text()='Daily']").click();

			//Step : 15 - Select 10 Am 
			WebElement timedd= driver.findElementByXPath("//select[@id='time']");
			Select dd = new Select(timedd);

			dd.selectByVisibleText("10:00 AM");


			//Step : 16 - Click SAVE 
			//Thread.sleep(2000);
			WebElement saveBtn = driver.findElementByXPath("//span[text()='Save']");
			//WebElement saveBtn = driver.findElementByXPath("//span[text()='Cancel']");
			wait.until(ExpectedConditions.visibilityOf(saveBtn)).click();

			//Step:17 -  Verify "" message displayed or not
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='You started a dashboard subscription.']")));
			WebElement verifyDbmsg = driver.findElementByXPath("//span[text()='You started a dashboard subscription.']");
			boolean msgDisplayed = verifyDbmsg.isDisplayed();
			System.out.println("****"+msgDisplayed);
			if(msgDisplayed == true) {
				System.out.println("You started Dashboard message displayed"); 
			}else
			{
				System.out.println("You started Dashboard msg not dsplayed");
			}

			//Step 18. Close the "YourName_Workout" tab
			Thread.sleep(3000);
			driver.findElementByXPath("//li[@data-aura-class='oneConsoleTabItem']/div[2]").click();

			//19. Click on Private Dashboards

			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//div[@class='sidebarContainer']//li)[3]"))).click();
			System.out.println("=======pd clicked=======");

			//search for the created worksheet
			WebElement searchPd = driver.findElementByXPath("//input[@placeholder='Search private dashboards...']");
			searchPd.sendKeys(name);
			Thread.sleep(3000);
			//String replaceAllPd = driver.findElementByXPath("(//p[@class='slds-text-body--small result-count-label']//span)[1]").getText();
			String replaceAllPd = driver.findElementByXPath("(//p[@class='slds-text-body--small result-count-label']//span)[1]").getText().replaceAll("[^0-9]","");
			System.out.println("===replaceAllPd===************%%%%%%%"+replaceAllPd);
			int replaceAllPdCount = Integer.parseInt(replaceAllPd);
			System.out.println("count of worksheet in PD: "+replaceAllPdCount);

			if(replaceAllPdCount  > 0)
			{

				//20.Verify the newly created Dashboard available

				//i) Find the table WebElement
				WebElement table = driver.findElementByXPath("//table[@role='grid']/tbody");

				//ii) Find the  rows count
				List<WebElement> allrows = table.findElements(By.tagName("tr"));

				//iii) get the row count
				int rowcount = allrows.size();
				System.out.println("====rowcount==="+rowcount);

				// iV) pick first row from the list

				WebElement firstRow = allrows.get(0);

				// v) find the column of the first row
				List<WebElement> allCols = firstRow.findElements(By.tagName("th"));

				//vi) get column size of first row
				int colCount = allCols.size();
				System.out.println("===column size==="+colCount);

				// vii) pick first column from the first row
				WebElement fir_Cell = allCols.get(0);

				//Viii) REad the first cell
				String dashboardName = fir_Cell.getText();
				System.out.println("========"+dashboardName);

				// 20. Verify the newly created Dashboard available	to delete	
				if(dashboardName.equals(name)) 
				{
					System.out.println("Newly created Dashboard available");

					//21. Click on dropdown for the item

					driver.findElementByXPath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']").click();

					//22. Select Delete
					wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Delete']"))).click();

					//23. confirm Delete
					wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//button[@title='Delete']"))).click();
					System.out.println("Delete confirmed");

					//24. Verify the item is not available under Private Dashboard folder
					String deleteMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[@class='emptyMessageTitle']"))).getText();
					if(deleteMsg.contentEquals("No results found"))
					{
						System.out.println("Delete Success..Assignment Done");
					}else {
						System.out.println("Delete is not done and the Actaul message displayed is:" +deleteMsg);
					}


				}else {
					System.out.println("Dashboard Not avialable for delete Action");
				}

			}						
			else
			{
				System.out.println("WorkSheet Not Found");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@DataProvider(name="sendData")
	public String[][] sendData() throws IOException{
		
		String[][] readData = ReadExcel.readData();
		//String[][] data = new String[1][2];
		/*data[0][0] = "DoGood";
		data[0][1] = "Description for DoGooD";*/
		return readData;		
	}


}
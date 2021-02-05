package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class UpdateEditOpportunity  extends ProjectSpecificMethods {
	
	public UpdateEditOpportunity(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public	String sval;
	public UpdateEditOpportunity search(String OppName) throws InterruptedException {
		WebElement opName = driver.findElementByXPath("//input[@name='Opportunity-search-input']");
		EnterData(opName,OppName);
		WebElement oppIdEle = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody/tr)[last()]/th//a");
		oppId = oppIdEle.getAttribute("data-recordid");
		System.out.println("========OPP ID****"+oppId);
		return this;
	}
	
	public UpdateEditOpportunity enter() throws InterruptedException {
			driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			return this;
		}
	
	public UpdateEditOpportunity searchResult(String OppName) throws InterruptedException {
		//WebElement searchVal = driver.findElementByXPath("(//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/th/span/a)[1]");
		WebElement searchVal = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//tr)[2]/th//a");
		sval = searchVal.getAttribute("title");
		System.out.println("*****"+sval);
		if (sval.equals(OppName)){
			oppFound = true;
		}
		return this;
	}
	
	public UpdateEditOpportunity clkDdSearchResult() {
		WebElement clkDd = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td)[last()]");
		clickElement(clkDd);
		return this;
	}
	
	public DeleteOpp clkDdSearchResultForDelete() {
		WebElement clkDdDelete = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody/tr/td)[last()]");
		clickElement(clkDdDelete);
		return new DeleteOpp(driver);
	}
	
	
		public  UpdateEditOpportunity editOpp(String OppName,String Stage, String InstallationStatus) throws InterruptedException {
		if (oppFound) {	

			WebElement editclk = driver.findElementByXPath("//a[@title='Edit']");
			clickElement(editclk);
						
			WebElement clkDate = driver.findElementByXPath("//a[@class='datePicker-openIcon display']/parent::div");
			clickElement(clkDate);
			
			Thread.sleep(2000);
			
			//TO choose tmrw's date as StartDate
			
					//Set DateFormat
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					 
					 //get current date time with Date() and add a day to it
					 Date rawstartDate = new Date(new Date().getTime() + (24*60*60*1000));
					 
					 // Now format the date
					 String startDate = dateFormat.format(rawstartDate);
					 System.out.println("@@@@@@@@@@@@@  "+startDate);
					 						
				
					 //Enter the start date as Tmrw's Date
					 				
						String dateXPath = "//td[@data-datevalue='"+startDate+"']";
						//driver.findElement(By.xpath(dateXPath)).click();
						WebElement strtDateClk = driver.findElement(By.xpath(dateXPath));
						clickElement(strtDateClk);
						System.out.println("Start Date selected successfully");
		
						
				//Click Stage dropDwn
				WebElement stageDd = driver.findElementByXPath("//span[text()='Stage']/parent::span/following::div");
				clickElement(stageDd);
							
				//Click Perception Analysis from Stage dropDwn
				//WebElement stprp = driver.findElementByXPath("//a[text()='Perception Analysis']");
				WebElement stprp = driver.findElementByXPath("//a[text()='"+Stage+"']");
				clickElement(stprp);
				String pp1 = stprp.getText();
				
				System.out.println("=======>"+pp1);
				
				//click Delivery/Installation Status dropdown
				WebElement clkInst = driver.findElementByXPath("(//span[text()='Delivery/Installation Status']/parent::span/following::div)[1]");
				clickElement(clkInst);
								
				//click Inprogress in Delivery/Installation Status dropdown
				//driver.findElementByXPath("//a[@title='In progress']").click();s
				WebElement selInstVal = driver.findElementByXPath("//a[@title='"+InstallationStatus+"']");
				clickElement(selInstVal);
								
				//Enter Description
				driver.findElementByXPath("//textarea[@class=' textarea']").sendKeys("Sales Force Learning");
				Thread.sleep(1000);
				
				//Click Save btn
				WebElement savebtn = driver.findElementByXPath("(//span[text()='Save'])[2]");
				clickElement(savebtn);
				
				Thread.sleep(3000);
				
				//To confirm the edited Opportunity
				WebElement gat = driver.findElementByXPath("//span[text()='Perception Analysis']");
				String txt1 = gat.getText();
				System.out.println("----------->"+txt1);
				
				if(pp1.equals(txt1)) {
					System.out.println("Opportunity Edited Successfully");
				}
				
		}
		return this;
	}
}


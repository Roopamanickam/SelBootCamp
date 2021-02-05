package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethods;

public class Opportunities extends ProjectSpecificMethods{
	public int closedvalint,openValint,totVal;
	
	public Opportunities(ChromeDriver driver) {
		this.driver = driver;	
		}

	public Opportunities clickOpportunity() throws InterruptedException{
		WebElement oppdpdwm  = driver.findElementByXPath("//a[@title='Opportunities']");
		JsExecutor(oppdpdwm);
		Thread.sleep(5000);
		return this;
	}
	
	public UpdateEditOpportunity opportunityForEdit() throws InterruptedException{
		WebElement oppdpdwmEdit  = driver.findElementByXPath("//a[@title='Opportunities']");
		JsExecutor(oppdpdwmEdit);
		Thread.sleep(5000);
		return new UpdateEditOpportunity(driver);
	}
	
	public Opportunities clickNew() throws InterruptedException {
		WebElement clk = driver.findElementByXPath("//a[@title='New']");
		clickElement(clk);
		Thread.sleep(3000);
		return this;
	}
	
	//public String input ="SRM Steels Opportunity";
	public Opportunities enterOppName(String oppname) {
		WebElement inputOpp = driver.findElementByXPath("(//input[@class=' input'])[2]");
		EnterData(inputOpp,oppname);
		return this;
	}
	
	public Opportunities selectDp() {
		/*driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
		driver.findElementByXPath("//button[text()='Today']").click();*/
		WebElement datepicker = driver.findElementByXPath("//a[@class='datePicker-openIcon display']"); 
		clickElement(datepicker);
		return this;
	}
	
	public Opportunities selectToday() {
		WebElement tdy = driver.findElementByXPath("//button[text()='Today']");
		clickElement(tdy);
		return this;
	}
	
	public Opportunities newCustomer() {
		WebElement dd = driver.findElementByXPath("//span[text()='Type']/following::div");
		clickElement(dd);
		WebElement newcus = driver.findElementByXPath("//a[text()='New Customer']");
		clickElement(newcus);
		return this;
	}
	
	public Opportunities partnerReferral() throws InterruptedException {
		WebElement prDd = driver.findElementByXPath("//span[text()='Lead Source']/following::div");
		clickElement(prDd);
		
		WebElement prclk = driver.findElementByXPath("//a[text()='Partner Referral']");
		clickElement(prclk);
		return this;
	}
	
	public Opportunities amount(String amt) throws InterruptedException {
		WebElement amtField = driver.findElementByXPath("//span[text()='Amount']/following::input");
		EnterData(amtField,amt);
		return this;
	}
	
	public Opportunities needAnalysis() {
		WebElement naDd = driver.findElementByXPath("(//span[text()='Stage'])[2]/following::div"); 
		clickElement(naDd);
		WebElement nAclk = driver.findElementByXPath("//a[text()='Needs Analysis']");
		clickElement(nAclk);
		return this;
	}
	
	public Opportunities primaryCampaign() {
		WebElement pCSource = driver.findElementByXPath("//span[text()='Primary Campaign Source']/following::div"); 
		clickElement(pCSource);
		WebElement pCSourceClk = driver.findElementByXPath("(//div[@class='listContent']//ul/li/a)[1]");
		                                                     //div[@class='listContent']//ul/li/a)[1]
		clickElement(pCSourceClk);
		return this;
	}
	
	public Opportunities save() {
		WebElement clk = driver.findElementByXPath("(//span[text()='Save'])[2]");
		clickElement(clk);
		return this;
	}
	
	public Opportunities verifyOpp(String oppname) {
		
		WebElement verifyOppName = driver.findElementByXPath("(//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/th/span/a)[1]");
		String vname = verifyOppName.getAttribute("title");
			
		System.out.println("========"+vname);
			
		System.out.println("=========>"+oppname);
		
		if (oppname.equals(vname))
		{
			System.out.println("Opportunity Created Succeddfully");
		}
		return this;
	}

}

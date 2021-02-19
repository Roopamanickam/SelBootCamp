package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginLandingPage extends ParentClass{
	public String listOfcpyAcName,nameToVerify,OutputRptName;

	@Given("Enter the username (.*)")
	public void enterUsername(String username) {
		driver.findElementById("username").sendKeys(username);
	}
	
	@Given("Enter the password (.*)")
	public void enterPassword(String password) {
		driver.findElementById("password").sendKeys(password);
	}
	
	@When("Click the Login button")
	public void clickLogin() {
		driver.findElementById("Login").click();
	}
	
	@Then("The Landing page should be displayed")
	public void verifyLandingPage() {
		String pageTitle = driver.getTitle();
		if(pageTitle.contains("Home")) {
			System.out.println("HomePage is displayed");
		}
	}
	
	@When("Click Application Launcher")
	public void clickAppLauncher() {
		WebElement menu = driver.findElementByXPath("//div[@class='slds-icon-waffle']");
		menu.click();
	}
	
	@When("Click the View All")
	public void clickViewAll() {
		WebElement viewAll = driver.findElementByXPath("//button[text()='View All']");
		viewAll.click();
	}

	@And("Click services")
	public void clickSalesFromApplaucherPopup() {
		WebElement sales = driver.findElementByXPath("//p[text()='Service']");
		sales.click();
	}
	
	@And("Click Reports")
	public void clickOpportunitiesMenu() {
		WebElement oppdpdwm  = driver.findElementByXPath("//a[@title='Reports']");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", oppdpdwm);
	}
	
	@And("Click New Reports SFClassic")
	public void clkNewReportSFClassic() throws InterruptedException {
		WebElement newRptSfClassic  = driver.findElementByXPath("//div[@title='New Report (Salesforce Classic)']");
		newRptSfClassic.click();
		Thread.sleep(3000);
	}
	
	@And("Click on Leads")
	public void clkLeads() {
		driver.switchTo().frame(0);
		driver.findElementByXPath("(//form[@id='thePage:dummyForm']/table//td[1]//div/ul[@class='x-tree-root-ct x-tree-lines']/div/li)[4]").click();
		System.out.println("Leads clicked");
	}
	
	@Then("Lead Report Image should be displayed")
	public void verifyLeadReport() {
		
		WebElement leadRpt  = driver.findElementByXPath("//form[@id='thePage:dummyForm']/table//td[2]/div[@class='previewBlock']");
	
		System.out.println("inside Leads img display block");
		
				if(leadRpt.isDisplayed()) {
					boolean leadRptVerify = true;
					System.out.println("Lead Report Image is displayed");
				}
	}
	
	@When("Download the LeadReport")
	public void dwnldLeadRpt() throws MalformedURLException, IOException {
		WebElement imgElement = driver.findElementByXPath("//img[@id='thePage:dummyForm:report_img']");
		String src = imgElement.getAttribute("src");
		BufferedImage bufferedImage = ImageIO.read(new URL(src));
		File outputfile = new File("saved.png");
		ImageIO.write(bufferedImage, "png", outputfile);

	}
	
	@And("Click Create button")
	public void clkCreateBtn() throws InterruptedException {
		driver.findElementByXPath(" //input[@value='Create']").click();
		System.out.println("Create button clicked");
		Thread.sleep(4000);
	}
	
	@When("Select Range as All Time")
	public void selectRangeAsAllTime() throws InterruptedException {
	WebElement rangeClk = driver.findElementByXPath("(//table[@class='x-table-layout'])[3]//tr[2]/td[2]//div/form//input[@name='duration']");
	rangeClk.click();
	Thread.sleep(3000);
	driver.findElementByXPath("//div[@class='x-combo-list-inner']/div[text()='All Time']").click();
	System.out.println("All Time clicked");	    
	}
	
	@When("Select From date as todays date")
	public void selectFromDateAsTodaysDate() {
	   driver.findElementByXPath("((//table[@class='x-table-layout'])[3]//tr[2]/td[2]//div/form//img[@class='x-form-trigger x-form-date-trigger'])[1]").click();
	   System.out.println("todays dd clicked");
	    driver.findElementByXPath("//button[text()='Today']").click();
	    System.out.println("todays date clicked");
	}
	
	@When("Select ToDate as PlusFive days From Today")
	public void selectToDateAsPlusDaysFromToday() throws InterruptedException {
	//TO choose tmrw's date as StartDate
		 	
		driver.findElementByXPath("//input[@name='endDate']/following-sibling::img[@class='x-form-trigger x-form-date-trigger']").click();
		System.out.println("==========Date dropdown Clicked=======");
		 	Thread.sleep(3000);
					//Set DateFormat
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					 
					 //get current date time with Date() and add a day to it
					 Date rawstartDate = new Date(new Date().getTime() + (5*24*60*60*1000));
					 
					 // Now format the date
					 String toDate = dateFormat.format(rawstartDate);
					 WebElement toDateWE = driver.findElementByXPath("//input[@name='endDate']");
					 toDateWE.sendKeys(toDate);
					 toDateWE.click();
	}

	@When("verify Preview in Tabular Format")
	public void clickPreviewAsTabularFormat() {
	WebElement tabFormat = driver.findElementByXPath("//table[@id='reportFormatMink']//button");
	String tabFormatTxt = tabFormat.getText();
	System.out.println("==="+tabFormatTxt);
	 	   if(tabFormatTxt.contentEquals("Tabular Format")) {
	 		   System.out.println("Tabular format success");
	 	   }
	}
	
	@When("Get the List of Billing StateProvince")
	public void getTheListOfBillingStateProvince() {
		List<WebElement> elerowCount = driver.findElements(By.xpath("//div[@class='x-grid3-body']/div"));
		int rowCount= elerowCount.size();
				System.out.println("row count*******"+rowCount);
				
				for (int i = 1; i <= rowCount; i++) {
					
					List<WebElement> elecpyActNameLst = driver.findElementsByXPath("(//div[@class='x-grid3-body']/div)["+i+"]//td[5]/div");
					
					List<String> lstActName = new ArrayList<String>();
					for (WebElement ele :elecpyActNameLst) {
						String extAccName = ele.getText();
						lstActName.add(extAccName);						
					}
					
					System.out.println("***"+lstActName.toString());
				}
				
	   
	}

	@When("Get the Grand Total of Records Available")
	public void getTheGrandTotalOfRecordsAvailable() {
	 WebElement grandTotWE = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner'])[1]/b");
	 String grandTot = grandTotWE.getText();
	 System.out.println("***"+grandTot);
	}
	
	@Then("Click on Save")
	public void clkSave() {
		driver.findElementByXPath("//button[text()='Save']").click();
		System.out.println("Save Clicked");
	}

	@Then("Enter Report name as (.*)")
	public void enterReportNameAsYourName(String name) {
		driver.findElementByXPath("//input[@name='reportName']").sendKeys(name);
		nameToVerify=name;
		System.out.println("nameToVerify is:"+nameToVerify);
	}

	@Then("Enter Report Unique name as (.*)")
	public void enterReportUniqueNameAsYourName_anyNumber(String uniqueName) {
		driver.findElementByXPath("//input[@name='reportDevName']").sendKeys(uniqueName);
	}

	@Then("Enter Report Description as Report Updated by (.*)")
	public void enterReportDiscussionAsReportUpdatedByYourName(String desc) {
	   driver.findElementByXPath("//textarea[@name='reportDescription']").sendKeys(desc);
	}

	@Then("Select Report Folder as Unfiled Public Reports")
	public void selectReportFolderAsUnfiledPublicReports() {
	    driver.findElementByXPath("(//img[@class='x-form-trigger x-form-arrow-trigger'])[4]").click();
	    driver.findElementByXPath("//div[text()='Unfiled Public Reports']").click();
	}

	@And("Click Save")
	public void save() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()='Cancel']/preceding::button[text()='Save'][1]").click();
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
	}
	
	@Then("Verify Report has been created successfully as (.*)")
	public void verifyReportCreation(String reportName) {
		WebElement verifyRptIframe = driver.findElementByXPath("//iframe[starts-with(@title,'"+reportName+"')]");
		driver.switchTo().frame(verifyRptIframe);
		WebElement reportTxtWE = driver.findElementByXPath("//h2[@class='pageDescription']");
		String reportTxt = reportTxtWE.getText();
				
		System.out.println("****Created Lead NAme:"+reportTxt);
	if(reportTxt.contentEquals(reportName)) {
		System.out.println("Report has been created successfully");
		}
	driver.switchTo().defaultContent();
	}
	
	@When("Click on Run Report (.*)")
	public void clickRunReport(String reportName) throws InterruptedException {
		WebElement verifyRptIframe = driver.findElementByXPath("//iframe[starts-with(@title,'"+reportName+"')]");
		driver.switchTo().frame(verifyRptIframe);
		driver.findElementByXPath("//title[text()='"+reportName+" ~ Salesforce - Developer Edition']//following::table[@id='runReportBtn']/tbody").click();
	    Thread.sleep(3000);
	    driver.switchTo().defaultContent();
	}

	@When("Get the total Number of Records")
	public void totalNumberOfRecords() {
		WebElement totRecIframe = driver.findElementByXPath("//iframe[@title='Report Viewer']");
		driver.switchTo().frame(totRecIframe);
	    String totRec = driver.findElementByXPath("//div[@class='metricsElement metricsValue']").getText();
	    System.out.println("======"+totRec);
	    
	}

	@And("Click on Edit")
	public void clickEdit() {
	    driver.findElementByXPath("//div[@class='slds-dropdown-trigger slds-dropdown-trigger_click slds-button_last']").click();
	    driver.findElementByXPath("//span[@title='Edit (Salesforce Classic)']").click();
	    driver.switchTo().defaultContent();
	}

	@And("Click on Close (.*)")
	public void clickClose(String reportName ) throws InterruptedException {
		WebElement closeIframe = driver.findElementByXPath("//iframe[starts-with(@title,'"+reportName+"')]");
		driver.switchTo().frame(closeIframe);
		driver.findElementByXPath("//button[text()='Close']").click();
		
		driver.findElementByXPath("//button[text()='Save & Close']").click();
		Thread.sleep(3000);
		

}
	
	@And("Get the text of Report Name")
	public void reportNameTxt() {
		driver.switchTo().defaultContent();
		
		WebElement trow = driver.findElementByXPath("//table[@class='slds-table slds-table_header-fixed slds-table_bordered slds-table_edit slds-table_resizable-cols']/tbody/tr[1]/th//a");
		OutputRptName = trow.getAttribute("title");
		System.out.println("*The saved Report Name:"+OutputRptName);
		
	}

	@And("Verify the Report Name (.*)")
	public void verifyTheReportName(String RptName) {
	   if(OutputRptName.contentEquals(RptName)) {
		   System.out.println(RptName+": Report created sucessfully");
	   }
	}

	@Then("Get the Date and Time When the Report is Created On")
	public void getTheDateAndTimeWhenTheReportIsCreatedOn() {
	    String dateTime = driver.findElementByXPath("//table[@class='slds-table slds-table_header-fixed slds-table_bordered slds-table_edit slds-table_resizable-cols']/tbody/tr[1]/td[@data-label='Created On']").getText();
	    System.out.println("Report Created Date and Time: "+dateTime);
	}
	
	}



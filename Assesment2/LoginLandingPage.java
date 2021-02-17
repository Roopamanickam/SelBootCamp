package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginLandingPage extends ParentClass{

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
		//img[@src=/img/rptleadlist.gif]
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
	/*JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", rangeClk);*/
	System.out.println("All dropdown clicked");
	//rangeClk.click();
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
		 	//driver.findElementByXPath("((//table[@class='x-table-layout'])[3]//tr[2]/td[2]//div/form//img[@class='x-form-trigger x-form-date-trigger'])[2]").click();
		driver.findElementByXPath("//input[@name='endDate']/following-sibling::img[@class='x-form-trigger x-form-date-trigger']").click();
		System.out.println("==========Date dropdown Clicked=======");
		 	Thread.sleep(3000);
					//Set DateFormat
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					 
					 //get current date time with Date() and add a day to it
					 Date rawstartDate = new Date(new Date().getTime() + (5*24*60*60*1000));
					 
					 // Now format the date
					 String toDate = dateFormat.format(rawstartDate);
					 driver.findElementByXPath("//input[@name='endDate']").sendKeys(toDate);
					 
					/* String[] spltDate = toDate.split("/");
					 
					 System.out.println("@@@@@@@@@@@@@  "+toDate);	
					 System.out.println("***"+spltDate[1]);
										 
					 String datXpath="//a[@class='x-date-date']//span[text()='"+toDate+"']";
					 
					 System.out.println("========"+datXpath);
					
					 WebElement strtDateClk = driver.findElement(By.xpath(datXpath));
					 strtDateClk.click();	 */        
				    
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
	
	/*
	@When("Get the List of Billing State\\/Province")
	public void getTheListOfBillingStateProvince() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("Get the Grand Total of Records Available")
	public void getTheGrandTotalOfRecordsAvailable() {
	 
	}

	@Then("Click on Save")
	public void clickOnSave() {
	    
	}
	*/
	
}

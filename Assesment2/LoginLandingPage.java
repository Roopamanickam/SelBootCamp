package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginLandingPage extends ParentClass{

	@Given("Enter username (.*)")
	public void enterUsername(String username) {
		driver.findElementById("username").sendKeys(username);
	}
	
	@Given("Enter password (.*)")
	public void enterPassword(String password) {
		driver.findElementById("password").sendKeys(password);
	}
	
	@When("Click Login button")
	public void clickLogin() {
		driver.findElementById("Login").click();
	}
	
	@Then("Landingpage should be displayed")
	public void verifyLandingPage() {
		String pageTitle = driver.getTitle();
		if(pageTitle.contains("Home")) {
			System.out.println("HomePage is displayed");
		}
	}
	
	@When("Click AppLauncher")
	public void clickAppLauncher() {
		WebElement menu = driver.findElementByXPath("//div[@class='slds-icon-waffle']");
		menu.click();
	}
	
	@When("Click View All")
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
	
	@And("And Click New Reports SFClassic")
	public void clkNewReportSFClassic() {
		WebElement newRptSfClassic  = driver.findElementByXPath("//a[@title='New Report (Salesforce Classic)']");
		newRptSfClassic.click();
	}
	
	@And("Click on Leads")
	public void clkLeads() {
		driver.findElementByXPath("(//span[text()='Leads'])[1]").click();
	}
	
	@Then("Lead Report Image should be displayed")
	public void verifyLeadReport() {
		WebElement leadRpt  = driver.findElementByXPath("//img[@src=/img/rptleadlist.gif]");
		
				if(leadRpt.isDisplayed()) {
					boolean leadRptVerify = true;
					System.out.println("Lead Report Image is displayed");
				}
	}
	
	@When("Download the LeadReport")
	public void dwnldLeadRpt() throws MalformedURLException, IOException {
		WebElement imgElement = driver.findElementByXPath("//img[@src=/img/rptleadlist.gif]");
		String src = imgElement.getAttribute("src");
		BufferedImage bufferedImage = ImageIO.read(new URL(src));
		File outputfile = new File("saved.png");
		ImageIO.write(bufferedImage, "png", outputfile);
		
	}
	
	@And("Click Create button")
	public void clkCreateBtn() {
		driver.findElementByXPath(" //input[@value='Create']").click();
	}
	
	/*@When("Select Range as All Time")
	public void selectRangeAsAllTime() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("Select From date as todays date")
	public void selectFromDateAsTodaysDate() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("Select ToDate as Plus{int} days From Today")
	public void selectToDateAsPlusDaysFromToday(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("Click Preview as Tabular Format")
	public void clickPreviewAsTabularFormat() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

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

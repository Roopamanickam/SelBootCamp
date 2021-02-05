package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;


public class CreateOpportunity extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setFile() {
		excelFileName ="CreateOpportunity";
	}
	
	@Test(dataProvider="fetchData")
	public void newOpportunity(String username, String password, String oppname, String amt) throws InterruptedException  {
		//LoginPage lp = new LoginPage();
						
		new LoginPage(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.appLauncher()
		.viewAll()
		.sales()
		.clickOpportunity()
		.clickNew()
		.enterOppName(oppname)
		.selectDp()
		.selectToday()
		.newCustomer()
		.partnerReferral()
		.amount(amt)
		.needAnalysis()
		.primaryCampaign()
		.save()
		.verifyOpp(oppname);
		
	}

}

package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class DeleteOpportunity extends ProjectSpecificMethods {
	
	@BeforeTest
	public void SetFile() {
		excelFileName ="CreateOpportunity";
	}

	@Test(dataProvider="fetchData" , dependsOnMethods ="testcases.EditOpportunity.editOpportunity")
	public void deleteOpp(String userName, String password, String oppName, String amt ) throws InterruptedException {
		
		new LoginPage(driver)
		.enterUsername(userName)
		.enterPassword(password)
		.clickLoginButton()
		.appLauncher()
		.viewAll()
		.sales()
		.opportunityForEdit()
		.search(oppName)
		.enter()
		.clkDdSearchResultForDelete()
		.clkDeleteOpp()
		.clkOKDelete()
		.confirmDelete(oppName)
		.getID();
		

	}
}

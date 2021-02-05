package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class EditOpportunity extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setFile() {
		excelFileName ="EditOpportunity";
	}
	
	@Test(dataProvider="fetchData" , dependsOnMethods="testcases.CreateOpportunity.newOpportunity")
	public void editOpportunity(String username, String password,String OppName, String Stage, String InstallationStatus  ) throws InterruptedException {
		new LoginPage(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.appLauncher()
		.viewAll()
		.sales()
		.opportunityForEdit()
		.search(OppName)
		.enter()
		.searchResult(OppName)
		.clkDdSearchResult()
		.editOpp(OppName,Stage,InstallationStatus);

	}

}

package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods; 

public class DeleteOpp extends ProjectSpecificMethods {
	//public String oppIdBfreDelete;
	public DeleteOpp(ChromeDriver driver) {
		this.driver = driver;
	}

	public DeleteOpp clkDeleteOpp() {
		/*//get OppID
		WebElement oppIdEle = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody/tr)[last()]/th//a");
		String oppIdBfreDelete = oppIdEle.getAttribute("data-recordid");
		System.out.println("========OPP ID****"+oppIdBfreDelete);*/
				
		WebElement clkDdOpp = driver.findElementByXPath("//a[@title='Delete']");
		clickElement(clkDdOpp);
		return this;
	}

	public DeleteOpp clkOKDelete() {
		WebElement clkOKDel = driver.findElementByXPath("//button[@data-aura-class='uiButton--default uiButton--brand uiButton forceActionButton']");
		clickElement(clkOKDel);	
		return this;
	}

	public DeleteOpp confirmDelete(String oppName) {
		//checking if disappearing message popup is displayed

		System.out.println("========"+oppName);
		WebElement delConfMsg = driver.findElementByXPath("//div[@data-key='success']");
		if(delConfMsg.isDisplayed()) {
			System.out.println("Opportunity Deleted Successfully");
		}
		return this;
	}

	/*public DeleteOpp getID() {
		System.out.println("===***^^^Orginal OppID To verify With*****^^^== "+oppId);		
		WebElement table = driver.findElementByXPath("//table[@data-aura-class='uiVirtualDataTable']");
		List<WebElement> totRows = driver.findElements(By.tagName("tr"));
		int rowCount = totRows.size();
		System.out.println("===Row Count===:"+rowCount);

		for (int i = 0; i < rowCount; i++) {
			WebElement firstRow = totRows.get(i);

			List<WebElement> allCol = firstRow.findElements(By.tagName("th"));
			int colCount = allCol.size();
			WebElement verifyIdWebEle = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']/tbody/tr)["+i+"]/th//a");
			String oppIdToVerify = verifyIdWebEle.getAttribute("data-recordid");
			WebElement oppIdWbEle = allCol.get(0);
			String oppIDchk = oppIdWbEle.getText();

			System.out.println("===OppID "+i+" from Table=="+oppIdToVerify);
			
			if (oppIdToVerify.equals(oppId)) {
				System.out.println("Opportunity Not Deleted Properly");
				break;
			}

		}
		System.out.println("Opportunity  Deleted Successfully");
		return this;
	}*/
}
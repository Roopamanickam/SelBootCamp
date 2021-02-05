package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage extends ProjectSpecificMethods{
	
	public LandingPage(ChromeDriver driver) {
		this.driver = driver;	
		}
	
	public LandingPage viewProfile()  {
	
		driver.findElementByXPath("//span[@class='uiImage']").click();
		return this;
		}
	
	public LandingPage logout() {
		System.out.println("inside Logout ");
		driver.findElementByXPath("//a[text()='Log Out']").click();
		return this;
	  }
	
	public LandingPage appLauncher(){ 
		WebElement menu = driver.findElementByXPath("//div[@class='slds-icon-waffle']");
		clickElement(menu);
		return this;
	}
	
	public LandingPage viewAll(){
		WebElement viewAll = driver.findElementByXPath("//button[text()='View All']");
		clickElement(viewAll);
		return this;
		
	}
	
	public Opportunities sales(){
		WebElement sales = driver.findElementByXPath("//p[text()='Sales']");
		clickElement(sales);
		return new Opportunities(driver);
	}
		
}

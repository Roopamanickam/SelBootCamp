Feature: Salesforce Login And LandingPage functionality

Scenario Outline: Test Login and Create Opportunity positive Scenario
Given Enter the username <LoginName> 
And Enter the password <Password>        
When Click the Login button   
Then The Landing page should be displayed
When Click Application Launcher  
And Click the View All 
And Click services
And Click Reports
And Click New Reports SFClassic 
And Click on Leads
Then Lead Report Image should be displayed
When Download the LeadReport
And Click Create button
And Select Range as All Time
And Select From date as todays date 
And Select ToDate as PlusFive days From Today
#And Click Preview as Tabular Format
#And Get the List of Billing State/Province
#And Get the Grand Total of Records Available
#Then Click on Save 
 
Examples:
|LoginName|Password|
|hari.radhakrishnan@testleaf.com|Newyorkcity@911|

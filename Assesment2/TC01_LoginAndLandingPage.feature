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
#And Select From date as todays date 
And Select ToDate as PlusFive days From Today
And verify Preview in Tabular Format
And Get the List of Billing StateProvince
And Get the Grand Total of Records Available 
Then Click on Save 
And Enter Report name as <ReportName>
And Enter Report Unique name as <ReportUniqueName>  
And Enter Report Description as Report Updated by <Desc>
And Select Report Folder as Unfiled Public Reports
And Click Save  
Then Verify Report has been created successfully as <ReportName>
When Click on Run Report <ReportName>
And Get the total Number of Records
And Click on Edit 
And Click on Close <ReportName>
And Get the text of Report Name 
And Verify the Report Name <ReportName> 
And Get the Date and Time When the Report is Created On
   
 
Examples:
|LoginName|Password|ReportName|ReportUniqueName|Desc|
|hari.radhakrishnan@testleaf.com|Newyorkcity@911|Roopa|Roopa_2555|Roopa Desc|

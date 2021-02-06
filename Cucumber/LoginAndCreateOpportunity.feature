Feature: Salesforce Login functtionality
Scenario: Test Login positive Scenario
Given Lauch the Chrome Browser  
And Load the Application Url   
And Enter username as cypress@testleaf.com        
And Enter password as Bootcamp@123     
When Click Login button  
Then Landingpage should be displayed 
 

Feature: Validation HomePage 

Background: Safely landed on applicateion site 
	Given user have the url of the application 
	And delete all the cookies and maximize the window 
	When user on landed on the homepage 
	
	
Scenario: verify the application Logo 
		Then Application logo should be displyed 
	
	
Scenario: Verify the Modern-UI-Made-Easy text 
	Then text is equal  "Modern UI Made Easy" should be present 
	
Scenario: Verify the title of the page 
	Then title is equal  "Telerik & Kendo UI - .NET Components Suites & JavaScript UI Libraries" should be present 
	
	
	
	
         
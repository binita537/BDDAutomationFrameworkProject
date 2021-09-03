Feature: feature description  

	
Scenario: Create an new account 
        Given  User should be on Create account page 
        When User enter the data to create account 
        
        |Email|Firstname|Lastname|Company|Country|Phone|
        |abcd@gmail.com|test|test|mycompant|India |1234567890|
        
        
        And User click on Create account button
       Then User should landed on create account page    

 
 
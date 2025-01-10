Feature: Validate Bookings in the Restfull Booker API

  Background: 
     Given user should create the relevant object for the Booker call

  Scenario Outline: User should able to create one new record in the booker
     When user create the new record with following <firstname>,<lastname>,<totalprice>,<depositpaid>,and <additionalneeds> values as input
  
    Examples: 
      |firstname |lastname   |totalprice |depositpaid |additionalneeds|
      |Karthi    |Srinivasan |111				 |true				|Breakfast			|		
      
  Scenario: User should able to read all records in the booker
     When user call get method of the booker to read records

	Scenario: User should able to read single record based on the booking_id
     When user call get method to read a record matching the given booking_id "201"
     
  Scenario Outline: User should able to update a record based on the booking_id  
     When user update a record matching the given booking_id "201" with <firstname>,<lastname>,<totalprice>,<depositpaid>,and <additionalneeds>
     Examples: 
      |firstname |lastname   |totalprice |depositpaid |additionalneeds|
      |Karthik   |Srini 		 |101		 		 |false				|Lunch					|		
   
  Scenario: User should able to delete a record based on the booking_id
     When user call delete method to delete a record matching the given booking_id "504"   
  
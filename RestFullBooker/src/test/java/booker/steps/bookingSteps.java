package booker.steps;

import booker.services.BookingService;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;

public class bookingSteps {
	
	BookingService bookingService;
	
	@Given("user should create the relevant object for the Booker call")
	public void user_should_create_the_relevant_object_for_the_booker_call1() {
		bookingService = new BookingService();
	}
	
	@When("/^user create the new record with following (.*),(.*),(.*),(.*),and (.*) values as input$/")
	public void user_create_the_new_record_with_following_karthi_srinivasan_values_as_input(String firstName,String lastName,int totalPrice,
			boolean depositPaid,String additionalNeeds){
		
		bookingService.createBooking(firstName,lastName,totalPrice,depositPaid,additionalNeeds);
		 
	}

	@When("user call get method of the booker to read records")
	public void user_should_call_get_method_of_the_booker_to_fetch_records() {
	    
		bookingService.getBookingIds();
		
	}
	
	@When("user call get method to read a record matching the given booking_id {string}")
	public void user_should_call_get_method_of_the_booker_to_extract_given_bookingId_record(String bookingId) {
	  
		bookingService.getBoookingRecord(bookingId);
		
	}
	
	@When("/^user update a record matching the given booking_id (.*) with (.*),(.*),(.*),(.*),and (.*)$/")
	public void user_update_a_record_matching_the_given_booking_id_with_karthik_srini_false_and_lunch(String bookingId,
			String firstName,String lastName,int totalPrice,boolean depositPaid,String additionalNeeds) {
		
		bookingService.updateRecord(bookingId,firstName,lastName,totalPrice,depositPaid,additionalNeeds);
	    	
	}
	
	@When("user call delete method to delete a record matching the given booking_id {string}")
	public void user_call_delete_method_to_delete_a_record_matching_the_given_booking_id(String bookingId) {
	  
		bookingService.deleteBoookingRecord(bookingId);
	}
	
	
	
}

package booker.services;

import com.matschie.api.design.ResponseAPI;
import com.matschie.api.rest.assured.lib.RestAssuredBaseImpl;
import com.matschie.service.now.pojos.BookingDates;
import com.matschie.service.now.pojos.Payload;

import io.restassured.specification.RequestSpecification;

public class BookingService extends Booker{
	
	private RequestSpecification requestSpecification;
	private ResponseAPI response;
	RestAssuredBaseImpl restAssured = new RestAssuredBaseImpl();
	Payload payload = new Payload();
	
	public void setRequestSpecification(RequestSpecification requestSpecification) {
		
	   this.requestSpecification = requestSpecification;	
	}
	
	public RequestSpecification getRequestSpecification() {
		
		if(requestSpecification!=null) {
			return requestSpecification;
		}else {
			return globalRequestSpec();
		}
	}
	
	
	public void createPayload(String firstName,String lastName,int totalPrice,boolean depositPaid,String additionalNeeds) {
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2018-01-01");
		bookingdates.setCheckout("2019-01-01");
		
		payload.setFirstname(firstName);
		payload.setLastname(lastName);
		payload.setTotalprice(totalPrice);
		payload.setDepositpaid(depositPaid);
		payload.setAdditionalneeds(additionalNeeds);
		payload.setBookingdates(bookingdates);		
	}
	
	public void createBooking(String firstName,String lastName,int totalPrice,boolean depositPaid,String additionalNeeds) {	
		
		createPayload(firstName,lastName,totalPrice,depositPaid,additionalNeeds);
		response = restAssured.post(getRequestSpecification(), payload);	
	}
		
	public void getBookingIds() {
	  response = restAssured.get(getRequestSpecification());
	  
	}
	
	public void getBoookingRecord(String bookingId) {
		response = restAssured.get(getRequestSpecification(), bookingId);
		System.out.println(response.getStatusMessage());	
	}
	
	public void updateRecord(String bookingId, String firstName, String lastName,int totalPrice, boolean depositPaid,String additionalNeeds) {
		
		createPayload(firstName,lastName,totalPrice,depositPaid,additionalNeeds);
		restAssured.put(getRequestSpecification(), bookingId, payload);	
	}

	public void deleteBoookingRecord(String bookingId) {
		
		restAssured.delete(getRequestSpecification(), bookingId);
	}
	
	

}

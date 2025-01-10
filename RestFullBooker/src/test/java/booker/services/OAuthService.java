package booker.services;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.matschie.api.design.ResponseAPI;
import com.matschie.api.rest.assured.lib.RestAssuredBaseImpl;

import static com.matschie.general.utils.PropertiesHandlers.*;
import io.restassured.specification.RequestSpecification;

public class OAuthService extends Booker {
	
	
	
	private ResponseAPI response;
	private RestAssuredBaseImpl restAssured = new RestAssuredBaseImpl();
	private RequestSpecification requestSpecification;
	
	public void setRequestSpec(RequestSpecification requestSpecification) {
		this.requestSpecification = requestSpecification;		
	}
	
	private RequestSpecification getRequestSpec() {
		if (requestSpecification != null) {
			return requestSpecification;
		} else {
			return globalRequestSpec();
		}
	}
	
	public void createOAuthToken() {
		Map<String, String> forms = new HashMap<String, String>();
		
		forms.put("username", config("sevice.now.username"));
		forms.put("password", secret("service.now.password"));
		response = restAssured.post(getRequestSpec(), forms);
	}
	
	public String extractToken() {
		JSONObject json = new JSONObject(response.getBody());
		return json.getString("token");
	}

}
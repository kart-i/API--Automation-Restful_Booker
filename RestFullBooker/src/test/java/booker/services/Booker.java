package booker.services;

import com.matschie.api.rest.assured.lib.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.matschie.general.utils.PropertiesHandlers.*;

public class Booker {
	
	public RequestSpecification globalRequestSpec() {
		return new RequestSpecBuilder()
				   .setBaseUri(config("booker.base.uri"))		
				   .setBasePath(config("booker.base.path"))
				   .setContentType(ContentType.JSON)
				   .setUsername(config("booker.username"))
			       .setPassword(secret("booker.password"))
				   .setAccept(ContentType.JSON)
				   .setHeaderKey(config("booker.cookieKey"))
				   .setHeaderValue(config("booker.cookieValue"))
				   .build();
	}
		
}
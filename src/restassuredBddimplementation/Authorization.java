package restassuredBddimplementation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Authorization {

	@Test
	public void bearer() {
		
	RequestSpecification request = given();
	Response responnse = request.when().get();
	ValidatableResponse a = responnse.then();
	
	
	}
}

package src.test.java;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestApi {

	@Test(enabled = false)
	public void dis() {
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").body();
		
	}
	
	@Test(enabled=true)
	public void TEst2() {
		
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").
		then().
		statusCode(200).body("data[1].id", equalTo(8)).log().all();
		
	}
}

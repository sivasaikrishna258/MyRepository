package restassuredBddimplementation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HTTPMethodsImplementation {
	
	
	@Test
	public void Get() {
		
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").
		then().statusCode(200).statusLine("HTTP/1.1 200 OK").statusLine(containsString("OK")).body("data.id", equalTo(7)).//to verify exact value in response
															//verify it has mentioned items using hasItems() method
															 body("data.id", hasItems(7)).log().all();
		
	}
	
	@Test
	public void Get1() {
		
		baseURI="https://reqres.in/api";
		Response res = given().
		when().get("/users?page=2");
		
	}
	

}

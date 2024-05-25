package restassuredBddimplementation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class HTTPMethodsImplementation {
	
	
	//@Test
	public void Get() {
		
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").
		then().statusCode(200).statusLine("HTTP/1.1 200 OK").statusLine(containsString("OK")).body("data.id", equalTo(7)).//to verify exact value in response
															//verify it has mentioned items using hasItems() method
															 body("data.id", hasItems(7)).log().all();
		
	}
	
	@Test
	public void Post() {
		
		
		
		JSONObject js=new JSONObject();
		
		js.put("name", "siva");
		js.put("role", "sdet");
		
		RequestSpecification request = given();
		request.body(js.toJSONString());
		request.contentType(ContentType.JSON);
		
		Response response = request.when().post("https://reqres.in/api/users");
		ValidatableResponse verify = response.then();
		
		verify.statusCode(201).log().headers();
		
		
	}
	
	@Test
	public void Put() {
		RequestSpecification request = given();
		request.header("Content-Type","application.json");
		Response res = request.when().put("https://reqres.in/api/users/2");
		
		ValidatableResponse response = res.then();
		
		response.statusCode(201);
	
	}
	

}

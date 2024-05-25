package src.test.java;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Res {
	
	
	@Test
	public void dis() {
		baseURI="https://reqres.in/api";
		RequestSpecification req=given();
		
		req.contentType("application.json");
		req.pathParam("user", "users");
		req.queryParam("page", 2);
		
	
		Response body = req.when().get("/{user}");
		
		System.out.println("content type is :"+body.getHeader("Content-Type"));
		
		System.out.println("id is : "+body.jsonPath().get("data[0].id").toString());
		
		
		JSONObject obj=new JSONObject(body.asString());
		
		System.out.println("name is :"+obj.getJSONArray("data").getJSONObject(0).get("id"));
		
		ValidatableResponse response = body.then();
		
		response.statusCode(200);
		//response.time(lessThan(2000L));
		//response.log().headers();
		response.body("data[0].id", equalTo(7));
		response.time(lessThan(2000L));
		
		
		
		
		
	}
	
	@Test(enabled=false)
	public void TEst2() {
		
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").
		then().
		statusCode(200).body("data[1].id", equalTo(8)).log().all();
		
	}
	
	
	//@Test
	public void TEst3() {
		
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").
		then().
		statusCode(200).body("data[1].id", equalTo(8)).log().all();
		
	}
}

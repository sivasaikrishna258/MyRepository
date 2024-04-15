package src.test.java;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GETandPOSTExample {

	@Test(priority=0)
public void GET() {
		
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").
		then().
		statusCode(200).body("data[1].id", equalTo(8)).log().all();
		
	}

	
	@Test
	public void Post() {	
		
		JSONObject req=new JSONObject();
		req.put("name", "req");
		req.put("role", "qreq");
		
		
	
		given().body(req.toString()).log().all().
		when().post("https://reqres.in/api/users").
		then().statusCode(201);
		
	}
	
	
}

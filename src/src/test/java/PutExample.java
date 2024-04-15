package src.test.java;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutExample {

	@Test
	public void Put() {
			
			JSONObject req=new JSONObject();
			req.put("name", "req");
			req.put("role", "teacher");
			System.out.println(req.toJSONString());
			baseURI="https://reqres.in/api";
			given().body(req.toJSONString())
			.when().put("/users/2")
			.then().statusCode(200).log().all();

			
		}
}

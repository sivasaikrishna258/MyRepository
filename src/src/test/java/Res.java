package src.test.java;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Res {
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

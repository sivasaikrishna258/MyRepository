package src.test.java;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Parameters {

	@Test
	public void pathParameter() {
//		https://reqres.in/api/users?page=2&id=5
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api";
		
		
		given().pathParam("path", "users")
				.queryParam("page", "2").queryParam("id", "5").
				when().get("/{path}").
		then().statusCode(200).log().all();
		
	}
}

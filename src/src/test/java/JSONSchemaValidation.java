package src.test.java;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;
public class JSONSchemaValidation {

	@Test(priority=0)
	public void GET() {
			
		//RestAssured.baseURI="https://reqres.in/api";  we will use this if we dont do static import
			baseURI="https://reqres.in/api";
			//for json schema validation
			given().get("/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
			
			//for XML schema validation
//			given().get("/users?page=2").then().assertThat().body(matchesXsdInClasspath("schema.xsd")).statusCode(200);
}
	
}

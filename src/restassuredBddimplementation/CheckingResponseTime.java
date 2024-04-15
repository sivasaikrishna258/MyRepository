package restassuredBddimplementation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CheckingResponseTime {

	
	@Test
		public void verifyHeaders() {
			
			

			given().baseUri("https://reqres.in/api").header("Contenttype","application.json").

			when().get("/users?page=2").
			
			then().time(lessThan(2000L)).contentType(ContentType.JSON);
			
//			long time=res.getTime();
//			ValidatableResponse valRes = res.then();
//			valRes.time(lessThan(2000L));
			
		}
}

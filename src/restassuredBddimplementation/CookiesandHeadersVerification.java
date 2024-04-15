package restassuredBddimplementation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CookiesandHeadersVerification {
	
	//@Test
	public void verifyHeaders() {
		baseURI="https://reqres.in/api";
		
		given().get("/users?page=2")
		.then().and().log().all().statusCode(200).statusLine(containsString("OK")).contentType(ContentType.JSON);
	}
	
	//getting all cookies
	//@Test
	void getCookies() {
		
		Response res = given().
		when().get("https://www.google.com");
		Map<String, String> allcookies = res.getCookies();
		System.out.println(allcookies.keySet());
		
		for(Entry<String,String> map:allcookies.entrySet()) {
			System.out.println(map.getKey()+" = "+map.getValue());
		}

	}
	
	//getting all headers
	@Test
	void getHeaders() {
		
		Response res = given().contentType(ContentType.JSON).
		when().get("https://www.google.com");
		Headers allHeaders = res.getHeaders();
		
		for(Header hd:allHeaders) {
		System.out.println(hd.getName()+"="+hd.getValue());
	}
	}
	
	

}

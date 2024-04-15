package restassuredBddimplementation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseVerify {

	@Test
	public void Verifyresponse() {
		baseURI="https://reqres.in/api";

		Response res=given().get("/users?page=2");
		JSONObject jas=new JSONObject(res.asString());
		 
		System.out.println(jas.getJSONArray("data").getJSONObject(0).get("id"));
	}
}

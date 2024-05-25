package restassuredBddimplementation;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class ParsingJSONResponseBody {

	
	//@Test
	void gettingTheEachField() {
	
		Response res = given().
					   when().get("https://reqres.in/api/users?page=2");
		
		

		//approach 1 for getting the fields on our wish using json path
		String id=res.jsonPath().get("data[0].id").toString();
		//String a = res.jsonPath().setRootPath("data[0]").get(id).toString();
		System.out.println(id);
		
		//approach 2 for getting all the fileds from response with corresponding value
		int a1=0;
		JSONObject obj=new JSONObject(res.asString()); //converting response into jsonobject
	
		System.out.println(obj.getJSONArray("data").getJSONObject(0).get("id"));
		
		for(int i=0;i<obj.getJSONArray("data").length();i++) {
			String d=obj.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(d);
			
			String d1=obj.getJSONArray("data").getJSONObject(i).get("id").toString();
			int a=Integer.parseInt(d1);
			a1=a1+a;
		}
		System.out.println(a1);

	}
	
	@Test
	void gettingFirstNameOfallObjects() {
		Response res=given().
	    when().get("https://reqres.in/api/users?page=2");
		JSONObject obj=new JSONObject(res.asString());
		for(int i=0;i<obj.getJSONArray("data").length();i++) {
			String name=obj.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			if(name.equalsIgnoreCase("Michael")) {
			System.out.println(name);
			break;
			}
		}
	}
}

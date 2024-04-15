package restassuredBddimplementation;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

import java.util.List;

public class ParsingXMLResponseBody {

	//@Test
	void parsingXml() {
		
		Response res=given().
		when().get("https://chercher.tech/sample/api/books.xml");
		
		//approach 1 getting required data using xmlpath
		String title=res.xmlPath().get("bookstore.book[0].title").toString();
		System.out.println(title);
		
		//approach 2 getting required data using xmlpath class reference variable
		
		XmlPath obj=new XmlPath(res.asString());
		String ss = obj.get("bookstore.book[0].year").toString();
		System.out.println(ss);
		List<String> books = obj.getList("bookstore.book[0]");
		System.out.println(books.get(0));
}
	
	@Test
	void parsingXmlr() {
		
		given().
		when().get("https://chercher.tech/sample/api/books.xml").
		then().root("bookstore.book[0]").body("author",equalTo("Hannah")).log().ifValidationFails();
		
		
		
		}
}

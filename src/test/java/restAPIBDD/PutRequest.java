package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	

	@Test
	public void putcall() {
		
		Map<String, Object> PostBody = new HashMap<String, Object>();
		PostBody.put("name", "Rob1");
		PostBody.put("salary", "4000");
	
	RestAssured.given()
	   .baseUri("http://localhost:7000")
	   .contentType(ContentType.JSON)
	   .accept(ContentType.JSON)
	   .body(PostBody)
	   .when()
	   .put("/employees/10")
	   .then()
	   .statusCode(200)
	   .log()
	   .all();

}
	}
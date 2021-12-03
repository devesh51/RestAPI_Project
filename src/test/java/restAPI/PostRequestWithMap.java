package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {
	
	@Test
	public void PostCall() {
		
		RestAssured.baseURI ="http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Map<String, Object> PostBody = new HashMap<String, Object>();
		PostBody.put("name", "devesh");
		PostBody.put("salary", "4000");
		
		
		Response response = request.contentType(ContentType.JSON)
							       .accept(ContentType.JSON) 
							       .body(PostBody)
							       .post("employees/create");
		
		String RespondBody = response.body().asString();
		System.out.println(RespondBody);
		
		

		int ActResponce = response.statusCode();
		int ExpResponse = 201;
		
		
		AssertJUnit.assertEquals(ActResponce, ExpResponse);

	}

}

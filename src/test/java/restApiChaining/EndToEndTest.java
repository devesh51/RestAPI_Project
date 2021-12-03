package restApiChaining;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndToEndTest {
	
    //=========== Post call ================	

	@Test
	public void test1() {
		RestAssured.baseURI ="http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Map<String, Object> PostBody = new HashMap<String, Object>();
		PostBody.put("name", "gagan");
		PostBody.put("salary", "4000");
		
		
		Response Postresponse = request.contentType(ContentType.JSON)
							       .accept(ContentType.JSON) 
							       .body(PostBody)
							       .post("employees/create");
		
		String RespondBody = Postresponse.body().asString();
		System.out.println(RespondBody);
		
		JsonPath jpath = Postresponse.jsonPath();
		String ResponseID = jpath.get("id").toString();
		
		//================== Put Call ==================
		
		RequestSpecification Putrequest = RestAssured.given();
		Map<String, Object> PutBody = new HashMap<String, Object>();
		PutBody.put("name", "Rob");
		PutBody.put("salary", "4000");
		
		
		Response putresponse = Putrequest.contentType(ContentType.JSON)
							       .accept(ContentType.JSON) 
							       .body(PutBody)
							       .put("/employees/" + ResponseID);
		
		RespondBody = putresponse.body().asString();
		System.out.println(RespondBody);
		
		
		//=========== Delete Call ======================
		
		RequestSpecification Deleterequest = RestAssured.given();
		Response Deleteresponse = Deleterequest.delete("/employees/" + ResponseID);
		

		//int ActResponce = Deleteresponse.statusCode();
		//int ExpResponse = 200;
		
		
		//Assert.assertEquals(ActResponce, ExpResponse);
		
		// ======== Get Call =============
		
		RequestSpecification GetRequest = RestAssured.given();
				
		Response GetResponse = GetRequest.get("/employees/" + ResponseID);
				
		int ActResponse = GetResponse.statusCode();
		int ExpResponse = 404;
				
		AssertJUnit.assertEquals(ActResponse, ExpResponse);

		

	}

}

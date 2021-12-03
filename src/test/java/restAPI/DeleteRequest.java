package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	
	@Test
	public void DeleteCall() {
		
		
		RestAssured.baseURI ="http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("/employees/8");
		

		int ActResponce = response.statusCode();
		int ExpResponse = 200;
		
		
		AssertJUnit.assertEquals(ActResponce, ExpResponse);

	}
}

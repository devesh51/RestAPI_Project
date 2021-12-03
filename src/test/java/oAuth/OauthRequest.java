package oAuth;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class OauthRequest {
	
	@Test
	public void Postcall() {
		RestAssured.given()
		   .auth()
		   .oauth2("token")
		   .baseUri("https://api.github.com")
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body("{\n" +
			    " \"name\": \"PostmanTest\",\n" +
			    " \"desription\": \"Test Repo\", \n" +
			    " \"homepage\": \"https://github.com/\", \n" + 
			    " \"private\": false, \n" +
			    " \"has_issues\": true, \n" +
			    " \"has_project\": true, \n" +
			    " \"has_wiki\": true\n" +
			    "}"
				   )
		   .when()
		   .post("/user/repos")
		   .then()
		   .statusCode(201)
		   .log()
		   .all();
		   
		
		
	}

}

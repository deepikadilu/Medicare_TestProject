package tests;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;



public class FirstRestAssuredClass {

	
	public void firstRestMethod() {
		//Create RestAssured object
		RestAssured request=new RestAssured();
		// Get uri
		Response response= request.get("https://reqres.in/api/users?page=2");
		// display status code ie 200
		System.out.println("Status Code is : "+response.getStatusCode());
		//display the json body
		System.out.println(response.body().asString());
		//display headers
		System.out.println("Headers : "+response.headers());
		//System.out.println("Headers : "+response.header("Set-Cookie"));
		
		// Assertion in testng
		Assert.assertEquals(200, response.statusCode()); //Pass
		//Assert.assertEquals(201, response.statusCode()); //fail
	}
	
	@Test
	public void secondRestMethod() {
	 //Response res = given().get("https://reqres.in/api/users?page=2");
	 // System.out.println("Status Code is : "+res.getStatusCode());
//	 	given()
//			 .get("https://reqres.in/api/users?page=2")
//			 .then()
//			 .log().all();
		given()
		 .get("https://reqres.in/api/users?page=2")
		 .then()
		 .log().body()
		 .assertThat()
		 .body("page", equalTo(2))
		 .statusCode(200);
	}
	@Test
	public void thirdRestMethod() {
	 RestAssured.baseURI="https://reqres.in/api/users";
		given()
		.queryParam("delay", 3)
		.when()
		 .get()
		 .then()
		 .log().body()
		 .assertThat()
		 .body("data[0].first_name", equalTo("George"))
		 .statusCode(200);
	}
	
	@Test
	public void fourthRestMethod() {
	// RestAssured.baseURI="https://reqres.in/api/users";
		given()
		.pathParam("userId", 2)
		.when()
		 .get("https://reqres.in/api/users/{userId}")
		 .then()
		 .log().body()
		 .assertThat()
		 .body("data[1].last_name", equalTo("Bluth"))
		 .statusCode(200);
	}
}

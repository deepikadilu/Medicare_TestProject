package tests;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class FirstPostRequestClass {
@Test
	public void createPostPMethod() {
		//Create RestAssured object
		//RestAssured request=new RestAssured();
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		JSONObject req=new JSONObject();
		req.put("name","Chaya");
		req.put("job", "BA");
		
		given()
		.body(req.toJSONString())
		.when()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
}

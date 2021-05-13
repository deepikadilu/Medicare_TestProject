package stepDef;



import static io.restassured.RestAssured.given;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import log.BaseClass;
import utils.PropertyReader;

public class BDDTestMethods extends BaseClass{

	Response res;
	ValidatableResponse res1;
	@Given("I am in reqres site")
	public void i_am_in_reqres_site() {
		RestAssured.baseURI="https://reqres.in/";
		logger.info("User in reqres site.");
	}

	@When("Send a GET HTTP request for user listing")
	public void send_a_get_http_request_for_user_listing() {
		System.out.println("user list");
		
		res = given()
		.queryParam("page", 2)
		.when()
		.get("api/users");
		
		logger.info(res.body().asPrettyString());
		
	}

	@Then("check the total users to be twelve")
	public void check_the_total_users_to_be_twelve() {
		
		JsonPath jsonPath= res.jsonPath();
		Assert.assertEquals(12, jsonPath.get("total"));
		System.out.println("Total:"+jsonPath.get("total"));
		
	}

	@Then("I receive valid response code")
	public void i_receive_valid_response_code() {
		
		Assert.assertEquals(200,res.statusCode());
		logger.info("Status Code:"+res.statusCode());
	}

	@Given("I Set POST user api endpoint")
	public void i_set_post_user_api_endpoint() {
		RestAssured.baseURI="https://reqres.in/";
	}
	//PropertyReader pr=new PropertyReader();
	@When("Send a POST HTTP request with user details")
	public void send_a_post_http_request_with_user_details() throws FileNotFoundException, IOException {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("name","Chaya Prem");
		jsonObj.put("job","BA");
		
		res1= given().body(jsonObj.toJSONString()).when().post("api/users").then().log().all();
	}

	@Then("I receive valid response code for creating")
	public void i_receive_valid_response_code_for_creating() {
		logger.info(res1.assertThat().statusCode(201));
		logger.info("created");	
		System.out.println("Created for console");
	}
}
//@When("I Set request HEADER")
//public void i_set_request_header() {
//	const headers= new HttpHeaders()
//			  .set('content-type', 'application/json')
//			  .set('Access-Control-Allow-Origin', '*');
//	//System.out.println("reqres-header");
//}
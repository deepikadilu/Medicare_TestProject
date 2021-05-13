package com.medicare.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medicare.qa.base.TestBase;
import com.medicare.qa.pages.LoginPage;
import com.medicare.qa.pages.SignUpPage;
import com.medicare.qa.util.TestUtil;

public class NewUserRegistrationTest extends TestBase{

	
	SignUpPage signUp;
	TestUtil testUtil;
	
	String sheetName = "RegistrationDetails";
	
	public NewUserRegistrationTest() {
		super();
		// super class will call TestBase constructor to set the properties.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		Initialization();
		Thread.sleep(5000);
		signUp = new SignUpPage();	
	}
	
	@DataProvider
	public Object[][] getRegisterTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getRegisterTestData")
	public void createNewUser(String fName, String lName, String mail,String contactNo, String firstPwd, String confirmPwd, String role) throws InterruptedException {
		
		
		String signUpHeading = signUp.verifySignUpPageText();
		Assert.assertEquals(signUpHeading, "Sign Up - Personal", "Not in sign up page");
		
		signUp.createNewUser(fName, lName, mail, contactNo, firstPwd, confirmPwd, role);
		Thread.sleep(5000);
		
		signUp.billingSubmit();	
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();		
	}
	
}

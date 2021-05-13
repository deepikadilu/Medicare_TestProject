package com.medicare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicare.qa.base.TestBase;

public class SignUpPage extends TestBase {

	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
	
	@FindBy(xpath="//div[@class='panel-heading']")
	WebElement signUpTxt;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='contactNumber']")
	WebElement contactNumber;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement firstPassword;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@id='role1']")
	WebElement role1;
	
	@FindBy(xpath="//input[@id='role2']")
	WebElement role2;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement regSubmit;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySignUpPageText() {
		signUpLink.click();
		return signUpTxt.getText();
	}
	public void createNewUser(String fName, String lName, String mail,String contactNo, String firstPwd, String confirmPwd, String role ){
		
		 firstName.sendKeys(fName);
		 lastName.sendKeys(lName);		
		 email.sendKeys(mail);
		 contactNumber.sendKeys(contactNo);
		 firstPassword.sendKeys(firstPwd);
		 confirmPassword.sendKeys(confirmPwd);
		 if(role =="USER") {
			 role1.click();
		 }
		 else if (role == "SUPPLIER") {
			 role2.click();
		 }
		 
	}
	
	public void billingSubmit() {
		regSubmit.click();
		
	}

}

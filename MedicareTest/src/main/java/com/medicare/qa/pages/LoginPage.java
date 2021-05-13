package com.medicare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.medicare.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory : OR
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(name="username")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @class='btn btn-primary']")
	WebElement loginBtn;
	
	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String ValidateLoginLink() throws InterruptedException {
		Thread.sleep(5000);
		loginLink.click();
		//Thread.sleep(1000);
		return driver.getTitle();
	}
	
	public UserLoginHome login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.click();
		
		return new UserLoginHome();
		
	}
}

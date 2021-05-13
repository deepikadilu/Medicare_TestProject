package com.medicare.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medicare.qa.base.TestBase;
import com.medicare.qa.pages.LoginPage;
import com.medicare.qa.pages.UserLoginHome;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	UserLoginHome userHome;
	
	public LoginPageTest() {
		super();
		// super class will call TestBase constructor to set the properties.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		Initialization();
		Thread.sleep(5000);
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void LoginLinkTest() throws InterruptedException {
		
		String title =loginPage.ValidateLoginLink();
		Assert.assertEquals(title, "Medicare - Login");
		System.out.println("title="+title);
		LoginCredentials();
		Thread.sleep(5000);
	}
	
	public void LoginCredentials() {
		userHome = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();		
	}
	
	
}

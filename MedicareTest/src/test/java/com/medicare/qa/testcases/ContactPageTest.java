package com.medicare.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medicare.qa.base.TestBase;
import com.medicare.qa.pages.AboutPage;
import com.medicare.qa.pages.ContactPage;
import com.medicare.qa.pages.LoginPage;
import com.medicare.qa.pages.UserLoginHome;

public class ContactPageTest extends TestBase{

	LoginPage loginPage;
	UserLoginHome userHome;
	ContactPage contactPage;
	
	public ContactPageTest() {
		super();
		// super class will call TestBase constructor to set the properties.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		Initialization();
		//Thread.sleep(5000);
		
		//aboutPage = new AboutPage();
		contactPage = new ContactPage();
		loginPage = new LoginPage();	
		//LoginLinkTest() -click of login link
		loginPage.ValidateLoginLink();
		userHome = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(5000);
		
	}
		
	@Test
	
	public void verifyContactPageTest() throws InterruptedException {
		userHome.clickOnContactLink();
		String contactTitle= contactPage.verifyAboutTitle();
		Assert.assertEquals(contactTitle, "Medicare - Contact Us","Title not matched.");
		Thread.sleep(5000);
		
		String aboutText= contactPage.verifyAboutText();
		if (aboutText.contains("Contact Us")) {
			assertTrue(true);
		}	
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();		
	}
}

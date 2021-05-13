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

public class AboutPageTest extends TestBase{

	LoginPage loginPage;
	UserLoginHome userHome;
	AboutPage aboutPage;
	
	public AboutPageTest() {
		super();
		// super class will call TestBase constructor to set the properties.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		Initialization();
		//Thread.sleep(5000);
		
		aboutPage = new AboutPage();
		//contactPage = new ContactPage();
		loginPage = new LoginPage();	
		//LoginLinkTest() -click of login link
		loginPage.ValidateLoginLink();
		userHome = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(5000);
		
	}
		
	@Test
	
	public void verifyAboutPageTest() throws InterruptedException {
		userHome.clickOnAboutLink();
		String aboutTitle= aboutPage.verifyAboutTitle();
		Assert.assertEquals(aboutTitle, "Medicare - About Us","Title not matched.");
		Thread.sleep(5000);
		
		String aboutText= aboutPage.verifyAboutText();
		if (aboutText.contains("About Us")) {
			assertTrue(true);
		}	
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();		
	}
}

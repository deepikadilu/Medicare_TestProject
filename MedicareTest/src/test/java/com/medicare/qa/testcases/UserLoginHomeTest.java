package com.medicare.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medicare.qa.base.TestBase;
import com.medicare.qa.pages.AboutPage;
import com.medicare.qa.pages.ContactPage;
import com.medicare.qa.pages.LoginPage;
import com.medicare.qa.pages.UserLoginHome;
import com.medicare.qa.pages.ViewProductsPage;

public class UserLoginHomeTest extends TestBase {

	
	LoginPage loginPage;
	UserLoginHome userHome;
	ContactPage contactPage;
	AboutPage aboutPage;
	ViewProductsPage productsAll;
	
	public UserLoginHomeTest() {
		super();
		// super class will call TestBase constructor to set the properties.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		Initialization();
		//Thread.sleep(5000);
		
		aboutPage = new AboutPage();
		contactPage = new ContactPage();
		loginPage = new LoginPage();	
		//LoginLinkTest() -click of login link
		loginPage.ValidateLoginLink();
		userHome = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException {
			
		String homePageTitle = userHome.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Medicare - Home","HomePage Title not matched.");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void verifyAboutLink() {
		aboutPage = userHome.clickOnAboutLink();
	}
	
	@Test(priority=3)
	public void verifyContactLink() {
		contactPage = userHome.clickOnContactLink();
	}
	
	@Test(priority=4)
	public void verifyViewProductsAllLink() {
		productsAll = userHome.clickOnViewProductsLink();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();		
	}
	
}

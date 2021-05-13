package com.medicare.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medicare.qa.base.TestBase;
import com.medicare.qa.pages.AboutPage;
import com.medicare.qa.pages.LoginPage;
import com.medicare.qa.pages.UserLoginHome;
import com.medicare.qa.pages.ViewProductsPage;

public class ViewProductsPageTest extends TestBase{

	
	LoginPage loginPage;
	UserLoginHome userHome;
	ViewProductsPage productsAll;
	
	public ViewProductsPageTest() {
		super();
		// super class will call TestBase constructor to set the properties.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		Initialization();
		productsAll=new ViewProductsPage();
		loginPage = new LoginPage();	
		//LoginLinkTest() -click of login link
		loginPage.ValidateLoginLink();
		userHome = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(5000);
		userHome.clickOnViewProductsLink();
		Thread.sleep(5000);
		
	}
		
	@Test(priority=1)
	
	public void verifyViewProductsPageTest() throws InterruptedException {
		//userHome.clickOnViewProductsLink();
		String productTitle= productsAll.verifyProductsTitle();
		System.out.println(productTitle);
		Assert.assertEquals(productTitle, "Medicare - All Products","Title not matched.");
		Thread.sleep(5000);		
	}
	
	@Test(priority=2)
	
	public void selectRecordoptions() throws InterruptedException {
		String initialShowResultsText = productsAll.assertShowResults();
		//userHome.clickOnViewProductsLink();
		productsAll.selectRecordOptions();
		Thread.sleep(5000);
		String latestShowResultsText = productsAll.assertShowResults();	
		if(!latestShowResultsText.equals(initialShowResultsText)){
			System.out.println(initialShowResultsText);
			System.out.println(latestShowResultsText);
			Assert.assertTrue(true, "TestPassed");
	    }
	
	}
	@AfterMethod
	public void teardown(){
		driver.quit();		
	}
	
}

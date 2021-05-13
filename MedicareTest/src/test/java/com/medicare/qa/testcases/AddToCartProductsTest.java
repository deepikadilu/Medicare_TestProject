package com.medicare.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medicare.qa.base.TestBase;
import com.medicare.qa.pages.AddToCartProducts;
import com.medicare.qa.pages.LoginPage;
import com.medicare.qa.pages.UserLoginHome;
import com.medicare.qa.pages.ViewProductsPage;
import com.medicare.qa.util.TestUtil;

public class AddToCartProductsTest extends TestBase{

	
	
	LoginPage loginPage;
	UserLoginHome userHome;
	TestUtil testUtil;
	ViewProductsPage productsAll;
	AddToCartProducts addCart;
	
	String sheetName = "Search";
	
	public AddToCartProductsTest() {
		super();
		// super class will call TestBase constructor to set the properties.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		Initialization();
		//productsAll=new ViewProductsPage();
		loginPage = new LoginPage();
		
		//LoginLinkTest() -click of login link
		loginPage.ValidateLoginLink();
		
		userHome = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(5000);
		
		userHome.clickOnViewProductsLink();
		Thread.sleep(5000);
		
		String productTitle = productsAll.verifyProductsTitle();
		System.out.println(productTitle);
		Assert.assertEquals(productTitle, "Medicare - All Products","Title not matched.");
			
	}
	
	@Test(priority=1)
	
	public void addToCartOrderConfirm() {
		
		//addCart.searchClick();
	
	//	System.out.println("step1 : Product page verify");
//		addCart.selectAndAddToCart();
//		System.out.println("step2 : add to cart");
//
//		String checkoutTitle = addCart.verifyPage();
//		Assert.assertEquals(checkoutTitle, "Medicare - Shopping Cart", "User not in cart chekout Page");
//		
//		addCart.checkoutClick();
//		
//		String addressTitle = addCart.verifyPage();
//		Assert.assertEquals(addressTitle, "Medicare - Membership", "User not in AddressPage");
//		
//		addCart.selectAddressUser();
//		addCart.userPayAmount();
//		
//		String confirmText= addCart.verifyConfirmText();
//	
//		if (confirmText.contains("Your Order is Confirmed")) {
//			assertTrue(true);
//		}	
//		
//		
//		//Your Order is Confirmed!!
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();		
	}
}

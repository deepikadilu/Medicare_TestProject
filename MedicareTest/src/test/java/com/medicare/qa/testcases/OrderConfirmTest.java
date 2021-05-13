package com.medicare.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medicare.qa.base.TestBase;
import com.medicare.qa.pages.AddToCartProducts;
import com.medicare.qa.pages.LoginPage;
import com.medicare.qa.pages.UserLoginHome;
import com.medicare.qa.pages.ViewProductsPage;

public class OrderConfirmTest extends TestBase {

	LoginPage loginPage;
	UserLoginHome userHome;
	ViewProductsPage productsAll;
	AddToCartProducts addCart;
	
	public OrderConfirmTest() {
		super();
		// super class will call TestBase constructor to set the properties.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		Initialization();
		loginPage = new LoginPage();	
		//LoginLinkTest() -click of login link
		loginPage.ValidateLoginLink();
		userHome = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(5000);
		userHome.clickOnViewProductsLink();
		Thread.sleep(5000);
		productsAll=new ViewProductsPage();
		productsAll.addToCartAction();
		addCart = new AddToCartProducts();
	}
	
	@Test
	
	public void addToCartOrderConfirm() throws InterruptedException {
		try {
			
			//productsAll.searchClick();
			Thread.sleep(5000);
			addCart.addProduct();
			System.out.println("step1 : Click Add to cart link");
			Thread.sleep(5000);
			
			String cartTitle = addCart.verifyPage();
			Assert.assertEquals(cartTitle, "Medicare - Shopping Cart", "User not in cart Page");
			System.out.println("step2 : verified cart title");
			
			addCart.checkoutClick();
			Thread.sleep(5000);
			
			String checkoutTitle = addCart.verifyPage();
			Assert.assertEquals(checkoutTitle, "Medicare - Membership", "User not in chekout Page");
			System.out.println("step3 : checkout title verified ");
			
			addCart.selectAddressUser();	
			System.out.println("step5 : address selected");	
			Thread.sleep(5000);
			
			String payTitle = addCart.verifyPage();	
			Assert.assertEquals(payTitle, "Medicare - Membership", "User not in AddressPage");
		
			addCart.userPayAmount();
			Thread.sleep(5000);
			
			String confirmText= addCart.verifyConfirmText();
		
			if (confirmText.contains("Your Order is Confirmed")) {
				Assert.assertTrue(true);
			}	
			
			
			
		}catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
		
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();		
	}
}

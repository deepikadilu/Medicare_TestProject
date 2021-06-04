package com.appium.swiggy.testcases;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.swiggy.base.TestBase;
import com.appium.swiggy.pages.SwiggyLocation;
import com.appium.swiggy.pages.SwiggyRestaurantPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class SwiggyLocationTest extends TestBase{
	
	
	SwiggyLocation loc;
	SwiggyRestaurantPage restaurant;
	
	
	public SwiggyLocationTest() {
		super();
		// super class will call TestBase constructor to set the properties.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		Initialization();
		Thread.sleep(5000);
		driver.get("https://www.swiggy.com/");
		Thread.sleep(5000);
		loc = new SwiggyLocation();	
		restaurant = new SwiggyRestaurantPage();
	}
	
	@Test
	public void DeliveryLocationTest() throws InterruptedException {
		loc.locationInput("Malad");
		Thread.sleep(4000);
		
		loc.locationDropdownSelect();
		Thread.sleep(4000);
		
		String pageUrl= restaurant.AssertSwiggyPage();
		Assert.assertEquals(pageUrl, "https://www.swiggy.com/restaurants" );
		System.out.println("User in swiggy restaurant page");
		
		WebElement home=driver.findElement(By.className("_3odgy"));
		String actual = home.getText();
		System.out.println(actual);
		String expected="Malad West";
		Assert.assertEquals(actual, expected);
		System.out.println("Assert Passed");
		Thread.sleep(3000);
		
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();		
	}
	

}

package com.appium.swiggy.pages;

import org.openqa.selenium.support.PageFactory;


import com.appium.swiggy.base.TestBase;

public class SwiggyRestaurantPage extends TestBase {

	
	public SwiggyRestaurantPage() {
		
		PageFactory.initElements(driver, this);
	}

	
	public String AssertSwiggyPage() {
		return driver.getCurrentUrl();
		
		
		
	}
}
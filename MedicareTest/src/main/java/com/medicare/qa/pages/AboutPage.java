package com.medicare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicare.qa.base.TestBase;

public class AboutPage extends TestBase{

	
	
	@FindBy(xpath="//div[@class='content']")
	WebElement aboutTxt;
	
	public AboutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAboutTitle() {	
		return driver.getTitle();
	}
	
	public String verifyAboutText() {
		return aboutTxt.getText();
		
	}
}

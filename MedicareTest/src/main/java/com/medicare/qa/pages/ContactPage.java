package com.medicare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicare.qa.base.TestBase;

public class ContactPage extends TestBase{

	@FindBy(xpath="//div[@class='content']")
	WebElement contactTxt;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAboutTitle() {	
		return driver.getTitle();
	}
	
	public String verifyAboutText() {
		return contactTxt.getText();
		
	}
	
}

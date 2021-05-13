package com.medicare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicare.qa.base.TestBase;

public class UserLoginHome extends TestBase{

	//PageFactory : OR
	
		@FindBy(xpath="//a[text()='About']")
		WebElement aboutLink;
		
		@FindBy(xpath="//a[text()='Contact']")
		WebElement contactLink;
	
		@FindBy(xpath="//a[text()='View Products']")
		WebElement viewProductsLink;
	
		public UserLoginHome() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() {
			
			return driver.getTitle();
		}
		
		public AboutPage clickOnAboutLink() {
			
			aboutLink.click();
			return new AboutPage();
			
		}
		
		public ContactPage clickOnContactLink() {
			
			contactLink.click();
			return new ContactPage();
		}
		
		public ViewProductsPage clickOnViewProductsLink() {
			
			viewProductsLink.click();
			return new ViewProductsPage();
		}
		
		
}

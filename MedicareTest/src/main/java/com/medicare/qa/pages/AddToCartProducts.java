package com.medicare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicare.qa.base.TestBase;

public class AddToCartProducts extends TestBase {

//	@FindBy(xpath="//div[@id='productListTable_filter']//input[@type='search']")
//	WebElement searchClick;
	
//	@FindBy(xpath="//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]")
//	WebElement selectMedicine;

	
	@FindBy(xpath="//*[@id=\"productListTable\"]/tbody/tr[1]/td[6]/a[2]")
	WebElement addCartLink;
	
	@FindBy(xpath="//*[@id=\"cart\"]/tfoot/tr[2]/td[4]/a")
	WebElement checkoutLink;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div/div[1]/div/div/div/a")
	WebElement selectAddress;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-lg btn-block']")
	WebElement userPay;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement orderconfirm;		
	
	public AddToCartProducts() {
		PageFactory.initElements(driver, this);
	}
	
//	public void searchClick() {	
//		searchClick.click();
//		searchClick.sendKeys("Paracetamol");
//		searchClick.submit();
//	}
	
	public String verifyPage() {	
		
		return driver.getTitle();
	
	}
	
	public void addProduct() {
		addCartLink.click();
	}
	
	public void checkoutClick() {	
		checkoutLink.click();
	}
	
	public void selectAddressUser() {	
		selectAddress.click();
	}
	
	public void userPayAmount() {	
		userPay.click();
	}
	public String verifyConfirmText() {
		return orderconfirm.getText();
		
	}
	
}

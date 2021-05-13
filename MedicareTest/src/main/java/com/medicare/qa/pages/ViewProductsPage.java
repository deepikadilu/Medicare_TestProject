package com.medicare.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicare.qa.base.TestBase;

public class ViewProductsPage extends TestBase{

	
		@FindBy(xpath="//select[@name='productListTable_length']//option")
		List<WebElement> options;
		
		@FindBy(xpath="//div[@class='dataTables_info']")
		WebElement showResults;
		
		@FindBy(xpath="//div[@id='productListTable_filter']//input[@type='search']")
		WebElement searchClick;
		
		
		
	public ViewProductsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyProductsTitle() {	
		return driver.getTitle();
		
	}
	
	public void selectRecordOptions() {
		//options.click();
		//Count the Values
		System.out.println(options.size());
		
		for(int i=0;i<options.size();i++){
		    //Print the text
		//System.out.println(options.size().get(i).getText());
		String optionName = options.get(i).getText();
	    //If u want to select the particular Value
	    if(optionName.equals("ALL")){
	    		options.get(i).click();
	    	}
		}
	}
	
	public String assertShowResults() {	
		
		return showResults.getText();
	}
	
	public void searchClick() {	
		searchClick.click();
		searchClick.sendKeys("Paracetamol");
		searchClick.submit();
	}
	public AddToCartProducts addToCartAction() {
		
		return new AddToCartProducts();
	}
	
}

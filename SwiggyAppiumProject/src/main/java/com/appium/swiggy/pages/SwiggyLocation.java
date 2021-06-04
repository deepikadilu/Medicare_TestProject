package com.appium.swiggy.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appium.swiggy.base.TestBase;

public class SwiggyLocation extends TestBase{
	
	@FindBy(id="location")
	WebElement loc;
	
	//List<WebElement> statusvalues = driver.findElement(By.xpath("//div[@class='_1oLDb']")).findElements(By.tagName("span"));
	@FindBy(xpath="//div[@class='_1oLDb']//span")
	List<WebElement> statusvalues;		
			
	public SwiggyLocation() {
		
		PageFactory.initElements(driver, this);
	}

	
	
	public void locationInput(String homeloc) {
		loc.click();
		loc.sendKeys(homeloc);
		
	}

	public void locationDropdownSelect() {
		
		
//		for (WebElement option : statusvalues)
//		{
//			if (option.getText().contains("Vanchiyoor, Thiruvananthapuram, Kerala, India"))
//				option.click();
			statusvalues.get(0).click();
		   //System.out.println(option.getText());         
//		}
	}
}

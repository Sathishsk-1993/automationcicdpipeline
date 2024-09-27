package com.qa.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.Baseclass.baseclass;

public class finishpage extends baseclass {

	@FindBy(css=".complete-header")
	WebElement successmessage;
	
	
	
	public finishpage() {
		PageFactory.initElements(driver, this);
	}
	
	public String successmessage() {
		return successmessage.getText();
		
	}
	
	
	String successMessage = driver.findElement(By.cssSelector(".complete-header")).getText();
	
	
	

}

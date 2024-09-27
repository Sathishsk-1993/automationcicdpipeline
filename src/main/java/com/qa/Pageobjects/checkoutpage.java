package com.qa.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Baseclass.baseclass;

public class checkoutpage extends baseclass {
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(id="continue")
	WebElement clickcontinuebutton;
	
	@FindBy(id="finish")
	WebElement finishpage;

	public checkoutpage() {
		PageFactory.initElements(driver, this);
	}




public void fillcheckoutpage() {
	
	firstname.sendKeys("sam");
	lastname.sendKeys("kumar");
	postalcode.sendKeys("65823");
	clickcontinuebutton.click();
}

public com.qa.Pageobjects.finishpage finish() {
	
	finishpage.click();
	return new finishpage();
}

}

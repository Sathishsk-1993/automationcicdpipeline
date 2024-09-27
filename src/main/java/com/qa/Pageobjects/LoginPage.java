/**
 * 
 */
package com.qa.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Baseclass.baseclass;

/**
 * 
 */
public class LoginPage extends baseclass {

	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement submitbtn;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void  login(String un, String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		submitbtn.click();	
	}
	
	

}

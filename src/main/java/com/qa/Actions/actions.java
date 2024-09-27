package com.qa.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Baseclass.baseclass;

public class actions extends baseclass {
	
	
	
		
		public WebElement presenceOfElementLocated( By findby) {
			
			WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(15));
			return wait.until(ExpectedConditions.presenceOfElementLocated(findby));
			}
	}



package com.qa.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.Actions.actions;
import com.qa.Baseclass.baseclass;

public class cartpage extends baseclass {

    String[] desiredProducts = { "Sauce Labs Backpack", "Sauce Labs Bike Light" };
    actions action;

    @FindBy(id = "checkout")
    WebElement clickcheckoutpage;

    // Constructor to initialize the cart page elements
    public cartpage() {
        PageFactory.initElements(driver, this);
        action = new actions();  // Initialize actions object
    }

    // Method to verify that all desired products are present in the cart
    public boolean verifyAllProductsPresent() {
        boolean allProductsPresent = true;

        for (String desiredProduct : desiredProducts) {
            By productInCartLocator = By.xpath("//div[text()='" + desiredProduct + "']");
            try {
                WebElement productInCart = action.presenceOfElementLocated(productInCartLocator);
                System.out.println("Product " + desiredProduct + " is in the cart.");
            } catch (Exception e) {
                System.out.println("Product " + desiredProduct + " is not in the cart or not visible.");
                allProductsPresent = false; // Mark as not present
            }
        }
        return allProductsPresent;
    }

    public checkoutpage gotocheckoutpage() {
        clickcheckoutpage.click();
        return new checkoutpage();
    }

	public boolean verifyProductsPresent(String[] desiredProducts2) {
		// TODO Auto-generated method stub
		return false;
	}
}

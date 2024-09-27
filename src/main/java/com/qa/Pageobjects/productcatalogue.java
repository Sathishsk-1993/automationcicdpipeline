package com.qa.Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.Baseclass.baseclass;

public class productcatalogue extends baseclass {

    // Desired products
    String[] desiredProducts = { "Sauce Labs Backpack", "Sauce Labs Bike Light" };

    @FindBy(css = ".inventory_item_name")
    List<WebElement> products;

    @FindBy(xpath = "//button[text()='Add to cart']")
    List<WebElement> addToCartButtons;
    
    @FindBy(css = ".shopping_cart_link")
    WebElement cartpage;

    // Constructor
    public productcatalogue() {
        PageFactory.initElements(driver, this);
    }

    // Method to get the product WebElement based on the name
    public WebElement getProductByName(String desiredProduct) {
        return products.stream()
                .filter(p -> p.getText().equalsIgnoreCase(desiredProduct))
                .findFirst()
                .orElse(null);
    }

    // Method to add the desired products to the cart
    public void addDesiredProductsToCart() {
        for (String desiredProduct : desiredProducts) {
            WebElement prod = getProductByName(desiredProduct);
            if (prod != null) {
                int index = products.indexOf(prod);
                addToCartButtons.get(index).click();
                System.out.println(desiredProduct + " added to cart.");
            } else {
                System.out.println(desiredProduct + " not found.");
            }
        }
    }
    

    
	public void getProductByName(String[] desiredProducts2) {
		// TODO Auto-generated method stub
		
	}
    
    public com.qa.Pageobjects.cartpage gotocartpage() {
    	cartpage.click();
    	return new cartpage();
    	
    }
}


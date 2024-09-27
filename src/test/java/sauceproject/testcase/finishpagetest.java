package sauceproject.testcase;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Baseclass.baseclass;
import com.qa.Pageobjects.LoginPage;
import com.qa.Pageobjects.cartpage;
import com.qa.Pageobjects.checkoutpage;
import com.qa.Pageobjects.finishpage;
import com.qa.Pageobjects.productcatalogue;

public class finishpagetest extends baseclass{

	public finishpagetest() {
		// TODO Auto-generated constructor stub
	}
	String[] desiredProducts = { "Sauce Labs Backpack", "Sauce Labs Bike Light" };

	
	
	@BeforeMethod
    public void setup() throws FileNotFoundException {
        // Initialize browser and login
        intializalation(); // Initialize the driver and other setup
        LoginPage lp = new LoginPage();
        lp.login(prop.getProperty("username"), prop.getProperty("password")); // Login with credentials from the property file
    }
	
	@Test
	public void finishpagetest() {
		  productcatalogue productCatalogue = new productcatalogue();
	        productCatalogue.addDesiredProductsToCart(); // Add desired products to the cart
	        productCatalogue.gotocartpage(); // Navigate to cart page

	        // Verify the products in the cart
	        cartpage cartPage = new cartpage();
	        boolean productsPresent = cartPage.verifyProductsPresent(desiredProducts); // Verify if the products are present in the cart
	        System.out.println(productsPresent);
	        cartPage.gotocheckoutpage();
	        checkoutpage pg = new checkoutpage();
		     pg.fillcheckoutpage();
		     pg.finish();
		     finishpage pe = new finishpage();
		     String message= pe.successmessage();
		     Assert.assertEquals(message, "Thank you for your orders!", "Order success message mismatch!");
	}
	
	  @AfterMethod
	    public void tearDown() {
	        driver.close(); // Close the browser after the test
	    }
	}




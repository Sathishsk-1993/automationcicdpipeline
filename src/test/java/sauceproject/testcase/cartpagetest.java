package sauceproject.testcase;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Baseclass.baseclass;
import com.qa.Pageobjects.LoginPage;
import com.qa.Pageobjects.cartpage;
import com.qa.Pageobjects.productcatalogue;

public class cartpagetest extends baseclass {

    // Desired products to add to cart
    String[] desiredProducts = { "Sauce Labs Backpack", "Sauce Labs Bike Light" };

    // Constructor
    public cartpagetest() {
        super();
    }

    @BeforeMethod
    public void setup() throws FileNotFoundException {
        // Initialize browser and login
        intializalation(); // Initialize the driver and other setup
        LoginPage lp = new LoginPage();
        lp.login(prop.getProperty("username"), prop.getProperty("password")); // Login with credentials from the property file
    }

    @Test
    public void verifycartpageproducts() throws InterruptedException {
        // Add desired products to the cart
        productcatalogue productCatalogue = new productcatalogue();
        productCatalogue.addDesiredProductsToCart(); // Add desired products to the cart
        productCatalogue.gotocartpage(); // Navigate to cart page

        // Verify the products in the cart
        cartpage cartPage = new cartpage();
        boolean productsPresent = cartPage.verifyProductsPresent(desiredProducts); // Verify if the products are present in the cart
        System.out.println(productsPresent);
        //Thread.sleep(2000);
        // Assert that all products are present
        //Assert.assertTrue(productsPresent, "Not all desired products are present in the cart.");
    }

    @AfterMethod
    public void tearDown() {
        driver.close(); // Close the browser after the test
    }
}


package sauceproject.testcase;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Baseclass.baseclass;
import com.qa.Pageobjects.LoginPage;
import com.qa.Pageobjects.productcatalogue;

public class productcataloguetest extends baseclass {
	  String[] desiredProducts = { "Sauce Labs Backpack", "Sauce Labs Bike Light" };
	
	
	public productcataloguetest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws FileNotFoundException {
		intializalation();
		LoginPage lp = new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	
	public void getproductsdromlist() {
		productcatalogue ct = new productcatalogue();
		ct.getProductByName(desiredProducts);
		ct.addDesiredProductsToCart();
		ct.gotocartpage();
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	

}

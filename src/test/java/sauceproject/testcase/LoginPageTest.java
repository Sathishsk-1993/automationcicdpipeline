package sauceproject.testcase;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Baseclass.baseclass;
import com.qa.Pageobjects.LoginPage;

public class LoginPageTest extends baseclass {

	LoginPage lp;
	
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public  void setup() throws FileNotFoundException {
		
		intializalation();
		 lp = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void logintest() {
		
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void loginPageTitleTest(){
		String title = lp.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Swag Labs1");
	}
	
	


	@AfterMethod
	public void teardown() {
		
		driver.close();
	}
	
	

}

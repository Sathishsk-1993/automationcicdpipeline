/**
 * 
 */
package com.qa.Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;



/**
 * 
 */


public class baseclass {
	public static WebDriver driver;
	public static Properties prop;
	
	 public void intializalation() throws FileNotFoundException {
		 prop = new Properties ();
		 String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\config\\config.properties";
		FileInputStream ip = new FileInputStream (filepath);
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	String browsername = System.getProperty("browser")!= null ? System.getProperty("browser"): prop.getProperty("browser");
	if(browsername.contains("chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//cgvaklt271//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");
		
	   driver = new ChromeDriver();
	}else if (browsername.contains("firefox")) {
		System.setProperty("webdriver.gecko.driver","C://Users//cgvaklt271//Downloads//geckodriver-v0.35.0-win-aarch64//geckodriver.exe");
		 driver = new FirefoxDriver();
		
	}
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
	
	driver.get(prop.getProperty("url"));
	
}
	 
	 public String getscreenshot(String methodName, WebDriver driver) throws IOException {
		    // Path where the screenshot will be saved
		    //String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + methodName + ".png";
		    String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\" + methodName + "_" + System.currentTimeMillis() + ".png";
		    // Take the screenshot and save it to a temporary file
		    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    File destination = new File(screenshotPath);

		    // Ensure the parent directories exist
		    if (!destination.getParentFile().exists()) {
		        destination.getParentFile().mkdirs();  // Create the 'screenshots' directory if it doesn't exist
		    }

		    // Move screenshot from temporary location to the desired destination
		    Files.copy(screenshot.toPath(), destination.toPath());

		    return screenshotPath;
		}






}

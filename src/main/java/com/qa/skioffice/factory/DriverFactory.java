package com.qa.skioffice.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.skioffice.exception.FrameworkException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/*
	 * this method used to initialize the webdriver on the bases of given browser name
	 * @param browserName
	 * @return it return driver
	 * 
	 */
	
	public WebDriver init_driver(Properties prop) {
		
		//
		String browserName = prop.getProperty("browser").trim();
		optionsManager = new OptionsManager(prop);
		System.out.println("Browser Name is: " +browserName);
		
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
		  //driver = new ChromeDriver();
		  //inconito or headless
		  //driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
	}
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
		     driver = new FirefoxDriver();
		   //inconito or headless
		//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		     tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
	}
	
		else if(browserName.equalsIgnoreCase("safari")){
			WebDriverManager.safaridriver().setup();
		    // driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
			
	}
		else {
			
			System.out.println("Please enter the right browser: " +browserName);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());
		
		return getDriver();
	}	
	
	public static WebDriver getDriver() {
		return tlDriver.get();  
	}
	
	

	/*
	 * Initialize properties
	 * 
	
	*/
	/**
	 * this method is reading the properties from the .properties file
	 * 
	 * @return
	 */
	public Properties initProp() {

		// mvn clean install -Denv="qa"
		// mvn clean install
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		System.out.println("Running test cases on Env: " + envName);

		try {
			if (envName == null) {
				System.out.println("no env is passed....Running tests on QA env...");
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;

				default:
					System.out.println("....Wrong env is passed....No need to run the test cases....");
					throw new FrameworkException("WRONG ENV IS PASSED...");
				// break;
				}

			}
		} catch (FileNotFoundException e) {

		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	/*
	 * take screenshot	
	*/
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = "./" + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}
	
	
	
}

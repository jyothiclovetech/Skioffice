package com.qa.skioffice.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.skioffice.factory.DriverFactory;
import com.qa.skioffice.pages.DashboardPage;
import com.qa.skioffice.pages.Employeespage;
import com.qa.skioffice.pages.Loginpage;
import com.qa.skioffice.pages.MyTimeSheetspage;

public class BaseTest {
	
	
	public DriverFactory df;
	public Properties prop;
	
	public WebDriver driver;
	public SoftAssert softAssert;
	
	protected Loginpage loginPage;
	protected MyTimeSheetspage myTimeSheetPage;
	protected Employeespage employeePage;
	protected DashboardPage dashboardPage;

	@BeforeTest
	public void setup() {
		
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new Loginpage(driver);
		softAssert = new SoftAssert();
		
	}
	
	/* @AfterTest
	public void teardown() {
	
		driver.quit();
	}*/
	

}

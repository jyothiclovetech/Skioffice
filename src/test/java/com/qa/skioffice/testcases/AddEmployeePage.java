package com.qa.skioffice.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.skioffice.base.BaseTest;
import com.qa.skioffice.constants.Constants;
import com.qa.skioffice.utils.ExcelUtil;

public class AddEmployeePage  extends BaseTest {
	
	@BeforeClass
	public void employeeSetup() throws InterruptedException {
		Thread.sleep(4000);
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Thread.sleep(4000);
	}
	
	@DataProvider
	public Object[][] getAddEmployeeTestData() {	
		
		
		Object regData[][] = ExcelUtil.getTestData(Constants.AddEmployee_Sheet_Name);
		return regData;
	}

	@Test(priority = 1)
	public void employeeTabClick() throws InterruptedException {
		Thread.sleep(6000);
		employeePage.employeeTabClick();
	}
	
	@Test(priority = 2)
	public  void addEmployeeButtonClick() throws InterruptedException {
		Thread.sleep(3000);
		employeePage.addEmployee();			
	}
	@Test(priority = 3,dataProvider = "getAddEmployeeTestData")
	public void addEmployeeStep1(String role, String empid,String book,
			String jtitle, String empdep, String repManager, String l2Manager, String empemail, String doj, String loc) throws InterruptedException {
		Thread.sleep(3000);
		
		employeePage.stepOneEmploymentDetails(role, empid, book, jtitle, empdep, repManager , l2Manager, empemail, doj, loc);
		
	}
	

	@Test(priority = 4)
	public void addEmployeeStep2() throws InterruptedException {
		Thread.sleep(3000);
		employeePage.stepTwoEmploymentDetails("Jyothi", "sai", "Sunkara", "Female", "jyothi@gmail.com", "2345678901", "2345678902", "Married");
	}


}

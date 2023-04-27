package com.qa.skioffice.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.skioffice.base.BaseTest;

public class EmployeePageTest extends BaseTest {

	@BeforeClass
	public void employeeSetup() throws InterruptedException {

		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void employeeTabClick() throws InterruptedException {
		Thread.sleep(6000);

		employeePage.employeeTabClick();

	}
	@Test(priority =2) 
	public void EmployeesCount() throws InterruptedException{ 
		Thread.sleep(2000); 
		String ActiveEmployees = employeePage.gettotalActiveEmployeesCount();
		System.out.println("ActiveEmployees Count: "+ActiveEmployees);
		
		String TotalEmployees = employeePage.gettotalEmployeesCount();
		System.out.println("Total Employees Count: "+TotalEmployees);
		
		String InactiveEmployees = employeePage.gettotalInactiveEmployeesCount();
		System.out.println("Inactive Employees Count: "+InactiveEmployees);
		
		String ExitedEmployees = employeePage.gettotalExitedEmployeesCount();
		System.out.println("Exited Employees Count: "+ExitedEmployees);
	 
	 }

}

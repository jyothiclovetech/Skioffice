package com.qa.skioffice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.skioffice.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SanityTest  extends BaseTest{
	
	
	@BeforeClass
	public void employeeSetup() throws InterruptedException {
		Thread.sleep(4000);
		dashboardPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Thread.sleep(4000);
	}
	public void MyTimesheetsTab() {
		//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, myTimesheetsTab);
//		eleUtil.doClick(myTimesheetsTab);
		
		WebElement e = driver.findElement(By.xpath("//a[text()=('Reporting Manager')]"));
		e.click();
	}
	
	@Description("Verify links test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority =1)
		
	public void VerifyLinks() throws InterruptedException {
		try
		{
		Thread.sleep(5000);
		MyTimesheetsTab();
		Thread.sleep(1000);
		dashboardPage.ReportingManagerTab();
		Thread.sleep(1000);
		dashboardPage.L2ManagerTab();
		Thread.sleep(1000);
		dashboardPage.AllTimesheetsTab();
		Thread.sleep(1000);
		dashboardPage.ExpressEntryTab();
		Thread.sleep(1000);
		dashboardPage.UserManagementTab();
		Thread.sleep(1000);
		dashboardPage.UserRolesTab();
		Thread.sleep(1000);
		dashboardPage.UserPrivilegesTab();
		Thread.sleep(1000);
		dashboardPage.UserInvitationTab();
		Thread.sleep(1000);
		dashboardPage.EmployeesTab();
		Thread.sleep(1000);
		dashboardPage.CostCentresTab();
		Thread.sleep(1000);
		dashboardPage.DepartmentsTab();
		Thread.sleep(1000);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

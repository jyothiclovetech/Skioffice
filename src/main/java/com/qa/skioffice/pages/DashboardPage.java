package com.qa.skioffice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.skioffice.constants.Constants;
import com.qa.skioffice.utils.ElementUtil;

import io.qameta.allure.Step;

public class DashboardPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
//private by locator
	
	private By timesheetsTab = By.xpath("//a[@id='Timesheets']");
	private By myTimesheetsTab = By.xpath("//a[text()=('My Timesheets')]");
	private By reportingManagerTab = By.xpath("//a[text()=('Reporting Manager')]");
	

	private By l2ManagerTab = By.xpath("//a[@id='L2 Manager']");
	private By allTimesheetsTab = By.xpath("//a[@id='All Timesheets']");
	private By expressEntryTab = By.xpath("//a[@id='Express Entry']");
	
	private By userManagementTab = By.xpath("//a[@id='User Management']");
	private By userRolesTab = By.xpath("//a[@id='User Roles']");
	private By userPrivilegesTab = By.xpath("//a[@id='User Privileges']");
	private By userInvitationTab = By.xpath("//a[@id='User Invitation']");
	
	private By employeesTab = By.xpath("//a[@id='Employees']");
	
	private By costCentresTab = By.xpath("//a[@id='Cost Centres']");
	
	private By departmentsTab = By.xpath("//a[@id='Departments']");
	
	//page constructor
	
		public DashboardPage(WebDriver driver){
			
			this.driver = driver;
			eleUtil = new ElementUtil(this.driver);
		}
		
		@Step("Clcik on My Time sheets Tab Link")
		public void MyTimesheetsTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, myTimesheetsTab);
//			eleUtil.doClick(myTimesheetsTab);
			
			WebElement e = driver.findElement(By.xpath("//a[@id='Reporting Manager']"));
			e.click();
		}
		
		@Step("Clcik on Time sheets Tab Link")
		public void TimesheetsTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, timesheetsTab);
			eleUtil.doClick(timesheetsTab);
		}
		
		@Step("Clcik on Reporting Manager Tab Link")
		public void ReportingManagerTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, reportingManagerTab);
			eleUtil.doClick(reportingManagerTab);
			
			
		}
		
		@Step("Clcik on My Time sheets Tab Link")
		public void L2ManagerTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, l2ManagerTab);
			eleUtil.doClick(l2ManagerTab);
		}
		
		@Step("Clcik on All Time sheets Tab Link")
		public void AllTimesheetsTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, allTimesheetsTab);
			eleUtil.doClick(allTimesheetsTab);
		}
		
		@Step("Clcik on Express Entry Tab Link")
		public void ExpressEntryTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, expressEntryTab);
			eleUtil.doClick(expressEntryTab);
		}
		
		@Step("Clcik on User Management Tab Link")
		public void UserManagementTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, userManagementTab);
			eleUtil.doClick(userManagementTab);
		}
		
		@Step("Clcik on User Roles Tab Link")
		public void UserRolesTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, userRolesTab);
			eleUtil.doClick(userRolesTab);
		}
		@Step("Clcik on User Privileges Tab Link")
		public void UserPrivilegesTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, userPrivilegesTab);
			eleUtil.doClick(userPrivilegesTab);
		}
		@Step("Clcik on User Invitation Tab Link")
		public void UserInvitationTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, userInvitationTab);
			eleUtil.doClick(userInvitationTab);
		}
		
		@Step("Clcik on Employees Tab Link")
		public void EmployeesTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, employeesTab);
			eleUtil.doClick(employeesTab);
		}
		@Step("Clcik on Cost Centres Tab Link")
		public void CostCentresTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, costCentresTab);
			eleUtil.doClick(costCentresTab);
		}
		@Step("Clcik on User Invitation Tabb Link")
		public void DepartmentsTab() {
			//eleUtil.waitForElementToBeClickable(Constants.Default_Time_out, departmentsTab);
			eleUtil.doClick(departmentsTab);
		}

		
	
	

}

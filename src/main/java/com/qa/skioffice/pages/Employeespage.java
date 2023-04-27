package com.qa.skioffice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.skioffice.constants.Constants;
import com.qa.skioffice.utils.ElementUtil;

public class Employeespage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By timeSheet = By.xpath("//a[@class='list-item-active']");
	private By employees = By.xpath("//i[@class='fa fa-users mr-3']");
	//private By employees = By.xpath("//span[contains(text(),'Employees')]");
	private By totalEmployeesCount = By.xpath("(//div[@class='row align-items-center d-flex']//h2)[1]");
	private By totalActiveEmployeesCount = By.xpath("(//div[@class='row align-items-center d-flex']//h2)[2]");
	private By totalInactiveEmployeesCount = By.xpath("(//div[@class='row align-items-center d-flex']//h2)[3]");
	private By totalExitedEmployeesCount = By.xpath("(//div[@class='row align-items-center d-flex']//h2)[4]");
	private By addEmployee = By.xpath("//button[text()='Add Employee']");
	
	//EmploymentDetails--Step1
	private By roleDropdown = By.xpath("//select[@placeholder='Select Role']");
	private By employeeId = By.xpath("//input[@placeholder='Employee Id']");
	private By jobTitleDropdown = By.xpath("//select[@placeholder='Select Job Title']");
	private By employeeDepartmentDropdown = By.xpath("//select[@placeholder='Select Employee Deparment']");
	private By reportingManagerDropdown = By.xpath("//select[@placeholder='Select Reporting Manager']");

	//private By reportingManagerDropdown = By.xpath("(//select[@placeholder='Select Employee Deparment'])[2]");

	private By l2ManagerDropdown = By.xpath("//select[@placeholder='Select L2 Manager']");	
	//private By l2ManagerDropdown = By.xpath("(//select[@placeholder='Select Employee Deparment'])[3]");
	
	private By email = By.xpath("//input[@placeholder='Email']");
	private By dateOfJoining = By.xpath("//input[@placeholder='DD-MM-YYYY']");
	private By datePicker = By.xpath("//td[@class='ng-star-inserted']//span[@class='ng-star-inserted']");
	private By location = By.xpath("//input[@placeholder='Location']");
	private By bookedAs = By.xpath("//input[@placeholder='Booked As']");
	private By employmentDetailsSubmitButton  = By.xpath("//input[@value='Submit']");
	
	//PersonalDetails--Step2
	
	private By firstName = By.xpath("//input[@placeholder='First Name']");
	private By middleName = By.xpath("//input[@placeholder='Middle Name']");
	private By lastName  = By.xpath("//input[@placeholder='Last Name']");
	private By gender= By.xpath("//select[@id='gender']");
	private By notificationEmail = By.xpath("//input[@placeholder='Notification Email']");
	private By contactPhoneNumber = By.xpath("//input[@placeholder='Contact Phone Number']");
	private By alternativeContactPhoneNumber = By.xpath("//input[@placeholder='Alternative Contact Phone Number']");
	private By maritalStatus = By.xpath("//select[@id='martialStatus']");
	private By personalDetailsSubmitButton  = By.xpath("//button[text()='Save']");
	
	
		
	
	//page constructor
	
		public Employeespage(WebDriver driver){
			
			this.driver = driver;
			eleUtil = new ElementUtil(this.driver);
		}
		
		//page action
		
		public void employeeTabClick() {
			
			//eleUtil.clickWhenReady(Constants.Default_Element_Time_out,timeSheet );
			eleUtil.doActionsCick(employees);
			//eleUtil.clickWhenReady(Constants.Default_Element_Time_out, employees);
			//eleUtil.doClick(employees);
		}
		
		public String gettotalEmployeesCount() {
			
			return eleUtil.doElementGetText(totalEmployeesCount);
		}
		
		public String gettotalActiveEmployeesCount() {
			
			return eleUtil.doElementGetText(totalActiveEmployeesCount);
		}
		public String gettotalInactiveEmployeesCount() {
			
			return eleUtil.doElementGetText(totalInactiveEmployeesCount);
		}
		public String gettotalExitedEmployeesCount() {
			
			return eleUtil.doElementGetText(totalExitedEmployeesCount);
		}
		public void addEmployee() {
			
			eleUtil.doClick(addEmployee);
		}
		
		public Employeespage stepOneEmploymentDetails(String role, String empid,String book,
		String jtitle, String empdep, String repManager, String l2Manager, String empemail, String doj, String loc) throws InterruptedException {
			Thread.sleep(3000);
			//eleUtil.waitForElementsVisible(roleDropdown,Constants.Default_Element_Time_out);
			eleUtil.doSelectDropDownByVisibleText(roleDropdown, role);
			eleUtil.doSendKeys(employeeId, empid);
			//eleUtil.waitForElementsVisible(jobTitleDropdown,Constants.Default_Element_Time_out);
			eleUtil.doSelectDropDownByVisibleText(jobTitleDropdown, jtitle);
			//eleUtil.waitForElementsVisible(employeeDepartmentDropdown,Constants.Default_Element_Time_out);
			eleUtil.doSelectDropDownByVisibleText(employeeDepartmentDropdown, empdep);
			//eleUtil.waitForElementsVisible(reportingManagerDropdown,Constants.Default_Element_Time_out);
			//eleUtil.doClick(reportingManagerDropdown);
			eleUtil.doSelectDropDownByValue(reportingManagerDropdown, repManager);
			eleUtil.doClick(l2ManagerDropdown);
			eleUtil.doSelectDropDownByValue(l2ManagerDropdown, l2Manager);
			eleUtil.doClick(email);
			eleUtil.doSendKeys(email, empemail);			
			
			eleUtil.doClick(dateOfJoining);
			Thread.sleep(1000);
			//default 2nd date
			eleUtil.datePicker(datePicker);
			
			//eleUtil.doSendKeys(dateOfJoining, doj);
			
			eleUtil.doSendKeys(location, loc);
			eleUtil.doSendKeys(bookedAs, book);
			Thread.sleep(1000);
			eleUtil.doClick(employmentDetailsSubmitButton);
			
			return new Employeespage(driver);
			
		}
		
		public Employeespage stepTwoEmploymentDetails(String fname,String mname,
				String lname, String genderValue, String nemail, String pnumber, String altnumber, String mstatus ) {
			
			eleUtil.doElementIsDisplayed(firstName);
			eleUtil.doSendKeys(firstName, fname);
			eleUtil.doSendKeys(middleName, mname);
			eleUtil.doSendKeys(lastName, lname);
			
			eleUtil.doSelectDropDownByVisibleText(gender, genderValue);
			eleUtil.doSendKeys(notificationEmail, nemail);
			eleUtil.doSendKeys( contactPhoneNumber, pnumber);
			eleUtil.doSendKeys(alternativeContactPhoneNumber, altnumber);
			eleUtil.doSelectDropDownByVisibleText(maritalStatus, mstatus);
			
			return new Employeespage(driver);
		}
		
		
		
		
		

}

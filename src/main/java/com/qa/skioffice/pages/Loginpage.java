package com.qa.skioffice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.skioffice.constants.Constants;
import com.qa.skioffice.utils.ElementUtil;

import io.qameta.allure.Step;

public class Loginpage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//private by locator
	
	private By emailId = By.xpath("//input[@id='loginEmailId']");
	private By password = By.xpath("//input[@id='loginPassword']");
	private By loginBtn = By.xpath("//button[text()='LOGIN']");
	private By logo = By.xpath("//img[@class='prutechlogo']");
	private By forgotPwdLink = By.xpath("//span[text()='Reset Now']");
	
	private By resetPasswordEmail = By.xpath("//input[@id='loginEmailId']");
	private By resetEmailIdSave  = By.xpath("//button[text()='Submit']");
	private By resetEmailIdBack = By.xpath("//button[text()='Back']");
	

	//page constructor
	
	public Loginpage(WebDriver driver){
		
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	//page action
	
	@Step("Getting Login Page Title ")
	
	public String getLoginPageTitle() {
		
		return eleUtil.waitForTitleIsAndFetch(Constants.Default_Time_out, Constants.LOGIN_PAGE_TITLE);
			
	
	}
	
	@Step("Getting Login Page URL")	
public String getLoginPageUrl() {
		return eleUtil.waitForURLContainsAndFetch(Constants.Default_Time_out, Constants.LOGIN_PAGE_URL_FRACTION);

	}
	
	@Step("Enter Usernmae: {0} and Pwd: {1} then click on Login button")

//public MyTimeSheetspage doLogin(String un, String pwd) {
	public DashboardPage doLogin(String un, String pwd) throws InterruptedException{	
	
	//public void doLogin(String un, String pwd) throws InterruptedException {	
	
    Thread.sleep(3000);
	eleUtil.doSendKeys(emailId, un);
	eleUtil.doSendKeys(password, pwd);
	eleUtil.doClick(loginBtn);
	//return new Employeespage(driver);
	
	//return new MyTimeSheetspage(driver);
	
	return new DashboardPage(driver);
	
}

	@Step("Verify Forgot Pwd Link Exist")
public boolean isForgotPwdLinkExist() {
	
	return eleUtil.doElementIsDisplayed(forgotPwdLink);
}

	@Step("Clcik on Forgot Pwd Link")
public void ForgotPwdLinkClick() {
	
	eleUtil.doActionsCick(forgotPwdLink);
}

	@Step("Get Reset Password Page Title")
public String getResetPasswordPageTitle() {
	
		return 	eleUtil.waitForTitleIsAndFetch(Constants.Default_Time_out, Constants.ResetPassword_Page_Title);

}
	
	@Step("Send email to Reset Password")
public void sendLinkToResetYourPassword(String un ) throws InterruptedException{
	
		eleUtil.waitForElementVisible(resetPasswordEmail, Constants.Default_Element_Time_out).sendKeys(un);
	Thread.sleep(1000);
	eleUtil.doClick(resetEmailIdSave);
}

	@Step("Navigate back from Reset Password Page to login page")
public void cancleLinkToResetYourPassword(String un ) throws InterruptedException{
	
		eleUtil.waitForElementVisible(resetPasswordEmail, Constants.Default_Element_Time_out).sendKeys(un);
	Thread.sleep(1000);
	eleUtil.doClick(resetEmailIdBack);
}


		
public boolean isLogoExist() {
	
	return eleUtil.doElementIsDisplayed(logo);
}

	
}

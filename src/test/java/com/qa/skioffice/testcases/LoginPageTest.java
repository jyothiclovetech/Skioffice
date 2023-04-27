package com.qa.skioffice.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.skioffice.base.BaseTest;
import com.qa.skioffice.constants.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic is for login SkiOffice")
@Story("Login & Send Forgot PWd Link")

public class LoginPageTest extends BaseTest {
	
	@Description("loginPage Title test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority =1)
	
	public void loginPageTitleTest() {
		
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("login page title: " +actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Verify forgot PwdLink test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority =3)
	
	public void forgotPwdLinkExist(){
		
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());		
		
	}
	
	@Description("Verify login test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority =2)
	
	public void loginTest() throws InterruptedException{
		
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
				
	}

	@Description("Send forgot PwdLink email test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority =4)
	
	public void resetPwdTest() throws InterruptedException{
		loginPage.ForgotPwdLinkClick();
		//loginPage.getResetPasswordPageTitle();
		//System.out.println(loginPage.getResetPasswordPageTitle());
		loginPage.sendLinkToResetYourPassword(prop.getProperty("username").trim());
				
		
	}
	
	
	
	
}

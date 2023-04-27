package com.qa.skioffice.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.skioffice.base.BaseTest;
import com.qa.skioffice.constants.Constants;

public class MyTimesheetPageTest extends BaseTest {

	@BeforeClass
	public void timeSheetSetup() {
		
	//	myTimeSheetPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

	@Test
	public void myTimeSheetsURLTest() {
		String mytsURL = myTimeSheetPage.getMyTimeSheetURL();
		System.out.println("myTimeSheetPage URL: " + mytsURL);
		Assert.assertTrue(mytsURL.contains(Constants.My_TimeSheet_URL));

	}

	
	  @Test
	  
	  public void loginUser() throws InterruptedException {
	  
	  Assert.assertEquals(myTimeSheetPage.getLoginUser(),Constants.My_TimeSheet_User); }
	 

	/*
	 * @Test
	 * 
	 * public void defaultSectionTest() {
	 * 
	 * List<String> defaultSecList = myTimeSheetPage.getDefaultPageSectionList();
	 * System.out.println("Section list: " + defaultSecList);
	 * Assert.assertEquals(defaultSecList, Constants.Expected_Default_Section_List);
	 * 
	 * }
	 */

}

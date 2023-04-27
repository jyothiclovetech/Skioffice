package com.qa.skioffice.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	public final static String LOGIN_PAGE_TITLE = "Skioffice";
	public final static String LOGIN_PAGE_URL_FRACTION = "http://35.154.34.230:4006/#/login";
	
	
	public static final int Default_Time_out = 5;
	public static final int Default_Element_Time_out = 10;
	
	public static final String My_TimeSheet_User = "Hemanth Munagala";
	public static String My_TimeSheet_URL = "http://35.154.34.230:4006/#/time-management/time-sheet";
	public static final List<String> Expected_Default_Section_List = 
			Arrays.asList("Timesheets",
					"User Management",
					"Employees",
					"Cost Centres",
					"Departments");
	
	//********* SheetName ******
	
	public static final String AddEmployee_Sheet_Name = "AddEmployee1";
	public static final String ResetPassword_Page_Title = "Reset Your Password";
						
}

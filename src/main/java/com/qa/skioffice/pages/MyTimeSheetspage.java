package com.qa.skioffice.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import com.qa.skioffice.constants.Constants;
import com.qa.skioffice.utils.ElementUtil;

public class MyTimeSheetspage {
	
	public static final boolean getMyTimeSheetURL = false;
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By loginUser = By.xpath("//*[@class='text-label']");
	private By sectionHeaders = By.xpath("//*[@id='sidebar']/ul ");
	
	
	
	public MyTimeSheetspage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	
	}
	
	public  String getMyTimeSheetURL() {
		 return eleUtil.waitForURLContainsAndFetch(Constants.Default_Time_out, Constants.My_TimeSheet_URL);
	}
	
	public String getLoginUser() throws InterruptedException {
		Thread.sleep(2000);
		return eleUtil.doElementGetText(loginUser);
		
		}
	public List<String> getDefaultPageSectionList() {
		
		List<WebElement> list =eleUtil.getElements(sectionHeaders);
		List<String> secValList = new ArrayList<String>();
		for(WebElement e:list ) {
			String text = e.getText();
			secValList.add(text);			
		}
		return secValList;
	}
	
	
	
	
	

}

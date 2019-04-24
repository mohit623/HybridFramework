package com.testSelenium.hybrid.suitea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Properties;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testSelenium.hybrid.base.BaseTest;
import com.testSelenium.hybrid.driver.DriverScript;
import com.testSelenium.hybrid.util.DataUtil;
import com.testSelenium.hybrid.util.Xls_Reader;

public class LoginTest extends BaseTest {
	
	
	

	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String,String> Data) {
		
		if(Data.get("Runmode").equals("N")) {
			throw new SkipException("Runmode is set to N");
		}
		System.out.println("Running Login Test");	
		
		ds = new DriverScript();
		ds.executeKeywords(testName, xls, Data);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		
		// find row number of the test
		return DataUtil.getTestData(testName, xls);
			}

}

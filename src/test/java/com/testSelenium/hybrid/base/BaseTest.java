package com.testSelenium.hybrid.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.testSelenium.hybrid.driver.DriverScript;
import com.testSelenium.hybrid.util.Xls_Reader;

public class BaseTest {

	public Properties envProp;
	public Properties prop;
	public Xls_Reader xls;
	public String testName;
	public DriverScript ds;
	
	@BeforeTest()
	public void init() {
		testName=this.getClass().getSimpleName();
		System.out.println(testName);
		String arr[]=this.getClass().getPackage().getName().split("\\.");
		String suiteName=arr[arr.length-1];
	  System.out.println("Before Running Test");
	 
	  prop=new Properties();
	  envProp=new Properties();
	  
	  try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//env.properties");
			
			prop.load(fis);
			String env = prop.getProperty("env");
			fis= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//"+env+".properties");
			envProp.load(fis);
			System.out.println(envProp.getProperty("url"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  xls = new Xls_Reader(envProp.getProperty(suiteName+"_xls"));
	  ds=new DriverScript();
	  ds.setEnvProp(envProp);
	  ds.setProp(prop);


	  
		
	}
	
}

package com.testSelenium.hybrid.driver;

import java.util.Hashtable;
import java.util.Properties;

import com.testSelenium.hybrid.keywords.AppKeywords;
import com.testSelenium.hybrid.util.Xls_Reader;

public class DriverScript {
	
	
	public Properties prop;
	public Properties envProp;
	
	
	public void setProp(Properties prop) {
		this.prop = prop;
	}


	public void setEnvProp(Properties envProp) {
		this.envProp = envProp;
	}


	public void executeKeywords(String testName,Xls_Reader xls,Hashtable<String, String> testdata)
	{
		
		int rowcount=xls.getRowCount("Keywords");
		System.out.println(prop.getClass());
		
		
		
		for(int rNum=2;rNum<=rowcount;rNum++) {
			String tcid =xls.getCellData("Keywords", "TCID", rNum);
			if(tcid.equals(testName)) {
				String keyword =xls.getCellData("Keywords", "Keyword", rNum);
				String Objectkey =xls.getCellData("Keywords", "Object", rNum);
				String dataKey =xls.getCellData("Keywords", "Data", rNum);
				
				
				System.out.println(prop.getProperty("url"));
				
				System.out.println(tcid+"--"+keyword+"--"+prop.getProperty(Objectkey)+"--"+testdata.get(dataKey));	
			
			if(keyword.equals("openBrowser")) {
				
			}
			else if(keyword.equals("navigate")) {
			
			}
			
			else if(keyword.equals("click")) {
				
			}
			
			else if(keyword.equals("type")) {
				
			}
			
			else if(keyword.equals("validateLogin")) {
				
			}
			
			}
			
			
			
		}
	}

}

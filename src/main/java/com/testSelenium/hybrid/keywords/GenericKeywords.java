package com.testSelenium.hybrid.keywords;

import java.util.Hashtable;
import java.util.Properties;

public class GenericKeywords {
	
	public Properties prop;
	public Properties envProp;
	public String datakey;
	public String objectkey;
	public Hashtable<String,String> data;
	
	
	
	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void setEnvProp(Properties envProp) {
		this.envProp = envProp;
	}

	public void setDatakey(String datakey) {
		this.datakey = datakey;
	}

	public void setObjectkey(String objectkey) {
		this.objectkey = objectkey;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}

	public void openBrowser() {
		
		System.out.println("opening browser "+ data.get(objectkey));
		
	}

	public void navigate() {
		
		System.out.println("navigating "+prop.getProperty(datakey) );
			
		}
	
	public void click() {
		
		System.out.println("clicking "+ prop.getProperty(datakey));
	}
	
	public void type() {
		
		System.out.println("typing in "+prop.getProperty(datakey)+" with data -"+data.get(objectkey));
	}
}

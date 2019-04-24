package com.testSelenium.hybrid.util;

import java.util.Hashtable;

public class DataUtil {

	
	public static Object[][] getTestData(String testName,Xls_Reader xls){
int testStartRowNum=1;
		
		while(!xls.getCellData("Data", 0, testStartRowNum).equalsIgnoreCase(testName))
		{
			testStartRowNum++;
			
		}
		
		System.out.println("Test case start at rownum: "+testStartRowNum);
		//find the number of columns
		
		int totalNumofColumns=0;
		while(!xls.getCellData("Data",totalNumofColumns, testStartRowNum+1).equals("")) {
			totalNumofColumns++;
		}
		
		System.out.println("Total number of columns are: "+totalNumofColumns);
		
		//find the number of rows
		int totalDataRows=0;
		int dataStartRow=testStartRowNum+2;
		while(!xls.getCellData("Data",0, dataStartRow).equals("")) {
			totalDataRows++;
			dataStartRow++;
		}
		
		System.out.println("Total number of Data Rows are: "+totalDataRows);
		
		//read the data
		
		Hashtable<String,String> table=null;
		Object[][] mydata=new Object[totalDataRows][1];
		int i=0;
		for(int rNum=testStartRowNum+2;rNum<testStartRowNum+2+totalDataRows;rNum++) {
			table=new Hashtable<String, String>();
			for(int cNum=0;cNum<totalNumofColumns;cNum++) {
				
				String data= xls.getCellData("Data", cNum, rNum);
				String key=xls.getCellData("Data", cNum, testStartRowNum+1);
				//System.out.println(key+"----"+data);
				table.put(key, data);
				
				
			}
			//System.out.println(table);
			mydata[i][0]=table;
			System.out.println(mydata[i][0]);
			i++;
			System.out.println("---------------------");
		}
		return mydata;

	}
}

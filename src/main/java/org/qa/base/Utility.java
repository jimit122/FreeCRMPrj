package org.qa.base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.qa.data.UserTestData;

import com.google.gson.Gson;

public class Utility {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT_TIME = 30;
	public static String TESTDATA_FILE_PATH = ".\\src\\main\\resources\\CRMTestData.xlsx";
	public static String TESTDATA_USER_JSON = ".\\src\\main\\resources\\CRMTestData.json";
	private static List<UserTestData> userList;
	
	public static String readProperties(String property) {
		Properties prop = new Properties();
		try {
			InputStream fs = new FileInputStream(".\\src\\main\\resources\\application.properties");
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(property);
	}
	public static Object[][] readTestData(String sheetName) {
		Workbook book;
		Sheet sheet;
		Object [][]data = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_FILE_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = new XSSFWorkbook(file);
			sheet = book.getSheet(sheetName);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i=0; i< sheet.getLastRowNum(); i++) {
				for (int k = 0; k <sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return data;
	}
	public static List<UserTestData> JsonDataReader(){
		 userList = getUserTestData();
		return userList;
	}
	public static List<UserTestData> getUserTestData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(TESTDATA_USER_JSON));
			UserTestData[] userData = gson.fromJson(bufferReader, UserTestData[].class);
			return Arrays.asList(userData);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + TESTDATA_USER_JSON);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
}
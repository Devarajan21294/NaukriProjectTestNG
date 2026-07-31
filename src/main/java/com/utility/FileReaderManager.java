package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Properties;

import org.testng.Assert;



public class FileReaderManager {
	private static FileInputStream fileInputStream;
	private static Properties property;
	
	public static void setupProperty() {
		File file= new File("C:\\Users\\admin\\eclipse-workspace\\NAUKRI_PROJECT\\src\\main\\resources\\TestData.properties");
		try {
			fileInputStream= new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
System.out.println("ERROR: OCCUR DURING FILE LOADING");
			e.printStackTrace();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING FILE READING");
			e.printStackTrace();
		}

		
	}
	public static String getProperty(String value) {
		setupProperty();
String data = property.getProperty(value);
return data;
	}
	public static void main(String[] args) {
		System.out.println(getProperty("title"));
	}
	

}

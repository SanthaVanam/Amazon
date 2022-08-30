package com.Amazon.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigAmazon {
	Properties pro;
	
	public ReadConfigAmazon()
	{
		File file = new File("./Configuration/Config.properties");
		FileReader fis;
		try {
			fis = new FileReader(file);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String getBaseUrl()
	{
		String baseURL = pro.getProperty("baseURL");
		return baseURL;
	}
	
	public String getUserName() {
		String username = pro.getProperty("username");
		return username;
		
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
		
	}

}

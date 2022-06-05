package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public  ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	public String getUrl() {
		String url = pro.getProperty("url");
		return url;
	}
	
	public String getUname() {
		String uname= pro.getProperty("uname");
		return uname;
	}
	
	public String getPwd() {
		String pwd= pro.getProperty("pwd");
		return pwd;
	}
	
	public String getBrowser() {
		String browser =pro.getProperty("browser");
		return browser;
	}
}

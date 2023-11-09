package com.bellatrix.config;

import java.io.FileNotFoundException;

import com.bellatrix.utilities.FileUtil;




public class Configration extends FileUtil{
	FileUtil file = new FileUtil();
	
	public String getAppURl() throws FileNotFoundException {
	//	FileUtil file = new FileUtil();
		// app.url store in src/main /resources
	return file.getProperty("/src/main/resources/config.properties", "app.url")	;
	
	}
	public String getMyntraAppUrl()throws FileNotFoundException{
	
	return	file.getProperty("/src/main/resources/config.properties", "myntra.url");
	}
	public String getBrowserName() {
		
	return file.getConfiguration("browser_name");
	
}
	public String getExicutionMode() {
		return file.getProperty("/src/main/resources/config.properties", "exicution_mode");
		
		
		
	}
}
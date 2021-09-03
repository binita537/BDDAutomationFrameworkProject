package com.qabddautomation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties properties;

	/**
	 * This Method use to load config.properties file
	 * 
	 * @return
	 */
	public  static Properties initPropertiesFromConfigFile() {

		properties = new Properties();
		try {
			FileInputStream fileinputstream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/propertiesfiles/Config.properties");
			properties.load(fileinputstream);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return properties;

	}
	
	

	
	
}

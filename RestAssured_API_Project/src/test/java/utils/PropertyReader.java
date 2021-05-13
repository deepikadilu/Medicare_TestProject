package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	String value;
	public String getPropertyValue(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("C:/Users/ADMIN/eclipse-workspace/RestAssured.APITest/src/test/resources/utils/data.properties"))));
		
		value=prop.getProperty(key);
		return value;
	}
	
}

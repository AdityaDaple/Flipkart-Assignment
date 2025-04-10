package baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigrationManager {

	
	public static Properties prop ;
	
	public static String getProperty(String key) {
		
	String filePath =System.getProperty("user.dir")+ "\\Configration\\config.properties"	;
		
	try {
		FileInputStream fis = new FileInputStream(filePath);
		prop= new	Properties ();
		  prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String s1=prop.getProperty(key);
	return s1;
	}
	
}

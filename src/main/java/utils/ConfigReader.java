package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties initilizePropFile() throws IOException {
		
		Properties prop = new Properties();
		File propFile =  new File(System.getProperty("user.dir")+"/src/test/resource/config/config.properties"); 
		FileInputStream fip = new FileInputStream(propFile);
		prop.load(fip);
		return prop;
	}

}

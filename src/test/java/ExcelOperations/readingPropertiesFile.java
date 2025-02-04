package ExcelOperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class readingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//location of the property file
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Exceldata\\config.properties");

		
		//load property file
		Properties obj=new Properties();
		obj.load(file);
		
		
		//Read data from property file
		String URL=obj.getProperty("URL");
		String email=obj.getProperty("email");
		String pwd=obj.getProperty("password");
		String oid=obj.getProperty("orderid");
		String cusid=obj.getProperty("customerid");
		
		System.out.println(URL+" "+email+" "+pwd+" "+oid+" "+cusid);
		
		
		//Read only keys from properties file
		// Method 1
		Set<String> key=obj.stringPropertyNames();
		System.out.println(key);
		
		// Method 2
		Set<Object> keys=obj.keySet();
		System.out.println(keys);
		
		
		//Reading all the values from property file
		Collection<Object> object=obj.values();
		System.out.println(object);
		
	}

}

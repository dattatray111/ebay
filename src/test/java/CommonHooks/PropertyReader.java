package CommonHooks;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	public static String getProperty(String propName) {
		FileInputStream fileInput = null;
		String value = null;
		try {
			
			String filename = "./src/test/resources/config.properties";
			fileInput = new FileInputStream(filename);
			Properties properties = new Properties();
			properties.load(fileInput);
			value = properties.getProperty(propName);
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
		} 
		finally {
			if (fileInput != null) {
				try {
					fileInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return value;
	}
}

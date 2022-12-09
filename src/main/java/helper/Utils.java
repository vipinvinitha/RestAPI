package helper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import io.restassured.response.Response;

public class Utils {
	String path = "src/main/resources/Constants.properties";

	public String loadProperties(String property) {
		Properties prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(path);

			// load a properties file

			prop.load(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop.getProperty(property);
	}

	public Utils set_path(String path2) {
		path = path2;
		return this;
	}

	public boolean assertStatusCode(Response res, int code) {
		if (res.getStatusCode() == code) {
			return true;
		} else
			return false;
	}
}

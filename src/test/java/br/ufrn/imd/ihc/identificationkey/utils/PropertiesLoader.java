package br.ufrn.imd.ihc.identificationkey.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

	private static Properties prop = new Properties();
	private static InputStream input = null;

	public PropertiesLoader() {
		try {
			input = PropertiesLoader.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}

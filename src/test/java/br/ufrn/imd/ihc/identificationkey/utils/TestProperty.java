package br.ufrn.imd.ihc.identificationkey.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperty {

	private static final String FILE_NAME = "selenium.properties";

	public static Properties getTestProperties() {
		Properties prop = new Properties();
		InputStream input;

		try {
			input = TestProperty.class.getResourceAsStream("/" + FILE_NAME);
			if (input != null) {
				prop.load(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static String getBaseUrl() {
		String baseUrl = getTestProperties().getProperty("test.environment.url");
		return baseUrl;
	}

}

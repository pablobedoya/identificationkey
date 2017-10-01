package br.ufrn.imd.ihc.identificationkey.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IdentificationKeyProperties {

	private static final String FILE_NAME = "config.properties";

	public static Properties getIdentificationKeyProperties() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = IdentificationKeyProperties.class.getResourceAsStream("/" + FILE_NAME);
			if (input != null) {
				prop.load(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static String getUrl() {
		String url = getIdentificationKeyProperties().getProperty("url");
		return url;
	}

}

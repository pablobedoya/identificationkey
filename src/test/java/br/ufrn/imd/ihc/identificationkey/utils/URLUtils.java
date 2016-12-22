package br.ufrn.imd.ihc.identificationkey.utils;

public class URLUtils {

	public static String getContextPath() {
		new PropertiesLoader();
		return PropertiesLoader.getProperty("baseURL");
	}

}

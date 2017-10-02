package br.ufrn.imd.ihc.identificationkey.utils;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	public static Properties prop = new Properties();

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	private static ExtentReports extent = ExtentManager.getExtent();

	public synchronized static ExtentTest getTest() {
		return extentTest.get();
	}

	public synchronized static ExtentTest createTest(String name, String description, String deviceId) {
		ExtentTest test = extent.createTest(name, description);

		if (deviceId != null && !deviceId.isEmpty())
			test.assignCategory(deviceId);

		extentTest.set(test);

		return getTest();
	}

	public synchronized static ExtentTest createTest(String name, String description) {
		return createTest(name, description, String.valueOf(Thread.currentThread().getId()));
	}

	public synchronized static ExtentTest createTest(String name) {
		return createTest(name, null);
	}

}

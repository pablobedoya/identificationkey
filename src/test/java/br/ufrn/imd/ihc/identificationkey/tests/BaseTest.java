package br.ufrn.imd.ihc.identificationkey.tests;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import br.ufrn.imd.ihc.identificationkey.utils.ExtentManager;
import br.ufrn.imd.ihc.identificationkey.utils.ExtentTestManager;

public class BaseTest {

	private ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	private ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	@BeforeClass
	public synchronized void beforeClass() throws Exception {
		ExtentTest parent = ExtentTestManager.createTest(getClass().getName());
		parentTest.set(parent);
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {
		ExtentTest child = parentTest.get().createNode(method.getName());
		test.set(child);
	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE)
			test.get().fail(result.getThrowable());
		else if (result.getStatus() == ITestResult.SKIP)
			test.get().skip(result.getThrowable());
		else
			test.get().pass("Test passed");

		ExtentManager.getExtent().flush();
	}

}

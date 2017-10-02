package br.ufrn.imd.ihc.identificationkey.utils;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static Properties prop = new Properties();

    private static ExtentReports extent; 
    private static String filePath = System.getProperty("user.dir") + "/target/ExtentReports.html";    

    public synchronized static ExtentReports getExtent() {
        if (extent == null) {
            extent = new ExtentReports();
            extent.attachReporter(getHtmlReporter());
            extent.setSystemInfo("Selenium Java Version", "2.53.0");
            extent.setSystemInfo("Environment", "Prod");
            extent.setSystemInfo("AppiumVersion", "4.0.0");
        }

        return extent;
    }

    private static ExtentHtmlReporter getHtmlReporter() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);

        // make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);

        // report title
        String documentTitle = prop.getProperty("documentTitle", "aventstack - Extent");
        htmlReporter.config().setDocumentTitle(documentTitle);

        // encoding, default = UTF-8
        String encoding = prop.getProperty("encoding", "UTF-8");
        htmlReporter.config().setEncoding(encoding);

        // protocol (http, https)
        String protocol = prop.getProperty("protocol", "https").toUpperCase();
        htmlReporter.config().setProtocol(Enum.valueOf(Protocol.class, protocol));

        // report or build name
        String reportName = prop.getProperty("reportName", "ExtentReports");
        htmlReporter.config().setReportName(reportName);

        // chart location - top, bottom
        String chartLocation = prop.getProperty("chartLocation", "top").toUpperCase();
        htmlReporter.config().setTestViewChartLocation(Enum.valueOf(ChartLocation.class, chartLocation));

        // theme - standard, dark
        String theme = prop.getProperty("theme", "standard").toUpperCase();
        htmlReporter.config().setTheme(Enum.valueOf(Theme.class, theme));

        return htmlReporter;
    }
    
}

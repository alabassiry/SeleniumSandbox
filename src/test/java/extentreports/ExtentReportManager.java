package extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.Utilties;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        Utilties utils = new Utilties();
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport_"+ utils.getRandomString(5) + ".html";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
            htmlReporter.config().setDocumentTitle("Automation Report");
            htmlReporter.config().setReportName("TestNG Project Report");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }
        return extent;
    }
}
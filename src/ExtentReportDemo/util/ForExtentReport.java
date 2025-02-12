package ExtentReportDemo.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForExtentReport {

    public static String bugScreenshot(WebDriver driver) throws IOException {

        // 1. create the object reference of TakesScreenshot
        // assign the driver to it & typecast it into TakesScreenshot

        TakesScreenshot ts  = (TakesScreenshot) driver;

        // 2. call the method getScreenshotAs() using ts
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";

        // 3. convert this file object into a real image file
        FileUtils.copyFile(srcFile , new File("Reports\\screenshot\\"+fileName));

        return fileName;
    }

    public static ExtentReports initExtentReport()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("Stock Management System");
        reporter.config().setReportName("regression testing report");

        extent.setSystemInfo("Project name","Stock Management");
        extent.setSystemInfo("Developed By","Anita");
        extent.setSystemInfo("Testers Name","Shwetha");
        extent.setSystemInfo("Environment","Windows 11 , Chrome latest");
        extent.setSystemInfo("Client name","Infosys");
        extent.setSystemInfo("Expected Date of Completion","23/04/2025");

        return extent;

    }
}

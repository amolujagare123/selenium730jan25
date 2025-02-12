package listenersDemo;

import TestNG.DemoReal.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static ExtentReportDemo.util.ForExtentReport.bugScreenshot;
import static ExtentReportDemo.util.ForExtentReport.initExtentReport;

public class MyExtentReportListener extends Base implements ITestListener
{
    ExtentReports extent;
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
         test = extent.createTest(result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");

        test.pass("This tst is passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
        test.info("this test is failed");
        test.fail(result.getThrowable());
        try {
            test.addScreenCaptureFromPath("./screenshot/"+bugScreenshot(driver));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
        test.info("this test is skipped");
        test.skip(result.getThrowable());
    }

    public void onStart(ITestContext context) {
        System.out.println("onStart");

        if(extent==null)
         extent = initExtentReport();
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish");
        extent.flush();
    }
}

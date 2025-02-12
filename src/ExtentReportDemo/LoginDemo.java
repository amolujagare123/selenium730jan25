package ExtentReportDemo;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ExtentReportDemo.util.ForExtentReport.bugScreenshot;

public class LoginDemo {
    ExtentReports extent;

    @BeforeClass
    public void init()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("Stock Management System");
        reporter.config().setReportName("regression testing report");

        extent.setSystemInfo("Project name","Stock Management");
        extent.setSystemInfo("Developed By","Anita");
        extent.setSystemInfo("Testers Name","Shwetha");
        extent.setSystemInfo("Environment","Windows 11 , Chrome latest");
        extent.setSystemInfo("Client name","Infosys");
        extent.setSystemInfo("Expected Date of Completion","23/04/2025");


    }

    @AfterClass
    public void writeToReport()
    {
        extent.flush();
    }


    @Test
    public  void loginTest1() throws IOException {

        ExtentTest test = extent.createTest("valid credentials");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        test.info("URL is opened");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUsername.sendKeys("admin");

        test.info("Username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin1");
        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();

        test.info("login button is clicked");

        String expected = "Dashboard";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//a[@class='active-tab dashboard-tab']")).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        try {
            Assert.assertEquals(actual, expected, "This is not a dashboard");
            test.pass("test is passed");
        }
        catch (AssertionError e)
        {
            test.fail("this is is failed since:"+e.getMessage());
            test.addScreenCaptureFromPath("./screenshot/"+bugScreenshot(driver));
        }

    }
    @Test
    public  void loginTest2() throws IOException {

        ExtentTest test = extent.createTest("invalid credentials");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        test.info("URL is opened");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUsername.sendKeys("dsds");

        test.info("Username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("dsdsd");
        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();

        test.info("login button is clicked");

        String expected = "Wrong Username or Password";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//div[@class='error-box round']")).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        try {
            Assert.assertEquals(actual,expected,"incorrect or no error message");
            test.pass("test is passed");
        }
        catch (AssertionError e)
        {
            test.fail("this is is failed since:"+e.getMessage());
            test.addScreenCaptureFromPath("./screenshot/"+bugScreenshot(driver));
        }
    }

    @Test
    public  void loginTest3() throws IOException {

        ExtentTest test = extent.createTest("blank credentials");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        test.info("URL is opened");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUsername.sendKeys("dsdsd");

        test.info("Username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("dsdsd");
        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();

        test.info("login button is clicked");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Please enter a username".toUpperCase());
        expected.add("Please provide a password".toUpperCase());

        ArrayList<String> actual = new ArrayList<>();

        try {
            List<WebElement> wbList = driver.findElements(By.xpath("//label[@class='error']"));

            actual.add(wbList.get(0).getText());
            actual.add(wbList.get(1).getText());

        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        try {
            Assert.assertEquals(actual,expected,"incorrect or no error message");
            test.pass("test is passed");
        }
        catch (AssertionError e)
        {
            test.fail("this is is failed since:"+e.getMessage());
            test.addScreenCaptureFromPath("./screenshot/"+bugScreenshot(driver));
        }

    }
}

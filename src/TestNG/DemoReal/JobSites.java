package TestNG.DemoReal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSites {

    WebDriver driver;

    @BeforeClass
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void indeed()
    {
        driver.get("https://www.indeed.com");
    }

    @Test
    public void naukri()
    {
        driver.get("https://www.naukri.com");
    }

    @Test
    public void linkedinJobs()
    {
        driver.get("https://www.linkedin.com/jobs");
    }

    @Test
    public void glassdoor()
    {
        driver.get("https://www.glassdoor.com");
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }
}
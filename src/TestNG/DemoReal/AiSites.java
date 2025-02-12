package TestNG.DemoReal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AiSites extends Base {



    @Test
    public void openai()
    {
        driver.get("https://www.openai.com");
    }

    @Test
    public void huggingface()
    {
        driver.get("https://www.huggingface.co");
    }

    @Test
    public void tensorflow()
    {
        driver.get("https://www.tensorflow.org");
    }

    @Test
    public void pytorch()
    {
        driver.get("https://www.pytorch.org");
    }


}
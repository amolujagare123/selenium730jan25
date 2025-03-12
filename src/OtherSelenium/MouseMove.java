package OtherSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseMove {

    @Test
    public void moveMoveDemo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");

        WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));

        Thread.sleep(2000);

        Actions action = new Actions(driver);
        action.moveToElement(men).build().perform();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='T-Shirts'][@data-reactid='345']"))
                .click();

    }
}

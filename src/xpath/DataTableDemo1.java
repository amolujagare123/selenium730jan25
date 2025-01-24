package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DataTableDemo1 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://editor.datatables.net/examples/simple/inTableControls.html");

       /* JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");*/

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String name = "Ashton Cox";

        driver.findElement(By.xpath("//tr[ td[text()='"+name+"'] ]//i[contains(@class,'pencil')]")).click();
    }
}

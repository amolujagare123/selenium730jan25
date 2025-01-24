package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsDemo1 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        /*WebElement element = driver.findElement(By.tagName("input"));
        element.sendKeys("xyzabcd");*/

        List<WebElement> wbList = driver.findElements(By.tagName("input"));
        System.out.println(wbList.size()); // 3

        wbList.get(0).sendKeys("admin"); // username
        wbList.get(1).sendKeys("admin"); // password
        wbList.get(2).click();
    }
}

package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsDemo3 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/MyProg/multipleElements.html");


        List<WebElement> wbList = driver.findElements(By.className("test-input"));
        System.out.println(wbList.size());

        wbList.get(0).sendKeys("John");            // First Name
        wbList.get(1).sendKeys("Doe");             // Last Name
        wbList.get(2).sendKeys("john.doe@example.com"); // Email
        wbList.get(3).sendKeys("1234567890");      // Phone Number
        wbList.get(4).sendKeys("123 basics.Main Street"); // Address
        wbList.get(5).sendKeys("Springfield");     // City
        wbList.get(6).sendKeys("Illinois");        // State
        wbList.get(7).sendKeys("62704");           // Zip Code
        wbList.get(8).sendKeys("USA");             // Country
        wbList.get(9).sendKeys("Password123");     // Password

    }
}

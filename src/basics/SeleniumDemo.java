package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver(); // upcasting
      //  WebDriver driver = new FirefoxDriver(); // upcasting
     //   WebDriver driver = new EdgeDriver(); // upcasting


        //driver.manage().window().maximize();
        driver.get("https://gmail.com");

        System.out.println(driver.getTitle());
       // System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("http://facebook.com");

        Thread.sleep(4000);

       // driver.close(); // closes current window only
        driver.quit();  // closes all the windows opened by the driver

    }
}

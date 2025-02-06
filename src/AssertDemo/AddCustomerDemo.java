package AssertDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerDemo {
    @Test
    public void  addCustomerTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        // driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.partialLinkText("Add C")).click();

       /* driver.findElement(By.name("name")).sendKeys("Asif");
        driver.findElement(By.name("address")).sendKeys("xyz");
        driver.findElement(By.name("contact1")).sendKeys("787878");
        driver.findElement(By.name("contact2")).sendKeys("767676");
      */  driver.findElement(By.name("Submit")).click();


        String expected = "Please enter a Customer Name".toUpperCase();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//label[@for='name']")).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");


    }

    @Test
    public void  addCustomerTest2()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        // driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.partialLinkText("Add C")).click();

        String name = "Asif2";

       driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("address")).sendKeys("xyz");
        driver.findElement(By.name("contact1")).sendKeys("787878");
        driver.findElement(By.name("contact2")).sendKeys("767676");
        driver.findElement(By.name("Submit")).click();


        String expected = "[ "+name+" ] Customer Details Added !";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//div[contains(@class,'confirmation')]")).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");


    }
}

package com.sqs.cloud9A;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class AppTest 
{

    static WebDriver driver;
    private String registrationSuccessful = "Registration Successful";
    private By bodyTextLocator = By.tagName("body");
    private String cloud9RegisterHeader = "Cloud9 - Register";

    @Before
    public void testSetup() throws InterruptedException {
        System.out.println("In test setup ");
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        String baseUrl = "http://10.9.10.39:81/sqlite/Main/login.html";
        String expectedTitle = "Cloud9 Airlines";
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title is: "+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(5000);
    }

    @BeforeClass
    public static void browserSetup()
    {

    }


    @Test
    public void shouldRegisterNewCustomer()

    {

        driver.findElement(By.xpath("/html/body/div/form/center/a")).click();
        driver.findElement(By.name("firstname")).sendKeys("Arran");
        driver.findElement(By.name("lastname")).sendKeys("Davies");
        driver.findElement(By.name("email")).sendKeys("ah@gmail.com");
        driver.findElement(By.name("password")).sendKeys("2404");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();

        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(registrationSuccessful));
    }

    @Test
    public void shouldLoginCustomer()

    {
      driver.findElement(By.name("email")).sendKeys("ah@gmail.com");
      driver.findElement(By.name("password")).sendKeys("2404");
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
      driver.findElement(By.xpath("/html/body/center[3]/a")).click();
    }

    @After
    public void tearDown()

    {
        //driver.close();
    }

}

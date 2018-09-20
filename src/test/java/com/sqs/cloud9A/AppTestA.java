package com.sqs.cloud9A;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;


public class AppTestA
{

    WebDriver driver;
    private String registrationSuccessful = "Registration Successful";
    private By bodyTextLocator = By.tagName("body");
    private String cloud9RegisterHeader = "Cloud9 - Register";
    String seat = new String ("18A");
    public int bookingID = 319;

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
        driver.findElement(By.linkText("Register")).click();

        registrationObject registrationPage;
        registrationPage = new registrationObject(driver);
        registrationPage.populateRegistration("Arran","Davies", "a@gmail.com","2404");

    }

    @Test
    public void shouldLoginCustomer()

    {

        signinObject signinPage;
        signinPage = new signinObject(driver);
        signinPage.populateSignin("ah@gmail.com", "2404");


    }


    @Test
    public void shouldBookFlight()
    {

        shouldLoginCustomer();
        driver.get("http://10.9.10.39:81/sqlite/Main/bookflight.html");
        bookflightObject bookflightPage;
        bookflightPage = new bookflightObject(driver);
        bookflightPage.populateBookflight( "Durban", "Chicago", "18A", "Business");

    }

    @Test
    public void scanBookingsAndClickUpdate()
    {
        shouldLoginCustomer();
        driver.get("http://10.9.10.39:81/sqlite/Main/editflight.php?FlightID=319");
        itineraryObject itineraryPage;
        itineraryPage = new itineraryObject(driver);
        itineraryPage.populateitinerary("25F");

    }

    @Test
    public void shouldDelete()
    {
        shouldLoginCustomer();
        driver.get("http://10.9.10.39:81/sqlite/Main/itinerary.php");

    }





    @After
    public void tearDown()

    {
        //driver.close();
    }

}

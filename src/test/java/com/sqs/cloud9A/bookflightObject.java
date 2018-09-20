package com.sqs.cloud9A;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class bookflightObject

{
    WebDriver driver;


    private By bookButtonLocator = By.xpath("/html/body/div/div/div[2]/form/button");


    private By originLocator = By.name("Origin");
    private By destinationLocator = By.name("Destination");
    private By seatLocator = By.name("seat");
    private By flightclassLocator = By.name("Flightclass");

    private By bodyTextLocator = By.tagName("body");


    private String cloud9BookHeader = "Book Flight";
    private String bookSuccessful = "Flight Successfully Booked";


    public bookflightObject(WebDriver driver) {

        this.driver = driver;
    }


    public void clickBook(WebDriver driver) {

        driver.findElement(bookButtonLocator).click();
    }


    public void populateBookflight(String origin, String destination, String seat, String flightclass){


        driver.findElement(originLocator).sendKeys(origin);
        driver.findElement(destinationLocator).sendKeys(destination);
        driver.findElement(seatLocator).sendKeys(seat);
        driver.findElement(flightclassLocator).sendKeys(flightclass);
        clickBook(driver);


    }


}


package com.sqs.cloud9A;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class itineraryObject {
    WebDriver driver;


    public itineraryObject(WebDriver driver) {
        this.driver = driver;
    }

    private By seatLocator = By.name("seat");
    private By updateButtonLocator = By.xpath("/html/body/div/div/div[2]/form/button");
    private By updateseat = By.xpath("//*[@id=\"seat\"]");
    private By itineraryButtonLocator = By.xpath("/html/body/div/div/div[2]/center/a");


    /*public void scanBookingsAndClickUpdate(String bookingID){
        //Utilities.login(driver,"wsi@netactive.co.za", "xxx");

        // trying to click on update /html/body/div/div/div[2]/div/table/tbody/tr[3]/td[5]

        driver.findElement(By.linkText("Update")).click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));

        System.out.println("Number of rows is " + rows.size());

        int rowNum =  rows.size();


        // Get booking id for latest booking
        List<WebElement> colVals2 = rows.get(rowNum-1).findElements(By.tagName("td"));
        System.out.println("What is this " + colVals2.get(3).getText());
        String columnContents;
        for(int i=1; i<rowNum; i++){
            List<WebElement> colVals1 = rows.get(i).findElements(By.tagName("td"));
            for(int j=0; j<6; j++){
                columnContents = colVals1.get(j).getText();
                if (columnContents.equals(bookingID))

                {
                    System.out.println("Found it: i=" + i + " : j = " + j);
                    System.out.println("Column Contents = " + columnContents);
                    //driver.get("http://10.9.10.39:81/sqlite/Main/editflight.php?FlightID=319");
                    // updateLink = colVals1.get(0);
                }
                System.out.println("j= " + j + " : " + colVals1.get(j).getText());
                // If we come out of the loop and have not found the ID, then print a relevant message
            }
        }
    }*/


    public void clickUpdate(WebDriver driver) {

        driver.findElement(updateButtonLocator).click();
    }

    public void clickItinerary(WebDriver driver) {

        driver.findElement(itineraryButtonLocator).click();

    }

    public void populateitinerary(String seat) {
        driver.findElement(updateseat).clear();
        driver.findElement(seatLocator).sendKeys(seat);
        clickUpdate(driver);
        clickItinerary(driver);
    }

    public void assertFlightSuccessfullyUpdated() {

        String editHeader = "Flight successfully updated";
        By bodyTextLocator = By.tagName("body");

        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(editHeader));
    }
}



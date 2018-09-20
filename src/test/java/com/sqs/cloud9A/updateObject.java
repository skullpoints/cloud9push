/* package com.sqs.cloud9A;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class updateObject {
    WebDriver driver;



  private By seatLocator = By.name("seat");
  private By updateButtonLocator = By.xpath("/html/body/div/div/div[2]/form/button");
  private By updateseat = By.xpath("//*[@id=\"seat\"]");
  private By itineraryButtonLocator = By.xpath("/html/body/div/div/div[2]/center/a");




 public updateObject(WebDriver driver) {

        this.driver = driver;
    }


        public void clickUpdate(WebDriver driver) {

        driver.findElement(updateButtonLocator).click();
    }

        public void clickItinerary(WebDriver driver){

        driver.findElement(itineraryButtonLocator).click();

        }




        public void populateUpdate(String seat)
        {
            driver.findElement(updateseat).clear();
            driver.findElement(seatLocator).sendKeys(seat);
            clickUpdate(driver);
            clickItinerary(driver);
    }

} */
package com.sqs.cloud9A;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signinObject {
    WebDriver driver;

    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By signinButtonLocator = By.xpath("/html/body/div/form/button");


    public signinObject(WebDriver driver) {

        this.driver = driver;
    }

    public void clickSignin(WebDriver driver){

        driver.findElement(signinButtonLocator).click();
    }



    public void populateSignin(String emailAddress, String password){

        driver.findElement(emailLocator).sendKeys(emailAddress);
        driver.findElement(passwordLocator).sendKeys(password);
        clickSignin(driver);
    }
}
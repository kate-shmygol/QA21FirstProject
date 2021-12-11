package com.telran.qa21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class OpenContactUsEdge {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        System.setProperty("webdriver.edge.driver", "/home/katja/Tools/msedgedriver");
//        EdgeDriver driver = new EdgeDriver();
        driver = new EdgeDriver();
        driver.navigate().to("http://automationpractice.com");
        //maximize browser to window width
        driver.manage().window().maximize();
        //wait for the site load before starting the test
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openContactUs() {
        // scenario:
        // find a button Contact us
        // click on the button Contact us
        driver.findElement(By.id("contact-link")).click();
        // check if our result is correct
        // find "CUSTOMER SERVICE - CONTACT US"
        String text = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals(text.toLowerCase(Locale.ROOT), "customer service - contact us");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
        driver.close();
    }

}

package com.telran.qa21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SearchProductTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com");
        //maximize browser to window width
        driver.manage().window().maximize();
        //wait for the site load before starting the test
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // old entry
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // new entry
//        WebDriverWait wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void searchProductTest() {
        // scenario:
        // find an element of search field and click on the search field
        driver.findElement(By.id("search_query_top")).click();
//        driver.findElement(By.cssSelector("input[name='q']")).sendKeys("summer dresses" + Keys.ENTER);
        // input search data "summer dresses", search strategy is "By.id"
        driver.findElement(By.id("search_query_top")).sendKeys("summer dresses" + Keys.ENTER); // search query
        // input search data "summer dresses", search strategy is "By.cssSelector"
//        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("summer dresses" + Keys.ENTER); // search query
        // check if the search result is correct: find "SUMMER DRESSES"
        String text = driver.findElement(By.className("lighter")).getText();
        Assert.assertEquals(text.toLowerCase(Locale.ROOT), "\"summer dresses\""); // the expected result is "lighter", but we're looking for what we want to see - String text

//        driver.findElement(By.cssSelector("div.center_column.col-xs-12.col-sm-12[css='2']"));
    }
    // xPath //div[@id='block_top_menu']/ul/li/a[@title='Women']

    @Test
    public void searchInContainerMenuTest() {
        // find an element and click on the first tab in the menu content
        WebElement ul = driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']"));
        ul.findElement(By.xpath(".//a[@title='Women']")).click();

        WebElement el = driver.findElement(By.xpath("//ul[@class='tree dynamized']"));
        el.findElement(By.xpath(".//*[contains(text(), 'Tops')]")).click();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit(); // close the whole browser
  //      driver.close(); // close the current tab
    }

    /* homework : openContactUs
    id = contact-link
    search text = CUSTOMER SERVICE - CONTACT US
      to do on chrome + edge + firefox drivers */

}

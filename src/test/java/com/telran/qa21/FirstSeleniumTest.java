package com.telran.qa21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    // before - setUp

    @BeforeMethod
    public void setUp() {
        // System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe"); // check Path
//        System.setProperty("webdriver.chrome.driver", "/home/katja/Tools/chromedriver");
        System.setProperty("webdriver.edge.driver", "/home/katja/Tools/msedgedriver");
        //initialize chrome driver to open chromebrowser
//        driver = new ChromeDriver();
        driver = new EdgeDriver();
//        driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
    }

    // test
    @Test
    public void openGoogleTest () {
        System.out.println("site opened!!!");
    }

    // after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown () {
        // close browser
        driver.quit();
    }


}

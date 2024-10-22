package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.Duration;

public class DriverManager {
    static WebDriver driver;
    public static void createDriver(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static InputStream takeSceenshotAsInputStream(){
        TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
        return new ByteArrayInputStream(ts.getScreenshotAs(OutputType.BYTES));
    }
}

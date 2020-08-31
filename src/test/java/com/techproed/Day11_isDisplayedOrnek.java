package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day11_isDisplayedOrnek {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

    @Before
    public void testtenOnce(){
        driver.get("http://bestbuy.com");
    }

    @After
    public void testtenSonra(){
       // driver.quit();
    }
    @Test
    public void test1() {

        String title = driver.getTitle();
        boolean bestKelimesiniIceriyorMu = title.contains("Best");
        Assert.assertTrue(bestKelimesiniIceriyorMu);

    }
    @Test
    public void test2() {

        WebElement logo = driver.findElement(By.className("logo"));
        boolean gorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(gorunuyorMu);


    }
    @Test
    public void test3() {

        WebElement logo = driver.findElement(By.partialLinkText("Mexico"));
        boolean gorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(gorunuyorMu);

    }



}

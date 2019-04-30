package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium4 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/w1devoir_netbeans/devoir/index.html";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSelenium4() throws Exception {
    driver.get(baseUrl + "/w1devoir_netbeans/");
    driver.findElement(By.linkText("week 1 assignment version 3")).click();
    driver.findElement(By.name("degrees")).clear();
    driver.findElement(By.name("degrees")).sendKeys("100");
    driver.findElement(By.name("convert")).click();
    driver.findElement(By.linkText("back home")).click();
    driver.findElement(By.linkText("week 1 assignment version 3")).click();
    new Select(driver.findElement(By.name("type"))).selectByVisibleText("Celsius to Fahrenheit");
    driver.findElement(By.name("degrees")).clear();
    driver.findElement(By.name("degrees")).sendKeys("23");
    driver.findElement(By.name("convert")).click();
    driver.findElement(By.linkText("back home")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

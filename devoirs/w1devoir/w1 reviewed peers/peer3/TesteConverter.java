package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteConverter {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEConverter() throws Exception {
    driver.get(baseUrl + "/CelsiusForFahrenheit/");
    new Select(driver.findElement(By.name("type"))).selectByVisibleText("Celsius");
    driver.findElement(By.name("graus")).clear();
    driver.findElement(By.name("graus")).sendKeys("212");
    driver.findElement(By.name("converter")).click();
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "O Resultado da conversão é: 100.0");
  }

  @Test
  public void testEC() throws Exception {
    driver.get(baseUrl + "/CelsiusForFahrenheit/");
    new Select(driver.findElement(By.name("type"))).selectByVisibleText("Fahrenheit");
    driver.findElement(By.name("graus")).clear();
    driver.findElement(By.name("graus")).sendKeys("100");
    driver.findElement(By.name("converter")).click();
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "O Resultado da conversão é: 212.0");
  }


  @AfterClass(alwaysRun = true)
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

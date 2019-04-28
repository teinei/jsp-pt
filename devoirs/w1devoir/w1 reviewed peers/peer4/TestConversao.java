package teste;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestConversao {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver","C:/geckodriver-v0.16.1-win64/geckodriver.exe");
    driver = new FirefoxDriver();
    
   
    baseUrl = "http://localhost:8080/semana1/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testConversao() throws Exception {
    driver.get(baseUrl + "index.jsp");
    driver.findElement(By.name("valor")).clear();
    driver.findElement(By.name("valor")).sendKeys("100");
    driver.findElement(By.id("celsius")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("212.0", driver.findElement(By.cssSelector("body")).getText());
  }

  @Test
  public void testConversao2() throws Exception {
    driver.get(baseUrl + "index.jsp");
    driver.findElement(By.name("valor")).clear();
    driver.findElement(By.name("valor")).sendKeys("212");
    driver.findElement(By.id("fahrenheit")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("100.0", driver.findElement(By.cssSelector("body")).getText());
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

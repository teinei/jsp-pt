package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.org.apache.bcel.internal.generic.Select;

import javafx.scene.control.Alert;

public class TesteFuncional {
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		driver.get("http://localhost:8080/WebConversor/");
		driver.findElement(By.id("valor")).click();
		driver.findElement(By.id("valor")).clear();
		driver.findElement(By.id("valor")).sendKeys("100");
		driver.findElement(By.id("opcoes")).click();
		new Select(driver.findElement(By.id("opcoes"))).selectByVisibleText("Fahrenheit");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Fahrenheit & Celsius'])[1]/following::option[2]"))
				.click();
		driver.findElement(By.id("btnConverter")).click();
		driver.findElement(By.xpath("//h1")).click();
		assertEquals("Resultado da Conversão: \n212 F", driver.findElement(By.xpath("//h1")).getText());
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

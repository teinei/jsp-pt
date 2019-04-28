package translateita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTranslate {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luizf\\eclipse-workspace\\SeleniumTeste\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Finalizou o before");
	}

	@Test
	public void testePalavraUm() throws Exception {
		driver.get("http://localhost:8081/TranslateIta/");
		driver.findElement(By.id("valor")).click();
		driver.findElement(By.id("valor")).clear();
		driver.findElement(By.id("valor")).sendKeys("gato");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='English to Português'])[1]/following::input[2]"))
				.click();
		driver.findElement(By.xpath("//p[2]")).click();
		driver.findElement(By.xpath("//p[2]")).click();
		try {
			assertEquals("English: cat", driver.findElement(By.xpath("//p[2]")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	@Test
	public void testePalavraDois() throws Exception {
		driver.get("http://localhost:8081/TranslateIta/");
		driver.findElement(By.id("valor")).click();
		driver.findElement(By.id("valor")).clear();
		driver.findElement(By.id("valor")).sendKeys("casa");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='English to Português'])[1]/following::input[2]"))
				.click();
		driver.findElement(By.xpath("//p[2]")).click();
		driver.findElement(By.xpath("//p[2]")).click();
		try {
			assertEquals("English: house", driver.findElement(By.xpath("//p[2]")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	@Test
	public void testePalavraInvalida() throws Exception {
		driver.get("http://localhost:8081/TranslateIta/");
		driver.findElement(By.id("valor")).click();
		driver.findElement(By.id("valor")).clear();
		driver.findElement(By.id("valor")).sendKeys("qualquer coisa");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='English to Português'])[1]/following::input[2]"))
				.click();
		driver.findElement(By.xpath("//p[2]")).click();
		driver.findElement(By.xpath("//p[2]")).click();
		try {
			assertEquals("English: ", driver.findElement(By.xpath("//p[2]")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

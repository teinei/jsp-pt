
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TradutorMVCTest {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        String localChromeDriver = "D:\\Users\\rbnbs\\Documents\\Curso Java Avançado\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", localChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void traduzirPalavraExistente01() throws Exception {
        driver.get("http://localhost:8080/TradutorMVC/");
        driver.findElement(By.name("chave")).click();
        driver.findElement(By.name("chave")).clear();
        driver.findElement(By.name("chave")).sendKeys("night");
        driver.findElement(By.name("translate")).click();
        try {
            assertEquals(driver.findElement(By.xpath("//h2")).getText(), "night = noite");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    
    @Test
    public void traduzirPalavraExistente02() throws Exception {
        driver.get("http://localhost:8080/TradutorMVC/");
        driver.findElement(By.name("chave")).click();
        driver.findElement(By.name("chave")).clear();
        driver.findElement(By.name("chave")).sendKeys("city");
        driver.findElement(By.name("translate")).click();
        try {
            assertEquals(driver.findElement(By.xpath("//h2")).getText(), "city = cidade");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    
    @Test
    public void traduzirPalavraInexistente() throws Exception {
        driver.get("http://localhost:8080/TradutorMVC/");
        driver.findElement(By.name("chave")).click();
        driver.findElement(By.name("chave")).clear();
        driver.findElement(By.name("chave")).sendKeys("police");
        driver.findElement(By.name("translate")).click();
        try {
            assertEquals(driver.findElement(By.xpath("//h2")).getText(), "police = police");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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

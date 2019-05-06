package tarefafinal.teste.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/*import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;*/

public class TesteIntegracaoSelenium {
	/*private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testDeLoginInvalido() throws Exception {
		driver.get(baseUrl + "/atividades-javawebavancado-semana4/login");
		driver.findElement(By.name("login")).clear();
		driver.findElement(By.name("login")).sendKeys("joao");
		driver.findElement(By.name("senha")).clear();
		driver.findElement(By.name("senha")).sendKeys("1");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		assertEquals("Login e/ou senha incorretos", driver.findElement(By.xpath("//div[3]")).getText());
	}

	@Test
	public void testLoginValidado() throws Exception {
		driver.get(baseUrl + "/atividades-javawebavancado-semana4/login");
		driver.findElement(By.name("login")).clear();
		driver.findElement(By.name("login")).sendKeys("joao");
		driver.findElement(By.name("senha")).clear();
		driver.findElement(By.name("senha")).sendKeys("123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		assertEquals("Bem vindo: Joao Pedro", driver.findElement(By.cssSelector("h1")).getText());
	}

	@Test
	public void testCricaoNovoTopico() throws Exception {
		driver.get(baseUrl + "/atividades-javawebavancado-semana4/topicos");
		driver.findElement(By.linkText("Criar Tópico")).click();
		driver.findElement(By.name("titulo")).clear();
		driver.findElement(By.name("titulo")).sendKeys("Títudo do novo topico");
		driver.findElement(By.name("conteudo")).clear();
		driver.findElement(By.name("conteudo")).sendKeys("conteúdo do novo topico para a comunidade");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	}

	@Test
	public void testCriacaoNovoComentario() throws Exception {
		driver.get(baseUrl + "/atividades-javawebavancado-semana4/topicos");
		driver.findElement(By.xpath("(//a[contains(text(),'exibir')])[4]")).click();
		driver.findElement(By.name("comentario")).clear();
		driver.findElement(By.name("comentario")).sendKeys("Criando novo comentario");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		driver.findElement(By.linkText("Voltar")).click();
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
	}*/
}

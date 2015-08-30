package telran.com;


        import java.util.regex.Pattern;
        import java.util.concurrent.TimeUnit;
        import org.testng.*;
        import static org.testng.Assert.*;
        import static org.hamcrest.CoreMatchers.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.Select;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;

public class PrichislovMenu770Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testPrichislovMenu770TestHtml() throws Exception {
        driver.get("https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html");
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("воскресенье");
        try {
            assertFalse(driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).isSelected());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
        try {
            assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).isSelected());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("makeOrder")).click();
        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='history']/li[last()][contains(text(),'100 ')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterTest
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

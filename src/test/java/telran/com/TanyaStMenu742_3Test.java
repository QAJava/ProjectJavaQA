

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TanyaStMenu742_3Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testMenu3() throws Exception {
        driver.get("https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html");
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("пятница");
        // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
        driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
        try {
            assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).isSelected());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
        driver.findElement(By.xpath("//input[@id='makeOrder']")).click();
        try {
            assertTrue(isElementPresent(By.cssSelector("li")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//a[contains(text(),'Начать заново')]")).click();
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("четверг");
        driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
        driver.findElement(By.xpath("//input[@id='makeOrder']")).click();
        try {
            assertTrue(isElementPresent(By.cssSelector("li")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//a[contains(text(),'Начать заново')]")).click();
        driver.findElement(By.id("days")).click();
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("вторник");
     driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
     driver.findElement(By.xpath("//input[@id='makeOrder']")).click();
        try {
            assertTrue(isElementPresent(By.xpath("//ol[@id='history']/li")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterClass
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

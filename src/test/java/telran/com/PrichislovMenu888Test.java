package telran.com;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;


public class PrichislovMenu888Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "d:/_TEL-RAN_Roma/TestingTools/chromedriver.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void test986Yacov() throws Exception {

        new Select(driver.findElement(By.id("days"))).selectByVisibleText("вторник");
        // driver.findElement(By.xpath(//select[@id='days']/option[3])).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();
        driver.findElement(By.id("makeOrder")).click();
//        Thread.sleep(2000);
        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='history']/li[last()][contains(text(),'163')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testPrichislovMenu888() throws Exception {
        driver.findElement(By.xpath("//html/body/div/a")).click();
        Select selectDay = new Select(driver.findElement(By.id("days")));
        //selectDay.selectByIndex(2);
        selectDay.selectByVisibleText("среда");
        WebElement el = driver.findElement(By.xpath("(//input[@type='checkbox'])[5]"));
        el.click();
        el = driver.findElement(By.xpath("(//input[@type='checkbox'])[6]"));
        el.click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
        driver.findElement(By.id("makeOrder")).click();
        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='history']/li[last()][contains(text(),'среда')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='history']/li[last()][contains(text(),'каша пшеная, борщ, отбивная из курицы, хлеб')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='history']/li[last()][contains(text(),'383')]")));
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

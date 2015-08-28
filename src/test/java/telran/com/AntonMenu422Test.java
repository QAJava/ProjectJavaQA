package telran.com;

/**
 * Created by Anton on 24-Aug-15.
 */


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;

public class AntonMenu422Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://addons.mozilla.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testMenu390() throws Exception {
        driver.get("https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html");
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("понедельник");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
        driver.findElement(By.id("makeOrder")).click();
        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='history']/li[last()][contains(text(),'502 р')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testMenu422() throws Exception {
        driver.get("https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html");
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("среда");
        try {
            assertFalse(driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).isSelected());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
        try {
            assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).isSelected());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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
        try {
            assertFalse(driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).isSelected());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
        try {
            assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).isSelected());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("orderSum"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertEquals("303", driver.findElement(By.id("orderSum")).getText(), "Sum is not equal to what was expeced");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
       /* try {
            assertTrue(isElementPresent(By.xpath("//span[@id='orderSum'][contains(text(),'303')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }*/
        driver.findElement(By.id("makeOrder")).click();
        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='history']/li[last()][contains(text(),'каша пшеная, отбивная из курицы, хлеб.')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterTest(alwaysRun = true)
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


package telran.com;

/**
 * Created by Anton on 22-Aug-15.
 */
import org.openqa.selenium.Alert;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import telran.com.pages.AlexPMondayPage;

import telran.com.pages.BasePage;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class AntonMenu390Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public AlexPMondayPage mondayPage;
    public BasePage basePage;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mondayPage = PageFactory.initElements(driver, AlexPMondayPage.class);
        basePage = PageFactory.initElements(driver,BasePage.class);
    }

    @Test
    public void Anton390Test() throws Exception {
        driver.get(baseUrl);
        mondayPage.selectDay("понедельник");
        //new Select(driver.findElement(By.id("days"))).selectByVisibleText("понедельник");
        mondayPage.clickToKasha()
                  .clickToBuffet()
                  .clickToPlov();
        Assert.assertEquals(basePage.getOrderSum(), 552.1);
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "502");
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


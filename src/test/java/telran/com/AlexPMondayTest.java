package telran.com;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import telran.com.pages.AlexPMondayPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class AlexPMondayTest {
    public AlexPMondayPage mondayPage;
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mondayPage = PageFactory.initElements(driver,AlexPMondayPage.class);
    }

    @Test
    public void testMenuAlexP() {
        driver.get(baseUrl);
        mondayPage.selectDay("понедельник");
        mondayPage.checkThatKashaDisplyed("Point menu - Kasha - is notdisplayed");
        mondayPage.clickToKasha();
        mondayPage.clickToPlov();
        mondayPage.clickToMakeOrder();
        mondayPage.checkTextInReport(driver,"152");

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
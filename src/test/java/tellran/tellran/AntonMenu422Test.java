package tellran;

/**
 * Created by Anton on 24-Aug-15.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;
import telran.com.pages.MondayPage;
import telran.com.pages.BasePage;
import telran.com.pages.WedensdayPage;


public class AntonMenu422Test {
    public WedensdayPage wedensdayPage;
    public BasePage basePage;
    public MondayPage mondayPage;
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        basePage = PageFactory.initElements(driver, BasePage.class);
        mondayPage = PageFactory.initElements(driver, MondayPage.class);
        wedensdayPage = PageFactory.initElements(driver, WedensdayPage.class);
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
    }

    @Test
    public void testMenu422() throws Exception {
        driver.get(baseUrl);
        basePage.selectDay("среда");
        wedensdayPage.clickToKasha()
                     .clickToOtbivnaya()
                     .checkThatHlebDisplyed("Point menu - Hleb - is not displayed")
                     .clickToCHleb();
        Assert.assertEquals(basePage.getOrderSum(), 303.0);
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "253 р");
        //basePage.checkTextInReport(driver, "среда, каша пшеная, отбивная из курицы, хлеб. Списано с личного счета 253 р.");
    }

    @Test
    public void testMenu390() throws Exception {
        driver.get(baseUrl);
        basePage.clickToStartOverLink();
        basePage.selectDay("понедельник");
        basePage.clickToMakeOrder();
        basePage.checkThatValidationTextDisplayed("Нельзя сделать пустой заказ!!!");
        mondayPage.clickToCheckboxKasha()
                .clickToShvedStolaMo()
                .clickToPlovMo();
        Assert.assertEquals(basePage.getOrderSum(), 552.1);
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "502 р");
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



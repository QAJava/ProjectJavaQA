/**
 * Created by tanyagaus on 9/15/15.
 */
package telran.com;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import telran.com.pages.AlexPMondayPage;
import telran.com.pages.BasePage;
import telran.com.pages.TuesdayPage;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TuesdayPageTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new
            StringBuffer();
    public BasePage basePage;
    public TuesdayPage tuesdayPage;
    public AlexPMondayPage mondayPage;
    public final int DISCOUNT = 50;

    //public static String time;   //time variable.
    //public static DateFormat dateFormat = new
    //SimpleDateFormat("HH:mm:ss");   //DateFormat variable.
    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.manage().timeouts().implicitlyWait(30,
                TimeUnit.SECONDS);
        basePage= PageFactory.initElements(driver,
                BasePage.class);
        tuesdayPage = PageFactory.initElements(driver, TuesdayPage.class);
        mondayPage = PageFactory.initElements(driver, AlexPMondayPage.class);
    }

    @Test
    public void testTanya() {
        driver.get(baseUrl);
        basePage.selectDay("вторник");
        tuesdayPage.checkThatSalatDisplyed("Point menu - Salat - is not displayed");
        tuesdayPage.clickToSalatCaesar()
                .clickToSupPureBroccoli()
                .clickToRaguSvininy()
                .clickToHleb();
        Assert.assertEquals(basePage.getOrderSum(), 463.54);
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "414");
        // basePage.clickToStartOverLink();
        // basePage.selectDay("вторник");
        //tuesdayPage.checkThatSalatDisplyed("Point menu -        Salat - is not displayed");
        tuesdayPage.clickToSupPureBroccoli().clickToRaguSvininy()
                .clickToHleb();
        Assert.assertEquals(basePage.getOrderSum(), 381.0);
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "331");
        tuesdayPage.clickToRaguSvininy().clickToHleb();
        Assert.assertEquals(basePage.getOrderSum(), 251.0);
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "201");
        tuesdayPage.clickToHleb();
        Assert.assertEquals(basePage.getOrderSum(), 1.0);
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "0 р.");
        basePage.clickToStartOverLink();
        basePage.selectDay("понедельник");
        mondayPage.checkThatKashaDisplyed("Point menu - Kasha - is not displayed");
        mondayPage.clickToKasha();
        mondayPage.clickToOmelet();
        mondayPage.clickToBuffet();
        mondayPage.clickToPlov();
        Assert.assertEquals(basePage.getOrderSum(), 622.1);
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "572");
    }

    @Test
    public void testTanya1() {
        driver.get(baseUrl);
        basePage.selectDay("вторник");
        tuesdayPage.checkThatSalatDisplyed("Point menu - Salat - is not displayed");
        basePage.clickToMakeOrder();
        //basePage.checkThatValidationTextDisplayed("Нельзя сделать пустой заказ!!!");
        basePage.checkThatValidationTextDisplayed("Go to hell");
        tuesdayPage.clickToSalatCaesar().clickToHleb();
        Assert.assertEquals(basePage.getOrderSum(), 83.54);
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "34");
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
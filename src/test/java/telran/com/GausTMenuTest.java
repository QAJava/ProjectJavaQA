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
import telran.com.pages.MainPage;
import telran.com.pages.TuesdayPage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by Anton,Tanya on 8/31/15.
 */
public class GausTMenuTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public MainPage mainPage;
    public TuesdayPage tuesdayPage;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        tuesdayPage = PageFactory.initElements(driver, TuesdayPage.class);

    }

    @Test
    public void testGausT1()  {
        driver.get(baseUrl);
        mainPage.selectDay("вторник");
        tuesdayPage.clickToSalatCaesar();
        Assert.assertEquals(mainPage.getOrderSum(), 82);
        mainPage.clickToMakeOrder();
        Assert.assertEquals(mainPage.getAccountSum(), 15423.91);
    }

    @Test
    public void testGausT2()  {
        driver.get(baseUrl);
        mainPage.selectDay("вторник");
        tuesdayPage.clickToSupPureBroccoli();
        Assert.assertEquals(mainPage.getOrderSum(), 130);
        mainPage.clickToMakeOrder();
        Assert.assertEquals(mainPage.getAccountSum(), 15376.45);

    }

    @Test
    public void testGausT3()  {
        driver.get(baseUrl);
        mainPage.selectDay("вторник");
        tuesdayPage.clickToRaguSvininy();
        Assert.assertEquals(mainPage.getOrderSum(), 250);
        mainPage.clickToMakeOrder();
        Assert.assertEquals(mainPage.getAccountSum(), 15256.45);
    }

    @Test
    public void testGausT4()  {
        driver.get(baseUrl);
        mainPage.selectDay("вторник");
        tuesdayPage.clickToHleb();
        Assert.assertEquals(mainPage.getOrderSum(), 1);
        mainPage.clickToMakeOrder();
        Assert.assertEquals(mainPage.getAccountSum(), 15505.45);
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


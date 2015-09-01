package telran.com;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import telran.com.pages.HomePage;
import telran.com.pages.SundayPage;

public class AlexPMenu973Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public HomePage homePage;
    public SundayPage sundayPage;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver,HomePage.class);
        sundayPage = PageFactory.initElements(driver,SundayPage.class);
    }

    @Test
    public void testAlexPMenu973(){ //throws Exception {    driver.get("https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html");

        driver.get(baseUrl);
        homePage.selectDay("воскресенье");
        sundayPage.clickToCheckboxChicken();
        sundayPage.clickToCheckboxPumpkink();
        sundayPage.clickToCheckboxfishermanSoup();
        sundayPage.clickToBread();
        //driver.findElement(By.id("makeOrder")).click();
        Assert.assertEquals(homePage.getOrderSum(),251);

//        new Select(driver.findElement(By.id("days"))).selectByVisibleText("воскресенье");
//        driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
//        driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();
//        driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
//        driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
//        driver.findElement(By.id("makeOrder")).click();
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
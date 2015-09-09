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
import telran.com.pages.MondayPage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class YacovMenu968Test {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();
        public MainPage mainPage;
        public MondayPage mondayPage;

        @BeforeTest
        public void setUp() throws Exception {
                driver = new FirefoxDriver();
                baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                mainPage = PageFactory.initElements(driver, MainPage.class);
                mondayPage = PageFactory.initElements(driver, MondayPage.class);

        }

        @Test
        public void test986Yacov()  {
                driver.get(baseUrl);
                mainPage.selectDay("понедельник");
                mondayPage.clickToEggs();
                Assert.assertEquals(mainPage.getOrderSum(),70);

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

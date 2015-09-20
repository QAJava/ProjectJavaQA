package tellran;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import telran.com.pages.AlexPMondayPage;
import telran.com.pages.BasePage;
import telran.com.pages.SundayPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class AlexPMondayTest {
    public AlexPMondayPage mondayPage;
    public SundayPage sundayPage;
    public BasePage basePage;

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mondayPage = PageFactory.initElements(driver,AlexPMondayPage.class);
        sundayPage = PageFactory.initElements(driver,SundayPage.class);
        basePage = PageFactory.initElements(driver,BasePage.class);

    }

    @Test
    public void testMenuAlexP() {
        //driver.get(baseUrl);
        mondayPage.selectDay("понедельник");
        mondayPage.clickToKasha();
        mondayPage.clickToPlov();
        mondayPage.clickToMakeOrder();
        mondayPage.checkTextInReport(driver,"152");
        mondayPage.clickRestart();
    }

    @Test
    public void testMenu2AlexP() {
        //driver.get(baseUrl);
        basePage.selectDay("воскресенье");
        sundayPage.clickToCheckboxChicken();
        sundayPage.clickToCheckboxPumpkink();
        sundayPage.clickToCheckboxfishermanSoup();
        sundayPage.clickToBread();
        basePage.clickToMakeOrder();
        basePage.checkTextInReport(driver, "251");
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
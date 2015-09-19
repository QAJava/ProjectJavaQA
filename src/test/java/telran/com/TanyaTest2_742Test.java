package telran.com;

        import java.util.concurrent.TimeUnit;
        import static org.testng.Assert.assertFalse;
        import static org.testng.Assert.assertTrue;
        import static org.testng.Assert.fail;
        import org.openqa.selenium.*;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.Select;
        import org.testng.FileAssert;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;
        import telran.com.pages.BasePage;
        import telran.com.pages.Page;
        import telran.com.pages.SundayPage;
        import telran.com.pages.TuesdayPage;

public class TanyaTest2_742Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public BasePage basePage;
    public TuesdayPage tuesdayPage;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        basePage = PageFactory.initElements(driver, BasePage.class);
        tuesdayPage = PageFactory.initElements(driver, TuesdayPage.class);
    }

        @Test
        public void TanyaTest2_742Test () {
            driver.get(baseUrl);
            basePage.selectDay("Вторник");
            tuesdayPage.clickToSalatCaesar();
            tuesdayPage.clickToSupPureBroccoli();

            basePage.clickToMakeOrder();
            basePage.checkTextInReport(driver, "163");

        }

        @AfterTest
        public void tearDown ()throws Exception {
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


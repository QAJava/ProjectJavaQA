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
        import org.testng.annotations.*;
        import telran.com.pages.*;

public class TanyaTest740Test {
    public TuesdayTanyaStPage tuesdayTanyaStPage;
    public BasePage basePage;
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();



    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        tuesdayTanyaStPage = PageFactory.initElements(driver, TuesdayTanyaStPage.class);
    }

        @Test
        public void  TanyaTest740Test(){


            driver.get(baseUrl);
            tuesdayTanyaStPage.selectDay("вторник");
            tuesdayTanyaStPage.clickToSupPureBroccoli();
            tuesdayTanyaStPage.clickToHleb();
            tuesdayTanyaStPage.clickToMakeOrder();
            tuesdayTanyaStPage.checkTextInReport(driver, "81");
}
            @Test
            public void TanyaTest741Test (){
                //driver.get(baseUrl);
               // tuesdayTanyaStPage.selectDay("вторник");
                tuesdayTanyaStPage.clickToSalatCaesar();
                tuesdayTanyaStPage.clickToSupPureBroccoli();
                tuesdayTanyaStPage.clickToRaguSvininy();
                tuesdayTanyaStPage.clickToHleb();
                tuesdayTanyaStPage.clickToMakeOrder();
                tuesdayTanyaStPage.checkTextInReport(driver, "414");


        }

        @AfterClass(alwaysRun = true)
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


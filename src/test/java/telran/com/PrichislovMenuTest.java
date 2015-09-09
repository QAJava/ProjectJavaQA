package telran.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class PrichislovMenuTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testPrichislovMenuTest()throws Exception  {
        WebElement el = driver.findElement(By.id("days"));
        Select select = new Select(el);
        String day = "воскресенье";
        select.selectByVisibleText(day);

        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedOptionText = selectedOption.getText();

//        try {
            assertEquals(selectedOptionText, day);
//        } catch (Exception e) {
//            System.out.println("Error assertEquals");
//        }

        el =  driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
        boolean isSelected = el.isSelected();

        assertFalse(isSelected);

       el.click();
        isSelected = el.isSelected();
        org.testng.Assert.assertTrue(isSelected);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

}

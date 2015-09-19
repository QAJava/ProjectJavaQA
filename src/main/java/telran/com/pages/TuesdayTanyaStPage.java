package telran.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.testng.AssertJUnit.assertTrue;

public class TuesdayTanyaStPage extends Page {
    public String baseUrl;
    private WebElement webElement;


    @FindBy(xpath = "//*[@id='menu']/div[@key=2]/div[1]/input")
    WebElement salatCaesar;
    @FindBy(xpath = "//*[@id='menu']/div[@key=2]/div[2]/input")
    WebElement supPureBroccoli;
    @FindBy(xpath = "//*[@id='menu']/div[@key=2]/div[3]/input")
    WebElement raguSvininy;
    @FindBy(xpath = "//*[@id='menu']/div[@key=2]/div[4]/input")
    WebElement hleb;
    @FindBy(id = "days")
    protected WebElement days;
    @FindBy(id = "orderSum")
    protected WebElement orderSum;
    @FindBy(id = "makeOrder")
    protected WebElement makeOrderButton;



    public TuesdayTanyaStPage(WebDriver driver) {
        super(driver);
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public TuesdayTanyaStPage openMainPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public TuesdayTanyaStPage selectDay(String day) {
        new Select(days).selectByVisibleText(day);
        return this;
    }

    public TuesdayTanyaStPage clickToSalatCaesar() {
        salatCaesar.click();
        return this;
    }

    public TuesdayTanyaStPage clickToSupPureBroccoli() {
        supPureBroccoli.click();
        return this;
    }


    public TuesdayTanyaStPage clickToRaguSvininy() {
        raguSvininy.click();
        return this;
    }


    public TuesdayTanyaStPage clickToHleb() {
        hleb.click();
        return this;
    }

    public TuesdayTanyaStPage clickToMakeOrder() {
        makeOrderButton.click();
        return this;
    }

    public void checkTextInReport(WebDriver driver, String text) {
        String locator = "//*[@id='history']/li[last()][contains(text(),'" + text + "')]";
        WebElement element = driver.findElement(By.xpath(locator));
        assertTrue("Text " + text + " is not present in Menu report", element.isDisplayed());
    }

    public TuesdayTanyaStPage checkThatSalatDisplyed(String message) {
        checkIfDisplayed(salatCaesar, message);

        return this;
    }
}


package telran.com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.testng.AssertJUnit.assertTrue;

public class AlexPMondayPage extends Page {
    private WebElement webElement;
    public String baseUrl;

    @FindBy(xpath = "//*[@id='menu']/div[@key=1]/div[1]/input")
    WebElement kasha;
    @FindBy(xpath = "//*[@id='menu']/div[@key=1]/div[2]/input")
    WebElement omelet;
    @FindBy(xpath = "//*[@id='menu']/div[@key=1]/div[3]/input")
    WebElement buffet;
    @FindBy(xpath = "//*[@id='menu']/div[@key=1]/div[4]/input")
    WebElement plov;
    @FindBy(id = "days")
    WebElement days;
    @FindBy(id = "orderSum")
    WebElement orderSum;
    @FindBy(id = "makeOrder")
    WebElement makeOrderButton;

    public AlexPMondayPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }
    public AlexPMondayPage openMainPage(){
        driver.get(PAGE_URL);
        return this;
    }
    public AlexPMondayPage selectDay(String day){
        new Select(days).selectByVisibleText(day);
        return this;
    }
//    public double getOrderSum(){
//        double orderSum = 0;
//        orderSum = Double.parseDouble(orderSum.getText)
//        return orderSum;
//
//    }

    public AlexPMondayPage clickToMakeOrder(){
         makeOrderButton.click();
         return this;
     }

    public AlexPMondayPage clickToKasha(){
        kasha.click();
        return this;
    }
    public AlexPMondayPage clickToOmelet() {
        omelet.click();
        return this;
    }
    public AlexPMondayPage clickToBuffet() {
        buffet.click();
        return this;
    }
    public AlexPMondayPage clickToPlov() {
        plov.click();
        return this;
    }

    public void checkTextInReport(WebDriver driver, String text) {
        String locator = "//*[@id='history']/li[last()][contains(text(),'" + text + "')]";
        WebElement element = driver.findElement(By.xpath(locator));
        assertTrue("Text " + text + " is not present in Menu report", element.isDisplayed());
    }
}

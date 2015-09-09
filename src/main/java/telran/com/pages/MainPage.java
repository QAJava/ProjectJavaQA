package telran.com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;


public class MainPage extends Page {
    public final int DISCOUNT = 50;
    public String baseUrl;
    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "orderSum")
    WebElement orderSum;


    //Days
    @FindBy(id = "makeOrder")
    WebElement makeOrderButton;

    @FindBy(linkText = "Начать заново")
    WebElement startOverLink;

    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement header;

    @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[1]/input")
    WebElement kashaMannayaMo;

    @FindBy(id = "account")
    WebElement accountSum;

    public MainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public MainPage openMainPage() {
        driver.get(PAGE_URL);
        return this;
    }


    public MainPage clickToMakeOrder() {
        clickElement(makeOrderButton);
        return this;
    }


    public MainPage selectDay(String day) {

        new Select(days).selectByVisibleText(day);
        return this;
    }

    public double getOrderSum() {
        double ordersum = 0;
        ordersum = Double.parseDouble(orderSum.getText());
        return ordersum;
    }


    /**
     *
     */
    /*public int getAccountSum() {
        int accountsum = 15456;
        accountsum = Integer.parseInt(accountSum.getText());
        return accountsum;
    }*/
    public void waitUntilMainPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(days);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkTextInReport(WebDriver driver, String text) {
        String locator = "//*[@id='history']/li[last()][contains(text(),'" + text + "')]";
        WebElement element = driver.findElement(By.xpath(locator));
        assertTrue("Text " + text + " is not present in Menu report", element.isDisplayed());
    }

    public void checkText(WebDriver driver, String text) {
        String locator = "//*[contains(text(),'" + text + "')]";
        WebElement element = driver.findElement(By.xpath(locator));
        assertTrue("Text " + text + " is not present in Menu report", element.isDisplayed());
    }


}

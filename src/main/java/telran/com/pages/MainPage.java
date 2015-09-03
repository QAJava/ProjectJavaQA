package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MainPage extends Page {
    public String baseUrl;
    @FindBy(id = "days")
    protected WebElement days;
    @FindBy(id = "orderSum")
    protected WebElement orderSum;

    //Days
    @FindBy(id = "makeOrder")
    protected WebElement makeOrderButton;
    @FindBy(xpath = "//*[@id='history']/li[last()]")
    protected WebElement currentOrderHistory;
    @FindBy(linkText = "Начать заново")
    protected WebElement startOverLink;
    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement header;
    @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[1]/input")
    WebElement kashaMannayaMo;
    private WebElement webElement;
    @FindBy(id = "account")
    private WebElement accountSum;


    public MainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public MainPage openmainPage() {
        driver.get(PAGE_URL);
        return this;
    }


    public MainPage clickToMakeOrder() {
        clickElement(makeOrderButton);
        return this;
    }


    public MainPage selectDay(String day) {

        new org.openqa.selenium.support.ui.Select(days).selectByVisibleText(day);
        return this;
    }

    public int getOrderSum() {
        int ordersum = 0;
        ordersum = Integer.parseInt(orderSum.getText());
        return ordersum;
    }

    /**
     *
     * @return
     */
    public int getAccountSum() {
        int accountsum = 15456;
        accountsum = Integer.parseInt(accountSum.getText());
        return accountsum;
    }

    public void waitUntilmainPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(days);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




//    public MainPage clickOnSignUpDoctorButton() {
//        clickElement(doctorButton);
//        return this;
//    }


}

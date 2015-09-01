package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class ThursdayPage extends Page {
    public String baseUrl;
    private WebElement webElement;

    @FindBy(xpath = "//*[@id='menu']/div[@key='4']/div[1]/input")
    WebElement salatTh;
    @FindBy(xpath = "//*[@id='menu']/div[@key='4']/div[2]/input")
    WebElement shiTh;
    @FindBy(xpath = "//*[@id='menu']/div[@key='4']/div[3]/input")
    WebElement zharkoeTh;
    @FindBy(xpath = "//*[@id='menu']/div[@key='4']/div[4]/input")
    WebElement hlebTh;

    @FindBy(id = "days")
    protected WebElement days;

    @FindBy(id = "orderSum")
    protected WebElement orderSum;



    public ThursdayPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public ThursdayPage openHomePage() {
        driver.get(PAGE_URL);
        return this;
    }

    public ThursdayPage clickToCheckboxSalat(){
        salatTh.click();
        return this;
    }

    public ThursdayPage clickToCheckboxShi(){
        shiTh.click();
        return this;
    }
    public ThursdayPage clickToCheckboxZharkoe(){
        zharkoeTh.click();
        return this;
    }
    public ThursdayPage clickToCheckboxHleb(){
        hlebTh.click();
        return this;
    }

    public int getOrderSum () {
        int ordersum = 0;
        ordersum = Integer.parseInt(orderSum.getText());
        return ordersum;
    }

    public void waitUntilHomePageIsLoaded() {
        try {
            waitUntilElementIsLoaded(days);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}


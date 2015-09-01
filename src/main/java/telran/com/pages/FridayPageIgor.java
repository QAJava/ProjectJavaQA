package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class FridayPageIgor extends Page {
    public String baseUrl;


    private WebElement webElement;

    public FridayPageIgor(WebDriver webDriver, String baseUrl) {
        super(webDriver);
        this.baseUrl = baseUrl;
    }

    @FindBy(xpath = "//*[@id='menu'][contains(text(),'Салат Мистерия весны 60 р.')]")
    private WebElement salatMisteriyaVesny;
    @FindBy(xpath = "//*[@id='menu'][contains(text(),'Лагман 65 р.')]")
    private WebElement lagman;
    @FindBy(xpath = "//*[@id='menu'][contains(text(),'Бефстроганов 95 р.')]")
    private WebElement befstroganof;
    @FindBy(xpath = "//*[@id='menu'][contains(text(),'Капуста жареная 50 р.')]")
    private WebElement KapustaZharennaya;

    @FindBy(id = "days")
    protected WebElement days;

    @FindBy(id = "orderSum")
    protected WebElement orderSum;

    public FridayPageIgor(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public FridayPageIgor openHomePage() {
        driver.get(PAGE_URL);
        return this;
    }

    public FridayPageIgor clickToCheckboxKasha(){
        salatMisteriyaVesny.click();
        return this;
    }

    public FridayPageIgor clickToEggs(){
        lagman.click();
        return this;
    }



    public float getOrderSum () {
        float ordersum = 0;
        ordersum = Float.parseFloat(orderSum.getText());
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
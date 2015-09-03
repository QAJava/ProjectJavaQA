package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
/**
 * Created by Anton,Tanya on 8/30/15.
 */
public class TuesdayPage extends Page {
    public String baseUrl;


    private WebElement webElement;

    /**
     * Days of TuesdayPage area
     */

    @FindBy(xpath = "//*[@id='menu']/div[@key='2']/div[1]/input")
    WebElement salatCaesar;
    @FindBy(xpath = "//*[@id='menu']/div[@key='2']/div[2]/input")
    WebElement supPureBroccoli;
    @FindBy(xpath = "//*[@id='menu']/div[@key='2']/div[3]/input")
    WebElement raguSvininy;
    @FindBy(xpath = "//*[@id='menu']/div[@key='2']/div[4]/input")
    WebElement hleb;
    /**
     * Elements of TuesdayPage area
     */
    @FindBy(id = "days")
    protected WebElement days;

    @FindBy(id = "orderSum")
    protected WebElement orderSum;
    /**
     * Button of TuesdayPage area
     */
    @FindBy(id = "makeOrder")
    protected WebElement makeOrderButton;
    /**
     * Text element of TuesdayPage area
     */
    @FindBy(xpath = "//*[@id='history']/li[last()]")
    protected WebElement currentOrderHistory;

    /**
     *
     * @param driver
     */
    public TuesdayPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    /**
     *
     * @return
     */
    public TuesdayPage openHomePage() {
        driver.get(PAGE_URL);
        return this;
    }

    /**
     *
     * @return
     */
    public TuesdayPage clickToSalatCaesar(){
        salatCaesar.click();
        return this;
    }

    /**
     *
     * @return
     */
    public TuesdayPage clickToSupPureBroccoli(){
        supPureBroccoli.click();
        return this;
    }

    /**
     *
     * @return
     */
    public TuesdayPage clickToRaguSvininy(){
        raguSvininy.click();
        return this;
    }

    /**
     *
     * @return
     */
    public TuesdayPage clickToHleb() {
        hleb.click();
        return this;
    }

    /**
     *
     * @return
     */
    public int getOrderSum () {
        int ordersum = 0;
        ordersum = Integer.parseInt(orderSum.getText());
        return ordersum;
    }

   // public MainPage clickToMakeOrder (){
     //  clickElement(makeOrderButton);
      //  @FindBy(xpath = "//*[@id='history']/li[last()]")

       // return currentOrderHistory;}

    /**
     *
     */
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



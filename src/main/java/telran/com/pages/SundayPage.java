package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SundayPage extends Page {
    public String baseUrl;


	private WebElement webElement;


    //Days

    @FindBy(xpath = "//*[@id='menu']/div[@key='7']/div[1]/input")
    WebElement chickenSu;
    @FindBy(xpath = "//*[@id='menu']/div[@key='7']/div[2]/input")
    WebElement pumpkinkAndPorkSu;
    @FindBy(xpath = "//*[@id='menu']/div[@key='7']/div[3]/input")
    WebElement fishermanSoupSu;
    @FindBy(xpath = "//*[@id='menu']/div[@key='7']/div[4]/input")
    WebElement breadSu;

    @FindBy(id = "days")
	protected WebElement days;

    @FindBy(id = "orderSum")
    protected WebElement orderSum;

    @FindBy(xpath = "//a")
    WebElement restart;


    public SundayPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public SundayPage openmainPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public SundayPage clickRestart(){
        restart.click();
        return this;
    }

    public SundayPage clickToCheckboxChicken() {
        chickenSu.click();
        return this;
    }

    public SundayPage clickToCheckboxPumpkink() {
        pumpkinkAndPorkSu.click();
        return this;
    }

    public SundayPage clickToCheckboxfishermanSoup(){
        fishermanSoupSu.click();
        return this;
    }

    public SundayPage clickToBread(){
        breadSu.click();
        return this;
    }
    public int getOrderSum () {
        int ordersum = 0;
       ordersum = Integer.parseInt(orderSum.getText());
        return ordersum;
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

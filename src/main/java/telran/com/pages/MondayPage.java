package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MondayPage extends Page {
    public String baseUrl;


	private WebElement webElement;


    //Days

    @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[1]/input")
    WebElement kashaMannayaMo;
    @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[2]/input")
    WebElement yaichnitsaMo;
    @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[3]/input")
    WebElement shvedStolaMo;
    @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[4]/input")
    WebElement plovMo;

    @FindBy(id = "days")
	protected WebElement days;

    @FindBy(id = "orderSum")
    protected WebElement orderSum;




    public MondayPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public MondayPage openMainPage() {
        driver.get(PAGE_URL);
        return this;
    }

public MondayPage clickToCheckboxKasha(){
    kashaMannayaMo.click();
    return this;
}

    public MondayPage clickToEggs(){
        yaichnitsaMo.click();
        return this;
    }

    public MondayPage clickToShvedStolaMo(){
        shvedStolaMo.click();
        return this;
    }

    public MondayPage clickToPlovMo(){
        plovMo.click();
        return this;
    }

    public int getOrderSum () {
        int ordersum = 0;
       ordersum = Integer.parseInt(orderSum.getText());
        return ordersum;
    }

    public void waitUntilMainPageIsLoaded() {
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

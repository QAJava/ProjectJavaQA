package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WedensdayPage extends Page {
    public String baseUrl;
public WebDriver driver;

	private WebElement webElement;


    //Days

    @FindBy(xpath = "//*[@id='menu']/div[@key='3']/div[1]/input")
    WebElement kashaPshenayaCheckbox;
    @FindBy(xpath = "//*[@id='menu']/div[@key='3']/div[2]/input")
    WebElement borjchCheckbox;
    @FindBy(xpath = "//*[@id='menu']/div[@key='3']/div[3]/input")
    WebElement otbivnayaCheckbox;
    @FindBy(xpath = "//*[@id='menu']/div[@key='3']/div[4]/input")
    WebElement pureCheckbox;
    @FindBy(xpath = "//*[@id='menu']/div[@key='3']/div[5]/input")
    WebElement chlebCheckbox;


    public WedensdayPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }


    public WedensdayPage clickToKasha() {
        kashaPshenayaCheckbox.click();
        return this;
    }

    public WedensdayPage clickToBorjch() {
        borjchCheckbox.click();
        return this;
    }
    public WedensdayPage clickToOtbivnaya(){
        otbivnayaCheckbox.click();
        return this;
    }

    public WedensdayPage clickToPure(){
        pureCheckbox.click();
        return this;
    }

    public WedensdayPage clickToCHleb(){
        chlebCheckbox.click();
        return this;
    }



//    public MainPage clickOnSignUpDoctorButton() {
//        clickElement(doctorButton);
//        return this;
//    }


}

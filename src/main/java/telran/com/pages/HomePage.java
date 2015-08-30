package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends Page {
    public String baseUrl;

  @FindBy(how = How.TAG_NAME, using = "h1")
  public WebElement header;

    //buttons
  @FindBy(xpath = "//*[@id='home_banner_small']//a[@class='landing_button']")
  WebElement freeSignUpButton;

    //lables
    @FindBy(xpath = "//*[@id='home_banner_small']/h1")
    WebElement titleLable;

  @FindBy(xpath = "//*[@class='btn btn-header btn-md navbar-btn' and contains(.,'Login')]")
  WebElement loginButton;

//  @FindBy(xpath = "//*[@class='col-md-6']//a[contains(text(),'Sign Up as a Healthcare Professional')]")
//    WebElement doctorButton;

    //private String label;

    public HomePage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage() {
        driver.get(PAGE_URL);
        return this;
    }

    public void waitUntilHomePageIsLoaded() {
        try {
            waitUntilElementIsLoaded(titleLable);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isOnHomePage() {
        return exists(titleLable);
    }

    public HomePage clickOnLogin(){
        clickElement(loginButton);
        return this;
    }

//    public HomePage clickOnSignUpDoctorButton() {
//        clickElement(doctorButton);
//        return this;
//    }


}

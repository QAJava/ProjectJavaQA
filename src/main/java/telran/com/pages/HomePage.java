package telran.com.pages;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class HomePage extends Page {
    public String baseUrl;


	private WebElement webElement;

  @FindBy(how = How.TAG_NAME, using = "h1")

 WebElement Days;
 WebElement header;
	@FindBy(id = "days")
	private WebElement days;


    //Days

    @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[1]/input")
    WebElement kashaMannayaMo;


    @FindBy(id = "days")
	protected WebElement days;

    @FindBy(id = "orderSum")
    protected WebElement orderSum;

	@FindBy(id = "makeOrder")
    protected WebElement makeOrderButton;

	@FindBy(xpath = "//*[@id='history']/li[last()]")
    protected WebElement currentOrderHistory;

	@FindBy(linkText = "Начать заново")
    protected WebElement startOverLink;

	@FindBy(id = "account")
	private WebElement accountSum;


    public HomePage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage() {
        driver.get(PAGE_URL);
        return this;
    }
	@FindBy(id = ".//*[@id='account']")
	private WebElement accountSum;


public HomePage clickToMakeOrder (){
    clickElement(makeOrderButton);
    return this;
}


    public HomePage selectDay (String day){
        new org.apache.bcel.generic.Select(days).selectByVisibleText(day);
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


//    public HomePage clickOnSignUpDoctorButton() {
//        clickElement(doctorButton);
//        return this;
//    }


}

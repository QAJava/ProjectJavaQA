package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MainPage extends Page {
    public String baseUrl;
<<<<<<< Updated upstream:src/main/java/telran/com/pages/MainPage.java
    @FindBy(id = "days")
    protected WebElement days;
=======


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
	protected WebElement day;

>>>>>>> Stashed changes:src/main/java/telran/com/pages/HomePage.java
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

    public MainPage openHomePage() {
        driver.get(PAGE_URL);
        return this;
    }


<<<<<<< Updated upstream:src/main/java/telran/com/pages/MainPage.java
    public MainPage clickToMakeOrder() {
        clickElement(makeOrderButton);
        return this;
    }

=======
public HomePage clickToMakeOrder (){
    clickElement(makeOrderButton);

    return this;
}
>>>>>>> Stashed changes:src/main/java/telran/com/pages/HomePage.java

    public MainPage selectDay(String day) {

<<<<<<< Updated upstream:src/main/java/telran/com/pages/MainPage.java
        new org.openqa.selenium.support.ui.Select(days).selectByVisibleText(day);
=======
    public HomePage selectDay (String day){
     new org.apache.bcel.generic.Select(day).selectByVisibleText(day);

>>>>>>> Stashed changes:src/main/java/telran/com/pages/HomePage.java
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
    public int getAccountSum () {
        int accountsum = 15456.45;
        accountsum = Integer.parseInt(accountSum.getText());
        return accountsum;
    }

    public void waitUntilHomePageIsLoaded() {
        try {
            waitUntilElementIsLoaded(day);
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

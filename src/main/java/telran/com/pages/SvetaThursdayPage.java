package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class SvetaThursdayPage extends Page{
	@FindBy(id = "//*[@id='menu']/div[@key='4']/div[1]/input")
	WebElement salatCheckbox;
	@FindBy(id = "//*[@id='menu']/div[@key='4']/div[2]/input")
	WebElement shiCheckbox;
    @FindBy(id = "//*[@id='menu']/div[@key='4']/div[1]/input")
    WebElement zharkoeCheckbox;
    @FindBy(id = "//*[@id='menu']/div[@key='4']/div[1]/input")
    WebElement hlebheckbox;
	@FindBy(id = "//*[@id='days']")
	WebElement days;
	@FindBy(id = "orderSum")
	WebElement orderSum;
    @FindBy(id = "makeOrder")
    private WebElement makeOrderLink;
    @FindBy(id = "account")
    private WebElement account;
	@FindBy(linkText = "Начать заново")
	private WebElement startOverLink;

    public SvetaThursdayPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void clickToSalat(){
        clickElement(salatCheckbox);
    }
    public void clickToShi(){
        clickElement(shiCheckbox);
    }
    public void clickToZharkoe(){
        clickElement(zharkoeCheckbox);
    }
    public void clickToHleb(){
        clickElement(hlebheckbox);
    }
public void clickToMakeOrder(){
    clickElement(makeOrderLink);
}
    public void clickToStartOver(){
        clickElement(startOverLink);
    }


    public double getOrderSum() {
        double ordersum = 0;
        ordersum = Double.parseDouble(orderSum.getText());
        return ordersum;
    }
    public SvetaThursdayPage selectDay(String day) {

      days.click();
        new Select(days).selectByVisibleText(day);

        return this;
    }



}

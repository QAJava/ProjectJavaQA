package telran.com.pagesRoman;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePageRoman extends PageRoman{

	@FindBy(linkText = "Начать заново")
	protected WebElement startOverLink;

	@FindBy(id = "account")
	protected WebElement account;

	@FindBy(id = "days")
	protected WebElement days;

	@FindBy(id = "orderSum")
	protected WebElement orderSum;

	@FindBy(id = "makeOrder")
	protected WebElement makeOrderButton;

	@FindBy(xpath = "//*[@id='history']/li[last()]")
	protected WebElement currentOrderHistory;


	public HomePageRoman(WebDriver dr, String url){
		super(dr, url);
		PageFactory.initElements(super.driver, this);
	}

	public void startOver(){
	//	startOverLink.click();
		super.clickElement(startOverLink);
	}

	public float getInitAccount() {
		String accountText = account.getText();
		accountText = accountText.replace(" ","");
		return Float.parseFloat(accountText);
	}

	public float getCurrentAccount(){
		return Float.parseFloat(account.getText());
	}

	public void selectDay(String day){
		Select selectDay = new Select(days);
		selectDay.selectByVisibleText(day);
//		new Select(days).selectByVisibleText(day);
	}

	public int viewOrderSum(){
		return Integer.parseInt(orderSum.getText());

	}
	public void clickToMakeOrder(){
		super.clickElement(makeOrderButton);
	}





}

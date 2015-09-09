package telran.com.pagesRoman;

import org.junit.Assert;
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

	public HomePageRoman() {}

	public HomePageRoman(WebDriver dr, String url){
		super(dr, url);
		PageFactory.initElements(dr, this);
	}

	public void startOver(){
		super.clickElement(startOverLink);
	//      Second solution:
	//	startOverLink.click();
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

	public void checkOrderSum(String actualSum){
		Float currentSum = Float.parseFloat(orderSum.getText());
		Float sum = Float.parseFloat(actualSum);
		Assert.assertEquals(sum, currentSum);
	}

	public void clickToMakeOrder(){
		super.clickElement(makeOrderButton);
	}

	public void checkTextInHistory(String text){
		String currentHistory = currentOrderHistory.getText();
		Assert.assertTrue( currentHistory.toLowerCase().contains(text.toLowerCase()));

	}




}

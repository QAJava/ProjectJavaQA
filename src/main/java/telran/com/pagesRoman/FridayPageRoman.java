package telran.com.pagesRoman;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FridayPageRoman extends PageRoman {

	@FindBy(xpath = "//*[@id='menu']/div[@key='5']/div[1]/input")
	WebElement salat;

	@FindBy(xpath = "(//*[@id='menu']/div[@key='5']//input[@type='checkbox'])[2]")
	WebElement lagman;

	@FindBy(xpath = "//*[@id='menu']/div[@key='5']/div[3]/input")
	WebElement befsrtrog;

	@FindBy(xpath = "(//*[@id='menu']/div[@key='5']//input[@type='checkbox'])[4]")
	WebElement kapusta;

	@FindBy(xpath = "//*[@id='menu']/div[@key='5']/div[5]/input")
	WebElement hleb;


	public FridayPageRoman(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickToSalat(){
		super.clickElement(salat);
	}

	public void clickToLagman(){
		super.clickElement(lagman);
	}

	public void clickToBefsrtrog(){
		super.clickElement(befsrtrog);
	}

	public void clickToKapusta(){
		super.clickElement(kapusta);
	}

	public void clickToHleb(){
		clickElement(hleb);
	}

}

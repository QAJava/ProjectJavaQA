package telran.com.pagesRoman;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;


public class MondayPageRoman extends PageRoman {

	@FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[1]/input")
	WebElement kashaMannaya;
	@FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[2]/input")
	WebElement yaichnitsa;
	@FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[2]/input")
	WebElement checkBoxYaichnitsa;
	@FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[3]/input")
	WebElement shvedStol;
	@FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[4]/input")
	WebElement plov;


	public MondayPageRoman(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickToKashaMannaya(){
		super.clickElement(kashaMannaya);
	}

	public void clickToYaichnitsa(){
		super.clickElement(yaichnitsa);
	}

	public void clickToShvedStol (){
		super.clickElement(shvedStol);
	}
	public void clickToPlov(){
		super.clickElement(plov);
	}

	public boolean yaichnitsaIsSelected(){
    	return yaichnitsa.isSelected();
    }

	public boolean isMondayMenuDisplayed(){
		WebElement el;
		try {
			el = driver.findElement(By.xpath("//*[@id='menu']/div[@key='1']"));
		} catch(NoSuchElementException e) {
			return false;
		}
		return el.isDisplayed();
	}
}

package telran.com.pagesRoman;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ThursdayPageRoman extends PageRoman {

	@FindBy(xpath = "//*[@id='menu']/div[@key='4']/div[1]/input")
	WebElement salatTh;

	@FindBy(xpath = "//*[@id='menu']/div[@key='4']/div[2]/input")
	WebElement shiTh;

	@FindBy(xpath = "//*[@id='menu']/div[@key='4']/div[3]/input")
	WebElement zharkoeTh;

	@FindBy(xpath = "//*[@id='menu']/div[@key='4']/div[4]/input")
	WebElement hlebTh;

	public ThursdayPageRoman(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickToSalat(){
		super.clickElement(salatTh);
	}

	public void clickToShi(){
		super.clickElement(shiTh);
	}

	public void clickToZharkoeTh(){
		super.clickElement(zharkoeTh);
	}

	public void clickToHleb(){
		super.clickElement(hlebTh);
	}

}

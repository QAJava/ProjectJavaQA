package telran.com.pagesRoman;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageRoman {

	protected WebDriver driver;
	protected String url;

	public PageRoman() {}

	public PageRoman(WebDriver dr){
		this.driver = dr;
	}

	public PageRoman(WebDriver dr, String url){
		this.driver = dr;
		this.url = url;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public void openPage(){
		driver.get(this.url);
	}

	public void clouseBrowser(){
		driver.quit();
	}

	public void clickElement(WebElement el){
		el.click();
	}


}

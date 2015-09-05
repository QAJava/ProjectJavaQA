package telran.com.testsRoman;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import telran.com.pagesRoman.FridayPageRoman;
import telran.com.pagesRoman.HomePageRoman;

public class RomanMenu968Test {

	private HomePageRoman homePage;
	private FridayPageRoman fridayPage;

	@BeforeTest
	public void setUp() throws Exception{
		WebDriver driver = new FirefoxDriver();
		String url = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
		homePage = new HomePageRoman(driver, url);
		fridayPage = new FridayPageRoman(driver);
	}

	@Test
	public void testMenu968(){
		homePage.openPage();
		float initAccount = homePage.getInitAccount();
		homePage.selectDay("пятница");
		fridayPage.clickToBefsrtrog();
		fridayPage.clickToKapusta();
		homePage.clickToMakeOrder();
		float currentAccount = homePage.getCurrentAccount();
		Assert.assertEquals((int)(initAccount - currentAccount), 95);
//		Assert.assertEquals(Math.round(initAccount - currentAccount), 95);
	}

	@AfterTest
	public void tearDown() throws Exception{
		homePage.clouseBrowser();
	}

}

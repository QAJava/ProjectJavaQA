package tellran;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import telran.com.pagesRoman.HomePageRoman;
import telran.com.pagesRoman.MondayPageRoman;

import java.util.concurrent.TimeUnit;

public class RomanMenu462Test {

	private HomePageRoman homePage;
	private MondayPageRoman mondayPage;

	@BeforeTest
	public void setUp() throws Exception{
		WebDriver driver = new FirefoxDriver();
		String url = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = new HomePageRoman(driver, url);
		mondayPage = new MondayPageRoman(driver);
	}

	@Test
	public void testMenu462(){
		homePage.openPage();
		float initAccount = homePage.getInitAccount();
		homePage.selectDay("понедельник");
		mondayPage.clickToShvedStol();
		mondayPage.clickToPlov();
		homePage.clickToMakeOrder();
		float currentAccount = homePage.getCurrentAccount();
		Assert.assertEquals((int)(initAccount - currentAccount), 450);
	}

	@AfterTest
	public void tearDown() throws Exception{
		homePage.clouseBrowser();
	}

}

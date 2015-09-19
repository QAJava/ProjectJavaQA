package tellran;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import telran.com.pagesRoman.HomePageRoman;
import telran.com.pagesRoman.MondayPageRoman;

public class RomanMenu1029Test {

	private HomePageRoman homePage;
	private MondayPageRoman mondayPage;

	@BeforeTest
	public void setUp() throws Exception{
		WebDriver driver = new FirefoxDriver();
		String url = "https://kontur.ru/Files/userfiles/file/edu/Stagirovka%202012/test/default.html";
		mondayPage = new MondayPageRoman(driver);
		homePage = new HomePageRoman(driver, url);

//		homePage = PageFactory.initElements(driver, HomePageRoman.class);
//		homePage.setDriver(driver);
//		homePage.setUrl(url);

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testMenu1029(){
		homePage.openPage();
		homePage.selectDay("понедельник");
		Assert.assertFalse(mondayPage.yaichnitsaIsSelected());
		mondayPage.clickToYaichnitsa();
		Assert.assertTrue(mondayPage.yaichnitsaIsSelected());
		mondayPage.clickToShvedStol();
		homePage.checkOrderSum("420");
		homePage.clickToMakeOrder();
		homePage.checkTextInHistory("понедельник");
		homePage.checkTextInHistory("Шведский стол");
		homePage.checkTextInHistory("370");
		homePage.selectDay("пятница");
		Assert.assertFalse(mondayPage.isMondayMenuDisplayed());
	}

	@AfterTest
	public void tearDown() throws Exception{
		homePage.clouseBrowser();
	}

}

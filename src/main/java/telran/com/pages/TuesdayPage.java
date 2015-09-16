package telran.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TuesdayPage extends Page {
        public String baseUrl;

        private WebElement webElement;
        public final int DISCOUNT = 50;

        public static String time;   //time variable.
        public static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");   //DateFormat variable.

        /**
         * Days of TuesdayPage area
         */

        @FindBy(xpath = "//*[@id='menu']/div[@key='2']/div[1]/input")
        WebElement salatCaesar;
        @FindBy(xpath = "//*[@id='menu']/div[@key='2']/div[2]/input")
        WebElement supPureBroccoli;
        @FindBy(xpath = "//*[@id='menu']/div[@key='2']/div[3]/input")
        WebElement raguSvininy;
        @FindBy(xpath = "//*[@id='menu']/div[@key='2']/div[4]/input")
        WebElement hleb;
        /**
         * Elements of TuesdayPage area
         */
        @FindBy(id = "days")
        protected WebElement days;

        @FindBy(id = "orderSum")
        protected WebElement orderSum;
        /**
         * Button of TuesdayPage area
         */
        @FindBy(id = "makeOrder")
        protected WebElement makeOrderButton;


        @FindBy(xpath = "//*[@id='history']/li[last()]")
        protected WebElement currentOrderHistory;


        public TuesdayPage(WebDriver driver) {
            super(driver);
            this.PAGE_URL = baseUrl;
            PageFactory.initElements(driver, this);
        }


        public TuesdayPage openMainPage() {
            driver.get(PAGE_URL);
            return this;
        }


        static String getTime()
        {
            Calendar cal = Calendar.getInstance();
            time = dateFormat.format(cal.getTime());   //Getting the current system time.
            return time;
        }



        public TuesdayPage clickToSalatCaesar(){
            salatCaesar.click();
            return this;
        }


        public TuesdayPage clickToSupPureBroccoli(){
            supPureBroccoli.click();
            return this;
        }


        public TuesdayPage clickToRaguSvininy(){
            raguSvininy.click();
            return this;
        }


        public TuesdayPage clickToHleb() {
            hleb.click();
            return this;
        }


        public void checkTextInReport (String  text){
            String locator = "//*[@id='history']/li[last()][contains(text(),'"+ text+"')]";
            WebElement element = driver.findElement(By.xpath(locator));
           //assertTrue("Text " +text+ " is not present in Menu report",element.isDisplayed());
        }

        public TuesdayPage checkThatSalatDisplyed(String message) {
            checkIfDisplayed(salatCaesar, message);

            return this;
        }


        public void waitUntilMainPageIsLoaded() {
            try {
                waitUntilElementIsLoaded(days);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}



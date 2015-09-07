package telran.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class SaturdayPageIgor extends Page  {

        public String baseUrl;


        private WebElement webElement;

        public SaturdayPageIgor(WebDriver webDriver, String baseUrl) {
            super(webDriver);
            this.baseUrl = baseUrl;
        }

        @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[1]/input")
        private WebElement kashaMannaya;
        @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[2]/input")
        private WebElement yaichniza;
        @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[3]/input")
        private WebElement shwedskyStol;
        @FindBy(xpath = "//*[@id='menu']/div[@key='1']/div[4]/input")
        private WebElement plow;

        @FindBy(id = "days")
        protected WebElement days;

        @FindBy(id = "orderSum")
        protected WebElement orderSum;

        public SaturdayPageIgor(WebDriver driver) {
            super(driver);
            this.PAGE_URL = baseUrl;
            PageFactory.initElements(driver, this);
        }

        public SaturdayPageIgor openmainPage() {
            driver.get(PAGE_URL);
            return this;
        }

        public SaturdayPageIgor clickToCheckboxKasha() {
            kashaMannaya.click();
            return this;
        }




        public float getOrderSum() {
            float ordersum = 0;
            ordersum = Float.parseFloat(orderSum.getText());
            return ordersum;
        }

        public void waitUntilmainPageIsLoaded() {
            try {
                waitUntilElementIsLoaded(days);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




package pages;

import drivers.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_postcode")
    private WebElement zipcode;

    @FindBy(id = "billing_city")
    private WebElement townName;

    @FindBy(css = "#order_review > table > tfoot > tr.order-total > td > strong > span > bdi")
    private WebElement totalAmount;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    @FindBy(css = "#post-207 > header >h1")
    private WebElement orderStatus;


    public void provideBillingDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(address));

        address.sendKeys();
    }

    public String getTotalAmount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(totalAmount));

        return totalAmount.getText();
    }

    public void placeOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(placeOrderButton));

        placeOrderButton.click();
    }

    public String getOrderStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(orderStatus));

        return orderStatus.getText();
    }


}

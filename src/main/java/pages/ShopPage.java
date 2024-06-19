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

public class ShopPage {

    private WebDriver driver;

    public ShopPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#main > ul > li:nth-child(2) > a.button")
    private WebElement addToCartButton;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a > span")
    private WebElement numberOfProducts;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a")
    private WebElement cartButton;


    public void addElementToCart(){
        String previousNumbrer = numberOfProducts.getText();
        addToCartButton.click();

        if(numberOfProducts.getText().equals(previousNumbrer)){
            System.out.println("Cart has been updated");
        }
        else {
            System.out.println("Cart has not been updated");
        }
    }

    public void proceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));

        cartButton.click();
    }
}

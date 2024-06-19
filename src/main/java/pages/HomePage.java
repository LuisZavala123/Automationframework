package pages;

import drivers.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#menu-item-2330 > a")
    WebElement loginButton;

    @FindBy(css = "#menu-item-1310 > a")
    WebElement shopButton;

    @FindBy(css = "#menu-item-2333 > a")
    WebElement username;

    public void clickLogIn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public String getUsername(){
        return username.getText();
    }
}

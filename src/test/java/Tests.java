import drivers.strategies.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Constants;
import utils.FrameworkProperties;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SingnInPage singnInPage;
    static CheckoutPage checkoutPage;
    static ShopPage shopPage;
    static CartPage cartPage;

    @BeforeAll
    public static void initializeObjects(){
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.CHROME));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        singnInPage = new SingnInPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterAll
    public static void closeObjects(){
        driver.close();
    }

    @Test
    public void testingAutentication(){
        driver.get(Constants.URL);
        homePage.clickLogIn();
        singnInPage.login(frameworkProperties.getProperty(Constants.EMAIL),frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME),homePage.getUsername());
    }


}

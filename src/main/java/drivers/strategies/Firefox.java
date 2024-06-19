package drivers.strategies;

import drivers.DriverStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {
    @Override
    public WebDriver setStrategy() {
        System.setProperty("webdriver.gecko.driver", "src/main/geckodriver.exe");

        return new FirefoxDriver();
    }
}

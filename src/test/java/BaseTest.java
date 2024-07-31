import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public  WebDriver driver;
public static final String BROWSER_NAME_ENV_VARIABLE = "BROWSER_NAME";
    enum Browser {
        CHROME,FIREFOX
    }

    WebDriver getWebDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new RuntimeException("unable to create web driver");
        }
    }
    // Браузер для тестов
    @Test
    public void setUp() {
String browserName = System.getenv(BROWSER_NAME_ENV_VARIABLE);
driver = getWebDriver(Browser.valueOf(browserName));



        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    // Закрыть браузер
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }

}


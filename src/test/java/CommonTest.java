import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonTest {
    WebDriver driver;

    // Браузер для тестов
    @Test
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();



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


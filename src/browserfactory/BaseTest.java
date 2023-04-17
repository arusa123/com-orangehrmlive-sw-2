package browserfactory;

import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void setBrowser(String baseURL) {
        driver = new ChromeDriver();
        // launch url
        driver.get(baseURL);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void closeBrowser() {
        driver.quit();
    }


}

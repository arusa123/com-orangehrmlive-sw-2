package testsuite;

import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    String baseurl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp() {
        driver.get(baseurl);
    }

    //Launch chrome browser
    WebDriver driver = new ChromeDriver();
    //open the baseurl


    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //implicity wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //entering the username
        driver.findElement(By.name("username")).sendKeys("Admin");
        // entering the password in password field
        driver.findElement(By.name("password")).sendKeys("admin123");
        //finding the click button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //expected element
        String expectedResult = "Dashboard";

        //actual textElement xpath
        String actualTextElement = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals("Login sucessfully", actualTextElement, expectedResult);

    }

    // closing browser
    @After
    public void tearDown() {
        driver.close();
    }
}


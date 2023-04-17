package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ForgotPasswordTest {
    String baseurl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    //WebDriver driver;

    @Before
    public void setUp() {
        driver.get(baseurl);
    }

    //Launch chrome browser
    WebDriver driver = new ChromeDriver();
    //open the baseurl

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        //implicity wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //finding the forgot password link
        WebElement forgotButton = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotButton.click();
        //expected element
        String expectedElement = "Reset Password";
        //actual element
        String actualTextElement = driver.findElement(By.xpath("//h6[@class= 'oxd-text oxd-text--h6 orangehrm-forgot-password-title']"))
                .getText();
        Assert.assertEquals("Rest the password", actualTextElement, expectedElement);

    }

    @After
    public void tearDown() {
        driver.close();
    }

}





















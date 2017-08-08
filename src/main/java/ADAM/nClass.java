package ADAM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class nClass {
    private WebDriver webDriver;
    private LoginPage loginPage;


    @Before
    public void bef() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.out.println("Before");
        webDriver = new ChromeDriver(options);
        loginPage= PageFactory.initElements(webDriver,LoginPage.class);

    }

    @Test
    public void tes() {
        System.out.println("Test");
        webDriver.navigate().to("http://thedemosite.co.uk/addauser.php");
        loginPage.enterUsername("nichharp");
        loginPage.enterPassword("adamsux");
        loginPage.clickButton();

        loginPage.wait("b:nth-child(1)");



//        webDriver.navigate().to("http://thedemosite.co.uk/login.php");
        loginPage.enterUsername("nichharp");
        loginPage.enterPassword("adamsux");
        loginPage.clickButton();
    }

    @After
    public void aft(){
        System.out.println("After");
        webDriver.quit();
    }

}

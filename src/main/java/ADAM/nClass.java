package ADAM;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.aventstack.extentreports.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class nClass {
    private WebDriver webDriver;
    private LoginPage loginPage;
    private Screenshott screenshot;
//    private static ExtentReportManager reportManager;
    private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "test.HTML";

    @BeforeClass
    public static void init(){}

    @Before
    public void bef() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        report= new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("Look at how well it ran!");
        extentHtmlReporter.config().setDocumentTitle("Document YEY!");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("Will it Run?");

        System.out.println("Before");
        webDriver = new ChromeDriver(options);
        loginPage= PageFactory.initElements(webDriver,LoginPage.class);

        screenshot = PageFactory.initElements(webDriver, Screenshott.class);
    }

    @Test
    public void tes() {
        System.out.println("Test");
        webDriver.navigate().to("http://thedemosite.co.uk/addauser.php");
        loginPage.enterUsername("nichharp");
        loginPage.enterPassword("adamsux");
        loginPage.clickButton();

//        loginPage.wait("b:nth-child(1)");
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
//                .withTimeout(20, TimeUnit.SECONDS)
//                .pollingEvery(10, TimeUnit.SECONDS)
//                .ignoring(NoSuchElementException.class);
//        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.cssSelector("b:nth-child(1)"));
//            }
//        });


//        webDriver.navigate().to("http://thedemosite.co.uk/login.php");
        loginPage.enterUsername("nichharp");
        loginPage.enterPassword("adamsux");

        try {
            test.addScreenCaptureFromPath(screenshot.take(webDriver, "take1")); //because take returns a filepath!!!!
        } catch (IOException e) {
            e.fillInStackTrace();
        }

        loginPage.clickButton();

        test.log(Status.INFO, "Info Level");
        test.pass("Pass");


    }

    @After
    public void aft(){
        System.out.println("After");
        webDriver.quit();
//        tests.clear();
        report.flush();
    }

}

package ADAM;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.aventstack.extentreports.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.concurrent.TimeUnit;

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
        Actions mousey = new Actions(webDriver);
        System.out.println("test started");
        webDriver.navigate().to("http://www.demoqa.com");
        loginPage.draggableClick();
        mousey.moveToElement(webDriver.findElement(By.xpath("//*[@id=\'draggable\']"))).clickAndHold().moveByOffset(100, 100).release().perform();
//        test.log(Status.INFO, "Info Level");
//        test.pass("Pass");
//    }

//    @Test
//    public void tesAgain() {
//        Actions mousey = new Actions(webDriver);
        loginPage.sortableClick();
        loginPage.dispAsGridClick();
        WebElement One = webDriver.findElement(By.xpath("//*[@id=\'sortable_grid\']/li[1]"));

        System.out.println(One.getLocation());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        mousey.moveToElement(One).clickAndHold().moveByOffset(200,2).perform();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        System.out.println(One.getLocation());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        mousey.release().perform();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        System.out.println(One.getLocation());

//        SheetReader sheetReader = new SheetReader("C:\\Users\\Administrator\\IdeaProjects\\SeleniumProject\\src\\main\\resources\\DisSheet.xlsx");
//        System.out.println("Test");
//        webDriver.navigate().to("http://thedemosite.co.uk/addauser.php");
//        List<String> row = sheetReader.readRow(1, "Sheet1");
//        loginPage.enterUsername(row.get(2));
//        loginPage.enterPassword(row.get(3));
//        loginPage.clickButton();
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
//        loginPage.enterUsername(row.get(2));
//        loginPage.enterPassword(row.get(3));
        try {test.addScreenCaptureFromPath(screenshot.take(webDriver, "take1")); //because take returns a filepath!!!!
        } catch (IOException e) {e.fillInStackTrace();}
//        loginPage.clickButton();
//
//        assert eOne
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

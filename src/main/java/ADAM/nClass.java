package ADAM;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sun.javafx.image.IntPixelGetter;
import org.junit.*;
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
    private static ExtentReports report;
    private ExtentTest test;
    private static String reportFilePath = "test.HTML";

    @BeforeClass
    public static void init(){
        report= new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("Look at how well it ran!");
        extentHtmlReporter.config().setDocumentTitle("Document YEY!");
        report.attachReporter(extentHtmlReporter);


    }

    @Before
    public void bef() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        test = report.createTest("Will it Run?");
        System.out.println("Before");
        webDriver = new ChromeDriver(options);
        loginPage= PageFactory.initElements(webDriver,LoginPage.class);
        screenshot = PageFactory.initElements(webDriver, Screenshott.class);
    }

    @Test
    public void tes() {
        Actions mousey = new Actions(webDriver);
        SheetReader sheetReader = new SheetReader("C:\\Users\\Administrator\\IdeaProjects\\SeleniumProject\\src\\main\\resources\\DisSheet.xlsx");
        System.out.println("test started");


        webDriver.navigate().to("http://www.demoqa.com");
        loginPage.draggableClick();
        mousey.moveToElement(webDriver.findElement(By.xpath("//*[@id=\'draggable\']"))).clickAndHold().moveByOffset(100, 0).release().perform();
        mousey.moveToElement(webDriver.findElement(By.xpath("//*[@id=\'draggable\']"))).clickAndHold().moveByOffset(0, 100).release().perform();

//        test.log(Status.INFO, "Info Level");
        test.pass("Pass");
    }

    @Test
    public void tes2() {
                Actions mousey = new Actions(webDriver);
        SheetReader sheetReader = new SheetReader("C:\\Users\\Administrator\\IdeaProjects\\SeleniumProject\\src\\main\\resources\\DisSheet.xlsx");
        System.out.println("test2 started");
        webDriver.navigate().to("http://www.demoqa.com");


        loginPage.sortableClick();
        loginPage.dispAsGridClick();


        for (int i =1;i<12;i++) {
            List<String> row = sheetReader.readRow(i, "Sheet1");
            mousey.moveToElement(webDriver.findElement(By.xpath("//*[@id='sortable_grid']/li[12]"))).clickAndHold().moveByOffset(0,Integer.valueOf(row.get(2).substring(0, row.get(2).length() - 2))).perform();

            if (i!=4 & i!=8){
                mousey.moveToElement(webDriver.findElement(By.xpath("//*[@id='sortable_grid']/li[12]"))).clickAndHold().moveByOffset(Integer.valueOf(row.get(3).substring(0, row.get(3).length() - 2)), 0).perform();
            }
            mousey.release().perform();
        }
//        test.log(Status.INFO, "Info Level");
        test.pass("Pass");
    }


    @Test
    public void tes3() {
        Actions mousey = new Actions(webDriver);
        SheetReader sheetReader = new SheetReader("C:\\Users\\Administrator\\IdeaProjects\\SeleniumProject\\src\\main\\resources\\DisSheet.xlsx");
        System.out.println("test3 started");
        webDriver.navigate().to("http://www.demoqa.com");

        loginPage.selectableClick();
        loginPage.serializeClick();
        List<String> row = sheetReader.readRow(12, "Sheet1");
        mousey.moveToElement(webDriver.findElement(By.xpath("//*[@id=\'selectable-serialize\']/li[1]"))).perform();
        row = sheetReader.readRow(13, "Sheet1");
        mousey.clickAndHold().moveByOffset(Integer.valueOf(row.get(2).substring(0, row.get(2).length() - 2)), Integer.valueOf(row.get(3).substring(0, row.get(3).length() - 2))).perform();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (Exception e) {
//            e.fillInStackTrace();
//        }
        mousey.release().perform();
//        test.log(Status.INFO, "Info Level");


        if (webDriver.getPageSource().contains("#1#2#3")) {
            test.pass("Pass");
        } else {
            test.pass("Fail");
        }
    }

    @Test
    public void tes4() {
        Actions mousey = new Actions(webDriver);
        SheetReader sheetReader = new SheetReader("C:\\Users\\Administrator\\IdeaProjects\\SeleniumProject\\src\\main\\resources\\DisSheet.xlsx");
        System.out.println("test4 started");
        webDriver.navigate().to("http://www.demoqa.com");
        loginPage.sliderClick();
        List<String> row = sheetReader.readRow(14, "Sheet1");
        mousey.moveToElement(webDriver.findElement(By.xpath("//*[@id=\'slider-range-max\']/span"))).perform();
        mousey.clickAndHold().moveByOffset(Integer.valueOf(row.get(2).substring(0, row.get(2).length() - 2)), Integer.valueOf(row.get(3).substring(0, row.get(3).length() - 2))).perform();
        try {
            test.addScreenCaptureFromPath(screenshot.take(webDriver, "take1")); //because take returns a filepath!!!!
        } catch (IOException e) {
            e.fillInStackTrace();
        }
//        test.log(Status.INFO, "Info Level");

        if (webDriver.getPageSource().contains("9")) {
            test.pass("Pass");
        } else {
            test.pass("Fail");
        }
//        assert  (webDriver.findElement(By.xpath("//*[@id='select-result']"))) == "#1#2#3") ;

//        loginPage.enterUsername(row.get(2));
//        loginPage.enterPassword(row.get(3));
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

//        loginPage.clickButton();
//
//        assert eOne
//        test.log(Status.INFO, "Info Level");
//        test.pass("Pass");
    }

    @After
    public void aft(){
        System.out.println("After");
        try {test.addScreenCaptureFromPath(screenshot.take(webDriver, "take1")); //because take returns a filepath!!!!
        } catch (IOException e) {e.fillInStackTrace();}
        test.log(Status.INFO, "Info Level");
        webDriver.quit();
        report.flush();
    }
    @AfterClass
    public static void aftcla(){
        System.out.println("After Class");

    }

}
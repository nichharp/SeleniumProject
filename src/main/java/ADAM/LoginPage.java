package ADAM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class LoginPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\'ui-id-3\']")
    private WebElement dispAsGridbutt;

    @FindBy(xpath = "//*[@id=\'menu-item-140\']/a")
    private WebElement draggablebutt;

    @FindBy(xpath = "//*[@id='menu-item-151\']/a")
    private WebElement sortablebutt;

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "FormsButton2")
    private WebElement submitButton;

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void clickButton() {
        submitButton.click();
    }
    public void draggableClick() {draggablebutt.click();}
    public void sortableClick() {sortablebutt.click();}
    public void dispAsGridClick() {dispAsGridbutt.click();}


//    public void wait(String findme) {
//        final findme;
//
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
//        .withTimeout(20, TimeUnit.SECONDS)
//        .pollingEvery(10, TimeUnit.SECONDS)
//        .ignoring(NoSuchElementException.class);
//    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//        public WebElement apply(WebDriver driver) {
//            return driver.findElement(By.cssSelector(findme));
//        }
//    });
//    }
}

package desktop.pages;

import abstractclasses.page.AbstractPage;
import desktop.fragments.NavigationBar;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constants.LOGIN_URL;

public class BookDepositoryLoginPage extends AbstractPage {


    public BookDepositoryLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@placeholder='Book Depository password']")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@style='display: block;']")
    private static WebElement clearEmailButton;

    @FindBy(xpath = "//*[@class='signin-iframe']")
    private WebElement sigInFrame;

    public BookDepositoryLoginPage openBookDepositoryLoginPage() {
        open(LOGIN_URL);
        return new BookDepositoryLoginPage(DriverManager.getDriver());
    }

    public BookDepositoryLoginPage switchToLogInFrame() {
        return new BookDepositoryLoginPage(DriverManager.getDriver().switchTo().frame(sigInFrame));
    }

    public BookDepositoryLoginPage setEmail(String str) {
        typeText(emailField, str);
        return this;
    }

    public BookDepositoryLoginPage setPassword(String str) {
        typeText(passwordField, str);
        return this;
    }

    public String getStyleClearEmailButton() {
        return clearEmailButton.getAttribute("style");
    }
}

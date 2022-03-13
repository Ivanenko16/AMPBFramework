package desktop.pages;

import abstractclasses.page.AbstractPage;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.Constants.LOGIN_URL;

public class BookDepositoryLoginPage extends AbstractPage {

    private static final String CLEAR_BUTTON_STYLE = "style";
    private static final String EMAIL = "tractor@gmail.com";
    private static final String BOOK_DEPOSITORY_PASSWORD = "1@#Asdfrest";
    private static final String NAME = "Valera";
    private static final String YOUR_EMAIL_ADDRESS = "as/red@gmail.com";
    private static final String CREATE_PASSWORD = "Qwerty12345&";

    public BookDepositoryLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@placeholder='Book Depository password']")
    private WebElement bookDepositoryPasswordField;

    @FindBy(xpath = "//*[@id='ap_customer_name']")
    private WebElement nameField;

    @FindBy(xpath = "//*[@placeholder='Your email address']")
    private WebElement yourEmailAddressField;

    @FindBy(xpath = "//*[@placeholder='Create a password']")
    private WebElement createAPasswordField;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@placeholder='Email']/..//div[@id='ap_email_icon']")
    private static WebElement clearEmailButton;

    @FindBy(xpath = "//*[@placeholder='Book Depository password']/..//div[@id='ap_password_icon']")
    private static WebElement clearBookDepositoryPasswordFieldButton;

    @FindBy(xpath = "//*[@id='ap_customer_name_icon']")
    private static WebElement clearNameFieldButton;

    @FindBy(xpath = "//*[@placeholder='Your email address']/..//div[@id='ap_email_icon']")
    private static WebElement clearYourEmailAddressFieldButton;

    @FindBy(xpath = "//*[@placeholder='Create a password']/..//div[@id='ap_password_icon']")
    private static WebElement clearCreateAPasswordFieldButton;

    @FindBy(xpath = "//*[@class='signin-iframe']")
    private WebElement sigInFrame;

    @FindBy(xpath = "//*[@class='register-iframe']")
    private WebElement registerFrame;

    public BookDepositoryLoginPage openBookDepositoryLoginPage() {
        open(LOGIN_URL);
        return new BookDepositoryLoginPage(DriverManager.getDriver());
    }

    public BookDepositoryLoginPage switchToLogInFrame() {
        return new BookDepositoryLoginPage(DriverManager.getDriver().switchTo().frame(sigInFrame));
    }

    public BookDepositoryLoginPage switchToRegisterFrame() {
        return new BookDepositoryLoginPage(DriverManager.getDriver().switchTo().frame(registerFrame));
    }

    public BookDepositoryLoginPage fillField(String field) {
        switch (field) {
            case "Email":
                emailField.click();
                typeText(emailField,EMAIL);
                break;
            case "BookDepositoryPassword":
                bookDepositoryPasswordField.click();
                typeText(bookDepositoryPasswordField, BOOK_DEPOSITORY_PASSWORD);
                break;
            case "Name":
                nameField.click();
                typeText(nameField,NAME);
                break;
            case "YourEmailAddress":
                yourEmailAddressField.click();
                typeText(yourEmailAddressField,YOUR_EMAIL_ADDRESS);
                break;
            case "CreateAPassword":
                createAPasswordField.click();
                typeText(createAPasswordField,CREATE_PASSWORD);
               break;
            default:
        }
        return this;
    }

    public String getStyleClearButton(String field) {
        String style = null;
        if ("Email".equals(field)) {
            style = clearEmailButton.getAttribute(CLEAR_BUTTON_STYLE);
        } else if ("BookDepositoryPassword".equals(field)) {
            style =  clearBookDepositoryPasswordFieldButton.getAttribute(CLEAR_BUTTON_STYLE);
        } else if ("Name".equals(field)) {
            style = clearNameFieldButton.getAttribute(CLEAR_BUTTON_STYLE);
        } else if ("YourEmailAddress".equals(field)) {
            style = clearYourEmailAddressFieldButton.getAttribute(CLEAR_BUTTON_STYLE);
        } else if ("CreateAPassword".equals(field)) {
            style = clearCreateAPasswordFieldButton.getAttribute(CLEAR_BUTTON_STYLE);
        }
        return style;
    }
}


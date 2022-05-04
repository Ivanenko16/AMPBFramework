package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.Constants.LOGIN_URL;

public class LoginPage extends AbstractFragment {

    private static final String EMAIL = "tractor@gmail.com";
    private static final String BOOK_DEPOSITORY_PASSWORD = "1@#Asdfrest";
    private static final String NAME = "Valera";
    private static final String YOUR_EMAIL_ADDRESS = "as/red@gmail.com";
    private static final String CREATE_PASSWORD = "Qwerty12345&";

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

    @FindBy(xpath = "//*[@id='ap_email_icon']")
    private static WebElement clearEmailButton;

    @FindBy(xpath = "//*[@id='ap_password_icon']")
    private static WebElement clearBookDepositoryPasswordFieldButton;

    @FindBy(xpath = "//*[@id='ap_customer_name_icon']")
    private static WebElement clearNameFieldButton;

    @FindBy(xpath = "//*[@id='ap_email_icon']")
    private static WebElement clearYourEmailAddressFieldButton;

    @FindBy(xpath = "//*[@id='ap_password_icon']")
    private static WebElement clearCreateAPasswordFieldButton;

    @FindBy(xpath = "//*[@class='signin-iframe']")
    private WebElement sigInFrame;

    @FindBy(xpath = "//*[@class='register-iframe']")
    private WebElement registerFrame;

    @FindBy(id = "continue")
    private WebElement createYourAccountButton;

    public LoginPage openBookDepositoryLoginPage() {
        open(LOGIN_URL);
        return new LoginPage();
    }

    public LoginPage switchToLogInFrame() {
        switchToIframe(sigInFrame);
        return new LoginPage();
    }

    public LoginPage switchToRegisterFrame() {
        switchToIframe(registerFrame);
        return new LoginPage();
    }

    public void fillField(String field) {
        if ("Email".equals(field)) {
            emailField.click();
            typeText(emailField, EMAIL);
        } else if ("BookDepositoryPassword".equals(field)) {
            bookDepositoryPasswordField.click();
            typeText(bookDepositoryPasswordField, BOOK_DEPOSITORY_PASSWORD);
        } else if ("Name".equals(field)) {
            nameField.click();
            typeText(nameField, NAME);
        } else if ("YourEmailAddress".equals(field)) {
            yourEmailAddressField.click();
            typeText(yourEmailAddressField, YOUR_EMAIL_ADDRESS);
        } else if ("CreateAPassword".equals(field)) {
            createAPasswordField.click();
            typeText(createAPasswordField, CREATE_PASSWORD);
        }
    }

    public void fillJoinField(String field, String data) {
        if ("Name".equals(field)) {
            nameField.click();
            typeText(nameField, data);
        } else if ("YourEmailAddress".equals(field)) {
            yourEmailAddressField.click();
            typeText(yourEmailAddressField, data);
        } else if ("CreateAPassword".equals(field)) {
            createAPasswordField.click();
            typeText(createAPasswordField, data);
        }
    }

    public Boolean clearButtonIsDisplayed(String field) {
        boolean isDisplayed = false;
        if ("Email".equals(field)) {
            isDisplayed = isDisplayed(clearEmailButton);
        } else if ("BookDepositoryPassword".equals(field)) {
            isDisplayed = isDisplayed(clearBookDepositoryPasswordFieldButton);
        } else if ("Name".equals(field)) {
            isDisplayed = isDisplayed(clearNameFieldButton);
        } else if ("YourEmailAddress".equals(field)) {
            isDisplayed = isDisplayed(clearYourEmailAddressFieldButton);
        } else if ("CreateAPassword".equals(field)) {
            isDisplayed = isDisplayed(clearCreateAPasswordFieldButton);
        }
        return isDisplayed;
    }

    public void clickClearButton(String field) {
        if ("Email".equals(field)) {
            click(clearEmailButton);
        } else if ("BookDepositoryPassword".equals(field)) {
            click(clearBookDepositoryPasswordFieldButton);
        } else if ("Name".equals(field)) {
            click(clearNameFieldButton);
        } else if ("YourEmailAddress".equals(field)) {
            click(clearYourEmailAddressFieldButton);
        } else if ("CreateAPassword".equals(field)) {
            click(clearCreateAPasswordFieldButton);
        }
    }

    public void registerNewAccount() {
        click(createYourAccountButton);
    }
}


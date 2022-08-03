package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static configuration.driver.DriverManager.getDriver;

public class PaymentDetailsPage extends AbstractFragment {

    @FindBy(xpath = "//strong[text()='Sub-total']/../following-sibling::dd")
    WebElement subTotal;

    @FindBy(xpath = "//strong[text()='Total']/../following-sibling::dd")
    WebElement total;

    @FindBy(xpath = "//strong[text()='VAT']/../following-sibling::dd")
    WebElement vat;

    @FindBy(xpath = "//*[@type='email']")
    WebElement emailField;

    @FindBy(xpath = "//*[@class='signin-iframe']")
    WebElement signInFrame;

    @FindBy(xpath = "//strong[text()='Delivery']/../following-sibling::dd")
    WebElement delivery;

    @FindBy(id = "delivery-fullName")
    WebElement fullName;

    @FindBy(id = "delivery-addressLine1")
    WebElement deliveryAddress1;

    @FindBy(id = "delivery-addressLine2")
    WebElement deliveryAddress2;

    @FindBy(id = "delivery-city")
    WebElement deliveryCity;

    @FindBy(id = "delivery-CountryDropdown")
    WebElement deliveryCountyDropdown;

    @FindBy(id = "delivery-county")
    WebElement deliveryCounty;

    @FindBy(id = "delivery-postCode")
    WebElement deliveryPostCode;

    @FindBy(name = "manualEntryButton")
    WebElement manualEntryButton;

    @FindBy(id = "credit-card-number")
    WebElement creditCardNumber;

    @FindBy(id = "expiration")
    WebElement expiryCardData;

    @FindBy(id = "cvv")
    WebElement cvvCard;

    @FindBy(className = "error-block")
    WebElement validationMessage;


    public String getTotal() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(total));
        return total.getText();
    }

    public String getSubTotal() {
        return subTotal.getText();
    }

    public String getVat() {
        return vat.getText();
    }

    public String getDelivery() {
        return delivery.getText();
    }

    public void fillEmail(String email) {

        switchToIframe(signInFrame);
        Actions builder = new Actions(getDriver());
        Action fillField = builder.click(emailField)
                .sendKeys(email)
                .build();
        fillField.perform();
        getDriver().switchTo().defaultContent();
    }

    public void expandManuallyEnter() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(manualEntryButton));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(manualEntryButton).click();
        Action action = builder.build();
        action.perform();
    }

    public void setFullName(String value) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", fullName);
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(fullName));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(fullName).click().sendKeys(value);
        Action action = builder.build();
        action.perform();
    }

    public void setDeliveryCountyDropdown(String value) {
        click(deliveryCountyDropdown);
        Select select = new Select(deliveryCountyDropdown);
        select.selectByVisibleText(value);
        getDriver().switchTo().defaultContent();
    }

    public void setAddress1(String value) {
        expandManuallyEnter();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(deliveryAddress1));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(deliveryAddress1).click().sendKeys(value);
        Action action = builder.build();
        action.perform();
    }

    public void setAddress2(String value) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(deliveryAddress2));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(deliveryAddress2).click().sendKeys(value);
        Action action = builder.build();
        action.perform();
    }

    public void setCity(String value) {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(deliveryCity).click().sendKeys(value);
        Action action = builder.build();
        action.perform();
    }

    public void setCountry(String value) {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(deliveryCounty).click().sendKeys(value);
        Action action = builder.build();
        action.perform();
    }

    public void setPostcode(String value) {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(deliveryPostCode).click().sendKeys(value);
        Action action = builder.build();
        action.perform();
    }

    public boolean checkAlertIsAppeared() {
        return validationMessage.isDisplayed();
    }

    public void enterCardNumber(String cardNumber) {
        switchToIframe(findElement(By.id("braintree-hosted-field-number")));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", creditCardNumber);
        creditCardNumber.click();
        creditCardNumber.sendKeys(cardNumber);
    }

    public void enterExpiryCardData(String expiryData) {
        getDriver().switchTo().defaultContent();
        switchToIframe(findElement(By.name("braintree-hosted-field-expirationDate")));
        expiryCardData.click();
        expiryCardData.sendKeys(expiryData);
    }

    public void enterCvvCardData(String cvv) {
        getDriver().switchTo().defaultContent();
        switchToIframe(findElement(By.name("braintree-hosted-field-cvv")));
        cvvCard.click();
        cvvCard.sendKeys(cvv);
    }
}


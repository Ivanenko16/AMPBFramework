package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverManager.getDriver;

public class YourBasketPage extends AbstractFragment {

    @FindBy(xpath = "//a[@class='checkout-btn btn optimizely-variation-1 original-bucket']")
    WebElement checkoutButton;

    public void navigateToPaymentDetailsPage() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
    }
}

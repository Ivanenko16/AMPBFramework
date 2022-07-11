package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverManager.getDriver;

public class BasketPage extends AbstractFragment {

    @FindBy(xpath = "//a[@class='checkout-btn btn optimizely-variation-1 original-bucket']")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@class='delivery-text']/dd")
    WebElement deliveryCost;

    @FindBy(xpath = "//*[@class='total']/dd")
    WebElement total;

    public void navigateToPaymentDetailsPage() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
    }

    public String getDeliveryCost(){
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(deliveryCost));
        return getText(deliveryCost);
    }

    public String getTotal(){
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(total));
        return getText(total);
    }
}

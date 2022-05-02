package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverManager.getDriver;

public class PaymentDetailsPage extends AbstractFragment {

    @FindBy(xpath = "//strong[text()='Sub-total']/../following-sibling::dd")
    WebElement subTotal;

    @FindBy(xpath = "//strong[text()='Total']/../following-sibling::dd")
    WebElement total;

    @FindBy(xpath = "//strong[text()='VAT']/../following-sibling::dd")
    WebElement vat;

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
}

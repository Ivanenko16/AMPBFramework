package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static configuration.driver.DriverManager.getDriver;
import static constants.Constants.KRUIDVAT_URL;

public class KruidvatMainPage extends AbstractFragment {

    @FindBy(className = "minicart__basket")
    WebElement cart;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookiesButton;

    public void navigateToCart() {
        click(acceptCookiesButton);
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(cart));
        click(cart);
        new KruidvatCartPage();
    }

    public void openMainPage() {
        open(KRUIDVAT_URL);
    }
}

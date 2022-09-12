package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import configuration.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class KruidvatCartPage extends AbstractFragment {

    @FindBy(className = "product-summary__wrapper")
    WebElement productImage;

    @FindBy(xpath = "//*[contains(@href, '/p/2876350')]")
    WebElement productHref;

    public void moveCursorToProduct() {
        new Actions(DriverManager.getDriver())
                .moveToElement(productImage)
                .pause(Duration.ofSeconds(1))
                .perform();
    }

    public Boolean isProductAdded() {
        return productHref.isEnabled();
    }

}

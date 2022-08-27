package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.Constants.KRUIDVAT_URL;

public class KruidvatMainPage extends AbstractFragment {

    @FindBy(className = "minicart__basket")
    WebElement cart;

    public void navigateToTheCart() {
        click(cart);
        new KruidvatCartPage();
    }

    public void openMainPage() {
        open(KRUIDVAT_URL);
    }
}

package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import configuration.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class KruidvatCartPage extends AbstractFragment {

    @FindBy(className = "d-flex")
    WebElement productImage;

    @FindBy(xpath = "//*[contains(@href, '/p/2876350')] ")
    WebElement productHref;

    public void moveCursorToProduct() {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(productImage);
        action.perform();
    }

    public String getProductHref(){
       return getText(productHref);
    }

}

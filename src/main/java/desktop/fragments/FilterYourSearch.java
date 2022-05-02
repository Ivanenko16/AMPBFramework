package desktop.fragments;

import abstractclasses.fragment.AbstractFragment;
import desktop.pages.BestsellersPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterYourSearch extends AbstractFragment {

    private static final String PRICE_RANGE_ALL = "All";
    private static final String PRICE_RANGE_UNDER_15 = "Under €15";
    private static final String PRICE_RANGE_15_30 = "€15 to €30";
    private static final String PRICE_RANGE_OVER_30 = "€30 +";

    @FindBy(xpath = "//select[@name='price']/option")
    private List<WebElement> priceRangeField;

    @FindBy(xpath = "//*[contains(text(),'Refine results')]")
    private WebElement refineResultsButton;

    public void selectPriceRange(String price) {
        if (PRICE_RANGE_ALL.equals(price)) {
            priceRangeField.get(0).click();
        } else if (PRICE_RANGE_UNDER_15.equals(price)) {
            priceRangeField.get(1).click();
        } else if (PRICE_RANGE_15_30.equals(price)) {
            priceRangeField.get(2).click();
        } else if (PRICE_RANGE_OVER_30.equals(price)) {
            priceRangeField.get(3).click();
        }
        new BestsellersPage();
    }

    public void refineResults() {
        click(refineResultsButton);
    }
}

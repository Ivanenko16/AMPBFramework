package desktop.fragments;

import abstractclasses.fragment.AbstractFragment;
import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FilterYourSearch extends AbstractFragment {

    private static final String PRICE_RANGE_ALL = "All";
    private static final String PRICE_RANGE_UNDER_15 = "Under €15";
    private static final String PRICE_RANGE_15_30 = "€15 to €30";
    private static final String PRICE_RANGE_OVER_30 = "30 € +";
    private static final String AVAILABILITY_ALL = "All";
    private static final String AVAILABILITY_IN_STOCK = "In Stock";
    private static final String LANGUAGE_ALL = "All";
    private static final String LANGUAGE_ENGLISH = "English";
    private static final String LANGUAGE_ITALIAN = "Italian";
    private static final String LANGUAGE_POLISH = "Polish";
    private static final String LANGUAGE_CHINESE = "Chinese";
    private static final String FORMAT_ALL = "Chinese";
    private static final String FORMAT_PAPERBACK = "Paperback";
    private static final String FORMAT_HARDBACK = "Hardback";
    private static final String FORMAT_DIGITAL = "Digital";

    @FindBy(xpath = "//select[@name='price']/option")
    private List<WebElement> priceRangeField;

    @FindBy(xpath = "//*[contains(text(),'Refine results')]")
    private WebElement refineResultsButton;

    @FindBy(xpath = "//select[@name='availability']/option")
    private List<WebElement> availabilityRangeField;

    @FindBy(xpath = "//select[@name='searchLang']/option")
    private List<WebElement> languageRangeField;

    @FindBy(xpath = "//select[@name='format']/option")
    private List<WebElement> formatRangeField;

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
    }

    public void selectAvailabilityRange(String availability) {
        if (availability.contains(AVAILABILITY_ALL)) {
            availabilityRangeField.get(0).click();
        } else if (availability.contains(AVAILABILITY_IN_STOCK)) {
            availabilityRangeField.get(1).click();
        }
    }

    public void selectLanguageRange(String language) {
        if (language.contains(LANGUAGE_ALL)) {
            languageRangeField.get(0).click();
        } else if (language.contains(LANGUAGE_ENGLISH)) {
            languageRangeField.get(1).click();
        } else if (language.contains(LANGUAGE_ITALIAN)) {
            languageRangeField.get(2).click();
        } else if (language.contains(LANGUAGE_CHINESE)) {
            languageRangeField.get(3).click();
        } else if (language.contains(LANGUAGE_POLISH)) {
            languageRangeField.get(4).click();
        }
    }

    public void selectFormatRange(String format) {
        if (format.contains(FORMAT_ALL)) {
            formatRangeField.get(0).click();
        } else if (format.contains(FORMAT_PAPERBACK)) {
            formatRangeField.get(1).click();
        } else if (format.contains(FORMAT_HARDBACK)) {
            formatRangeField.get(2).click();
        } else if (format.contains(FORMAT_DIGITAL)) {
            formatRangeField.get(3).click();
        }
    }

    public void selectFilter(String filterName, String range) {
        switch (filterName) {
            case ("Price range"):
                selectPriceRange(range);
                break;
            case ("Availability"):
                selectAvailabilityRange(range);
                break;
            case ("Language"):
                selectLanguageRange(range);
                break;
            case ("Format"):
                selectFormatRange(range);
                break;
        }
    }

    public void refineResults() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(refineResultsButton));
        click(refineResultsButton);
    }
}

package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

import static constants.Constants.EPAM_CONTACT_PAGE;
import static constants.RegexExpression.*;
import static utils.RegexUtil.getStringByPattern;

public class EpamContactPage extends AbstractFragment {

    @FindBy(xpath = "//*[@class='font-size-22']")
    private static WebElement address;

    public void openEpamContactPage() {
        open(EPAM_CONTACT_PAGE);
    }

    public String getAddressText() {
        return address.getText();
    }

    public String getBuildNumber() {
        return getStringByPattern(BUILD_NUMBER, getAddressText());
    }

    public String getStreetName() {
        return getStringByPattern(STREET_NAME, getAddressText());
    }

    public String getOfficeNumber() {
        return getStringByPattern(OFFICE_NUMBER, getAddressText());
    }

    public String getTownName() {
        return Objects.requireNonNull(getStringByPattern(TOWN_NAME, getAddressText())).trim();
    }

    public String getPostIndex() {
        return getStringByPattern(POST_INDEX, getAddressText());
    }

    public String getCountryName() {
        return getStringByPattern(COUNTRY_NAME, getAddressText());
    }

    @Override
    public String toString() {
        return "Build number: " + getBuildNumber() + "\n" +
                "Street name: " + getStreetName() + "\n" +
                "Office number: " + getOfficeNumber() + "\n" +
                "Town name: " + getTownName() + "\n" +
                "Post index: " + getPostIndex() + "\n" +
                "Country name: " + getCountryName();
    }
}

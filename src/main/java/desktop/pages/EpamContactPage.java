package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.Constants.EPAM_CONTACT_PAGE;
import static constants.RegexExpression.*;

public class EpamContactPage extends AbstractFragment {

    @FindBy(xpath = "//*[@class='font-size-22']")
    private static WebElement address;

    public void openEpamContactPage() {
        open(EPAM_CONTACT_PAGE);
    }

    public String getAddressText() {
        return address.getText();
    }

    private static String patternMatcher(String pattern, String matcher) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(matcher);
        if (m.find()) {
            return m.group();
        } else {
            return null;
        }
    }

    public String getBuildNumber() {
        return patternMatcher(BUILD_NUMBER, getAddressText());
    }

    public String getStreetName() {
        return patternMatcher(STREET_NAME, getAddressText());
    }

    public String getOfficeNumber() {
        return patternMatcher(OFFICE_NUMBER, getAddressText());
    }

    public String getTownName() {
        return Objects.requireNonNull(patternMatcher(TOWN_NAME, getAddressText())).trim();
    }

    public String getPostIndex() {
        return patternMatcher(POST_INDEX, getAddressText());
    }

    public String getCountryName() {
        return patternMatcher(COUNTRY_NAME, getAddressText());
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

package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractFragment {

    @FindBy(name = "searchTerm")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='header-search-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class='desktop-only']/span")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//*[@role='alert']/div")
    private WebElement successAlert;

    public void searchForTerms(String bookName) {
        searchField.sendKeys(bookName);
        searchButton.click();
    }

    public void navigateToThePage(String page) {
        findElement(By.xpath(String.format("//a[text()='%s']", page))).click();
    }

    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }

    public Boolean successAlertIsDisplayed() {
        boolean isDisplayed;
        isDisplayed = isDisplayed(successAlert);
        return isDisplayed;
    }
}

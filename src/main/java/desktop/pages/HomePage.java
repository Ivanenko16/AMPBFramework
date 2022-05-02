package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractFragment {

    @FindBy(name = "searchTerm")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='header-search-btn']")
    private WebElement searchButton;

    public void searchForTerms(String bookName) {
        searchField.sendKeys(bookName);
        searchButton.click();
    }
}

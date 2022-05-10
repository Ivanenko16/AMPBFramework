package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverManager.getDriver;

public class SearchResultPage extends AbstractFragment {

    @FindBy(xpath = "//a[text()='Basket / Checkout']")
    private WebElement basketCheckoutButton;

    @FindBy(xpath = "//*[@class='sale-price']")
    private WebElement priceFirstBook;

    @FindBy(xpath = "//*[contains(text(),'Add to basket')]")
    private WebElement addToBasketButtonFirstBook;

    public void navigateToYourBasketPage() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(basketCheckoutButton));
        basketCheckoutButton.click();
    }

    public void addFirstBookToBasket() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addToBasketButtonFirstBook));
        addToBasketButtonFirstBook.click();
    }

    public String getPriceFirstBook() {
        return priceFirstBook.getText();
    }
}

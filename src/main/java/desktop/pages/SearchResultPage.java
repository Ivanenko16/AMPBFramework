package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverManager.getDriver;

public class SearchResultPage extends AbstractFragment {

    @FindBy(xpath = "//a[text()='Basket / Checkout']")
    private WebElement basketCheckoutButton;

    @FindBy(xpath = "//*[@class='sale-price']")
    private WebElement priceFirstBook;

    @FindBy(xpath = "//*[contains(text(),'Add to basket')]")
    private WebElement addToBasketButtonFirstBook;

    @FindBy(xpath = "//*[@class='title']/a")
    private List<WebElement> listBooks;

    public void navigateToYourBasketPage() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(basketCheckoutButton));
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

    public List<String> getTitleAllBooks() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("return document.readyState");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return listBooks.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void addToBasket(String book) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .elementToBeClickable(findElement(By.xpath(String.format("//*[@class='title']/a[contains(text(), '%s')]/ancestor::div/div[@class='item-actions']/descendant::a", book)))))
                .click();
    }

    public void interactModalWindow(String button) throws InterruptedException {
        Thread.sleep(500);
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(findElement(By.xpath(String.format("//a[text()='%s']", button))))).click();
    }

}

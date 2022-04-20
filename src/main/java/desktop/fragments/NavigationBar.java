package desktop.fragments;

import abstractclasses.fragment.AbstractFragment;
import desktop.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;

public class NavigationBar extends AbstractFragment {

    private static final By navigationBarElement = new By.ByXPath("//*[@class='user-nav']");
    private static final String TEXT_PATTERN = "//a[text()='%s']";

    @FindBy(xpath = "//*[@class='icon-home']")
    private WebElement homeIcon;

    @FindBy(xpath = "//a[text()='Contact us']")
    private WebElement contactUsIcon;

    @FindBy(xpath = "//a[text()='Help']")
    private WebElement helpIcon;

    @FindBy(xpath = "//a[text()='Order Status']")
    private WebElement orderStatusIcon;

    @FindBy(xpath = "//a[text()='Wishlist']")
    private WebElement wishlistIcon;

    @FindBy(xpath = "//a[text()='Sign in/Join']")
    private WebElement signInIcon;

    public static By getNavigationBarElement() {
        return navigationBarElement;
    }

    public WebElement getIcon(String linkText) {
        return findElement(By.xpath(format(TEXT_PATTERN, linkText)));
    }

    public BookDepositoryHomePage navigateToHomePage() {
        homeIcon.click();
        return new BookDepositoryHomePage();
    }

    public BookDepositoryContactUsPage navigateToContactUsPage() {
        contactUsIcon.click();
        return new BookDepositoryContactUsPage();
    }

    public BookDepositoryHelpPage navigateToHelpPage() {
        helpIcon.click();
        return new BookDepositoryHelpPage();
    }

    public BookDepositoryOrderStatusPage navigateToOrderStatusPage() {
        orderStatusIcon.click();
        return new BookDepositoryOrderStatusPage();
    }

    public BookDepositoryWishListPage navigateToWishListPage() {
        wishlistIcon.click();
        return new BookDepositoryWishListPage();
    }

    public BookDepositorySignInPage navigateToSignInPage() {
        signInIcon.click();
        return new BookDepositorySignInPage();
    }
}


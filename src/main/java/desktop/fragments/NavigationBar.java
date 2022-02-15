package desktop.fragments;

import abstractclasses.fragment.AbstractFragment;
import desktop.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractFragment {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    private static final By navigationBarElement = new By.ByXPath("//*[@class='user-nav']");

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

    public void navigateToHomePage() {
        homeIcon.click();
        new BookDepositoryHomePage(driver);
    }

    public void navigateToContactUsPage() {
        contactUsIcon.click();
        new BookDepositoryContactUsPage(driver);
    }

    public void navigateToHelpPage() {
        helpIcon.click();
        new BookDepositoryHelpPage(driver);
    }

    public void navigateToOrderStatusPage() {
        orderStatusIcon.click();
        new BookDepositoryOrderStatusPage(driver);
    }

    public void navigateToWishListPage() {
        wishlistIcon.click();
        new BookDepositoryWishListPage(driver);
    }

    public void navigateToSignInPage() {
        signInIcon.click();
        new BookDepositorySignInPage(driver);
    }
}


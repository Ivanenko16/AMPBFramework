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

    public BookDepositoryHomePage navigateToHomePage() {
        homeIcon.click();
        return new BookDepositoryHomePage(driver);
    }

    public BookDepositoryContactUsPage navigateToContactUsPage() {
        contactUsIcon.click();
        return new BookDepositoryContactUsPage(driver);
    }

    public BookDepositoryHelpPage navigateToHelpPage() {
        helpIcon.click();
        return new BookDepositoryHelpPage(driver);
    }

    public BookDepositoryOrderStatusPage navigateToOrderStatusPage() {
        orderStatusIcon.click();
       return new BookDepositoryOrderStatusPage(driver);
    }

    public BookDepositoryWishListPage navigateToWishListPage() {
        wishlistIcon.click();
        return new BookDepositoryWishListPage(driver);
    }

    public BookDepositorySignInPage navigateToSignInPage() {
        signInIcon.click();
        return new BookDepositorySignInPage(driver);
    }
}


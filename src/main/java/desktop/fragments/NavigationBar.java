package desktop.fragments;

import abstractclasses.fragment.AbstractFragment;
import desktop.pages.BookDepositoryHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractFragment {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='user-nav-wrap ']")
    private static WebElement navigationBarElement;

    @FindBy(xpath = "div[@class='user-nav']i[@class='icon-home']")
    private WebElement homeIcon;

    @FindBy(xpath = "div[@class='user-nav']a[@href='contactus']")
    private WebElement contactUsIcon;

    @FindBy(xpath = "div[@class='user-nav']a[@href='help']")
    private WebElement helpIcon;

    @FindBy(xpath = "div[@class='user-nav']a[@href='track']")
    private WebElement orderStatusIcon;

    @FindBy(xpath = "div[@class='user-nav']a[@href='accountwishlist']")
    private WebElement wishlistIcon;

    @FindBy(xpath = "div[@class='user-nav']a[text()='Sign inJoin']")
    private WebElement signInIcon;

    public static WebElement getNavigationBarElement() {
        return navigationBarElement;
    }

    public void navigateToHomePage(){
        homeIcon.click();
        new BookDepositoryHomePage(driver);
    }
}

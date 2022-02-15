package runner;

import desktop.pages.BookDepositoryLoginPage;
import driver.SingletonDriver;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

import static constants.Constants.*;

public class TestRunner {

    static WebDriver driver = SingletonDriver.getWebDriverInstance();

    @Test
    public void clearEmailButtonIsAppeared() {

        new BookDepositoryLoginPage(driver)
                .openBookDepositoryLoginPage()
                .switchToLogInFrame()
                .setEmail("tractor@gmail.com");

        String style = BookDepositoryLoginPage.getStyleClearEmailButton();

        Assert.assertEquals("display: block;", style);
    }

    @Test
    public void navigateToHomePage() {
        new BookDepositoryLoginPage(driver)
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToHomePage();

        String url = driver.getCurrentUrl();

        Assert.assertEquals(HOME_URL, url);
    }

    @Test
    public void navigateToHelpPage() {
        new BookDepositoryLoginPage(driver)
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToHelpPage();

        String url = driver.getCurrentUrl();

        Assert.assertEquals(HELP_URL, url);
    }

    @Test
    public void navigateToContactUsPage() {
        new BookDepositoryLoginPage(driver)
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToContactUsPage();

        String url = driver.getCurrentUrl();

        Assert.assertEquals(CONTACT_URL, url);
    }

    @Test
    public void navigateToOrderStatusPage() {
        new BookDepositoryLoginPage(driver)
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToOrderStatusPage();

        String url = driver.getCurrentUrl();

        Assert.assertEquals(TRACK_URL, url);
    }

    @Test
    public void navigateToWishListPage() {
        new BookDepositoryLoginPage(driver)
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToWishListPage();

        String url = driver.getCurrentUrl();

        Assert.assertEquals(WISH_URL, url);
    }

    @Test
    public void navigateToSignInPage() {
        new BookDepositoryLoginPage(driver)
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToSignInPage();

        String url = driver.getCurrentUrl();

        Assert.assertEquals(LOGIN_URL, url);
    }


    @AfterAll
    static void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
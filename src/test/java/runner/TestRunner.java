package runner;

import desktop.pages.BookDepositoryLoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static constants.Constants.*;
import static driver.DriverManager.quitDriver;

public class TestRunner {

    BookDepositoryLoginPage bookDepositoryLoginPage = new BookDepositoryLoginPage();

    @Test
    public void clearEmailButtonIsAppeared() {
        bookDepositoryLoginPage.openBookDepositoryLoginPage()
                .switchToLogInFrame();
        bookDepositoryLoginPage.fillField("Email");
        Assert.assertTrue(bookDepositoryLoginPage.clearButtonIsDisplayed("Email"));
    }

    @Test
    public void navigateToHomePage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToHomePage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", HOME_URL, url);
    }

    @Test
    public void navigateToHelpPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToHelpPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", HELP_URL, url);
    }

    @Test
    public void navigateToContactUsPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToContactUsPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", CONTACT_URL, url);
    }

    @Test
    public void navigateToOrderStatusPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToOrderStatusPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", TRACK_URL, url);
    }

    @Test
    public void navigateToWishListPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToWishListPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", WISH_URL, url);
    }

    @Test
    public void navigateToSignInPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToSignInPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", LOGIN_URL, url);
    }

    @After
    public void browserTearDown() {
        quitDriver();
    }
}
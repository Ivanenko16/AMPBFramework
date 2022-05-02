package runner;

import desktop.pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static constants.Constants.*;
import static driver.DriverManager.quitDriver;

public class TestRunner {

    LoginPage loginPage = new LoginPage();

    @Test
    public void clearEmailButtonIsAppeared() {
        loginPage.openBookDepositoryLoginPage()
                .switchToLogInFrame();
        loginPage.fillField("Email");
        Assert.assertTrue(loginPage.clearButtonIsDisplayed("Email"));
    }

    @Test
    public void navigateToHomePage() {
        String url = loginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToHomePage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", HOME_URL, url);
    }

    @Test
    public void navigateToHelpPage() {
        String url = loginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToHelpPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", HELP_URL, url);
    }

    @Test
    public void navigateToContactUsPage() {
        String url = loginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToContactUsPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", CONTACT_URL, url);
    }

    @Test
    public void navigateToOrderStatusPage() {
        String url = loginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToOrderStatusPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", TRACK_URL, url);
    }

    @Test
    public void navigateToWishListPage() {
        String url = loginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToWishListPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null", WISH_URL, url);
    }

    @Test
    public void navigateToSignInPage() {
        String url = loginPage
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
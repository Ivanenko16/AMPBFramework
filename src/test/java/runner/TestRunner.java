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
    BookDepositoryLoginPage bookDepositoryLoginPage = new BookDepositoryLoginPage(driver);

    @Test
    public void clearEmailButtonIsAppeared() {
        String style = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .switchToLogInFrame()
                .setEmail("tractor@gmail.com")
                .getStyleClearEmailButton();

        Assert.assertEquals("No button", "display: block;", style);
    }

    @Test
    public void navigateToHomePage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToHomePage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null",HOME_URL, url);
    }

    @Test
    public void navigateToHelpPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToHelpPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null",HELP_URL, url);
    }

    @Test
    public void navigateToContactUsPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToContactUsPage()
                .getCurrentUrl();

        Assert.assertEquals(CONTACT_URL, url);
    }

    @Test
    public void navigateToOrderStatusPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToOrderStatusPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null",TRACK_URL, url);
    }

    @Test
    public void navigateToWishListPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToWishListPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null",WISH_URL, url);
    }

    @Test
    public void navigateToSignInPage() {
        String url = bookDepositoryLoginPage
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToSignInPage()
                .getCurrentUrl();

        Assert.assertEquals("URL invalid or null",LOGIN_URL, url);
    }

    @AfterAll
    static void browserTearDown() {
        driver.quit();
    }
}
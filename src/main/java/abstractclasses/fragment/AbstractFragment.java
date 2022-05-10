package abstractclasses.fragment;

import desktop.fragments.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static driver.DriverManager.getDriver;

public abstract class AbstractFragment {

    protected AbstractFragment() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getUrl(WebElement element) {
        return element.getAttribute("href");
    }

    public void open(String url) {
        getDriver().get(url);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void typeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public Boolean isDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

    public void switchToIframe(WebElement webElement) {
        getDriver().switchTo().frame(webElement);
    }

    public NavigationBar getNavigationBar() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(NavigationBar.getNavigationBarElement()));
        return new NavigationBar();
    }
}

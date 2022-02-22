package abstractclasses.page;

import desktop.fragments.NavigationBar;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {

    protected AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        DriverManager.getDriver().get(url);
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
        return DriverManager.getDriver().getCurrentUrl();
    }

    public WebElement findElement(By by){
        return DriverManager.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by){
        return DriverManager.getDriver().findElements(by);
    }

    public NavigationBar getNavigationBar() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(NavigationBar.getNavigationBarElement()));
        return new NavigationBar(DriverManager.getDriver());
    }

}


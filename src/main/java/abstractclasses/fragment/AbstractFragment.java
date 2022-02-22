package abstractclasses.fragment;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractFragment {

    protected AbstractFragment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(By by){
        return DriverManager.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by){
        return DriverManager.getDriver().findElements(by);
    }

    public String getUrl(WebElement element) {
        return element.getAttribute("href");
    }
}

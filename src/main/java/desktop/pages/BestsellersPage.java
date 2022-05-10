package desktop.pages;

import abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.stream.Stream;

import static constants.Constants.ONLY_NUMBER;

public class BestsellersPage extends AbstractFragment {

    @FindBy(xpath = "//*[@class='price']")
    private List<WebElement> bookPrices;

    @FindBy(xpath = "//div/h3[@class='title']/a")
    private List<WebElement> bookTitles;

    public Map<String, Double> getAllBooks() {
        Map<String, Double> listOfBooks = new HashMap<>();
        for (int i = 0; i < bookTitles.size(); i++) {

            String bookTitle = getText(bookTitles.get(i));
            String bookPrice = Stream.of(getText(bookPrices.get(i))
                            .replaceAll(ONLY_NUMBER, " ")
                            .trim()
                            .split(" "))
                    .map(String::trim)
                    .filter(val -> !val.isEmpty())
                    .findFirst()
                    .orElse("");

            listOfBooks.put(bookTitle, Double.parseDouble(bookPrice));
        }
        return listOfBooks;
    }
}

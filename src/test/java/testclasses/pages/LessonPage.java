package testclasses.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;
import java.util.Random;

public class LessonPage {

    public final WebDriver driver;
    public LessonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    String[] words = {"needless to say", "overestimate", "crystal clear", "strong point", "stable", "insist", "blunder"};
    String[] pages = {"Демонстрация", "Объяснение", "Словарь", "Многовариантный выбор", "Расстановка", "Сопоставление", "Заполните пустые поля"};

    Random rand = new Random();

    String bufferPage = "";

    @FindBy(xpath = "//div[contains(text(), 'Словарь')]/parent::div")
    private WebElement dictionary;

    public void goToDictionary() {
        dictionary.click();
    }

    public void doRandomThings() throws InterruptedException {
        while (true) {
            int clicksQuantity = rand.nextInt(20);
            for (int i = 0; i < clicksQuantity; ++i) {
                String page = pages[rand.nextInt(pages.length)];
                while (Objects.equals(page, bufferPage)) {
                    page = pages[rand.nextInt(pages.length)];
                }
                WebElement pageToClick = driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]/parent::div", page)));
                pageToClick.click();
                bufferPage = page;
                synchronized (driver) {
                    driver.wait(5000);
                }
                if (Objects.equals(page, "Словарь")) {
                    clicksQuantity = rand.nextInt(20);
                    for (int j = 0; j < clicksQuantity; ++j) {
                        String word = words[rand.nextInt(words.length)];
                        WebElement wordToClick = driver.findElement(By.xpath(String.format("(//span[contains(text(), '%s')])[position()=1]", word)));
                        wordToClick.click();
                        synchronized (driver) {
                            driver.wait(5000);
                        }
                    }
                }
            }
        }
    }

}

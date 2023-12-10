package testclasses.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainRosettaPage {

    public WebDriver driver;
    public MainRosettaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(text(), 'Succeed')]/following-sibling::div[last()]")
    private WebElement lessonContinueButton;

    @FindBy(xpath = "//div[contains(text(), 'Interrupting')]/following-sibling::div[last()]")
    private WebElement concreteLesson;

    public void continueLesson() {
        lessonContinueButton.click();
        concreteLesson.click();
    }
}

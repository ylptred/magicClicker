package testclasses.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    public WebDriver driver;
    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@data-qa='dismissOptionalTrigger']")
    private WebElement modalCloseButton;

    @FindBy(xpath = "//*[text()='Fluency Builder']")
    private WebElement goToRosettaButton;

    public void closeModal() {
        modalCloseButton.click();
    }

    public void goToMainRosetta() {
        goToRosettaButton.click();
    }
}

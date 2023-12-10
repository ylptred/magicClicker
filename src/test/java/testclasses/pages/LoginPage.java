package testclasses.pages;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='userNameInput']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='passwordInput']")
    private WebElement passField;

    @FindBy(xpath = "//span[@id='submitButton']")
    private WebElement loginDataApplyButton;

    public void auth(String login, String pass) {
        loginField.sendKeys(login);
        passField.sendKeys(pass);
        loginDataApplyButton.click();
    }

}

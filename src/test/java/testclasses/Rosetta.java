package testclasses;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testclasses.pages.LessonPage;
import testclasses.pages.LoginPage;
import testclasses.pages.MainRosettaPage;
import testclasses.pages.StartPage;

import java.util.concurrent.TimeUnit;

public class Rosetta {

    public static LoginPage loginpage;
    public static StartPage startpage;
    public static MainRosettaPage mainRosettaPage;
    public static LessonPage lessonPage;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        startpage = new StartPage(driver);
        mainRosettaPage = new MainRosettaPage(driver);
        lessonPage = new LessonPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void rosettaTest() throws InterruptedException {
        loginpage.auth(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));
        startpage.closeModal();
        startpage.goToMainRosetta();
        mainRosettaPage.continueLesson();
        lessonPage.goToDictionary();
        lessonPage.doRandomThings();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

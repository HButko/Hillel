package lessons.lessonOne;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @Test
    public void firstTest() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.timeout = Duration.ofSeconds(10).toMillis();

//        Configuration.browser = SpecificDriver.class.getName();
        //third option to initialize driver - for specific drivers

//        WebDriver driver = new ChromeDriver();
//        WebDriverRunner.setWebDriver(driver);
        //second option to initialize driver - for migration between Selenium & Selenide

//        Configuration.browser = "firefox";
        //first option to initialize driver - usual way

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        Configuration.browserCapabilities = options;

        Configuration.browserVersion = "118";
        Configuration.headless = true;

        open("/");
        sleep(3000);
//        closeWebDriver();
        open("/dynamic_content");
        sleep(3000);

//        driver.quit();
        //second option - closing driver
    }
}

package homework;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HomeWorkOne {
    String url = "https://the-internet.herokuapp.com/javascript_alerts";

    @Test
    public void alertTest(){
        open(url);

        $$("button")
                .find(exactText("Click for JS Alert"))
                .click();

        String confirmText = confirm();
        assertThat(confirmText)
                .isEqualTo("I am a JS Alert");

        assertThat($("#result")
                .text())
                .isEqualTo("You successfully clicked an alert");
    }

    @Test
    public void confirmTest(){
        open(url);

        $$("button")
                .find(exactText("Click for JS Confirm"))
                .click();

        String confirmText = dismiss();
        assertThat(confirmText)
                .isEqualTo("I am a JS Confirm");

        assertThat($("#result")
                .text())
                .isEqualTo("You clicked: Cancel");
    }

    @Test
    public void promptTest(){
        open(url);
        String text = "Test message";

        $$("button")
                .find(exactText("Click for JS Prompt"))
                .click();

        Alert alert = switchTo().alert();
        alert.sendKeys(text);

        String confirmText = confirm();
        assertThat(confirmText)
                .isEqualTo("I am a JS prompt");

        assertThat($("#result")
                .text())
                .isEqualTo("You entered: Test message");
    }

    @Test
    public void confirmViaJsClickTest(){
        open(url);

        SelenideElement element = $$("button")
                .find(exactText("Click for JS Confirm"));

        element.click(ClickOptions.usingJavaScript());

        String confirmText = confirm();
        assertThat(confirmText)
                .isEqualTo("I am a JS Confirm");

        assertThat($("#result")
                .text())
                .isEqualTo("You clicked: Ok");
    }

    @Test
    public void confirmViaJsExecutorTest(){
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement element = $$("button")
                .find(exactText("Click for JS Confirm"));

        js.executeScript("arguments[0].click();", element);

        String confirmText = confirm();
        assertThat(confirmText)
                .isEqualTo("I am a JS Confirm");

        String text = js.executeScript("return document.getElementById('result').innerHTML").toString();
        System.out.println("Result is - " + text);

        driver.close();
        driver.quit();
    }
}

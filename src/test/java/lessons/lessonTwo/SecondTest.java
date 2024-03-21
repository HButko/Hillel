package lessons.lessonTwo;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static lessons.lessonThree.CustomConditions.notVisible;
import static lessons.lessonThree.CustomConditions.urlEndsWith;
import static org.assertj.core.api.Assertions.assertThat;

public class SecondTest {

    @Test
    public void secondTest() {
        Configuration.clickViaJs = true;

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> selenoidProperties = new HashMap<>();
        selenoidProperties.put("enableVnc", true);
        options.setCapability("selenoid:options", selenoidProperties);
        Configuration.browserCapabilities = options;

        Configuration.remote = "http://localhost:4444/wd/hub";

        open("https://the-internet.herokuapp.com/javascript_alerts");
        sleep(2000);

        webdriver().shouldHave(urlEndsWith("/javascript-alerts"));

//        $x("//button[text()='Click for JS Alert']");
        //xPath version

        $$("button")
                .find(exactText("Click for JS Alert"))
                .shouldBe(notVisible)
                .click();

        String confirmText = confirm();
        sleep(2000);

        assertThat(confirmText).isEqualTo("I am a JS Confirm");
        assertThat($("#result").text()).isEqualTo("You successfully clicked an alert");
        sleep(2000);
    }
}

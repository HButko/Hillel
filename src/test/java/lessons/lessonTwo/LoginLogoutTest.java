package lessons.lessonTwo;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class LoginLogoutTest {
    @Test
    public void loginTest() {
        Configuration.timeout = 10000;

//        $("#username");
//        $(By.id("username"));
        SelenideElement userNameInput = $(byId("username"));
        SelenideElement userPasswordInput = $("[name=password]");
        SelenideElement loginButton = $x("//button[@class='radius']");

        open("https://the-internet.herokuapp.com/login");

        userNameInput.setValue("tomsmith");
        userPasswordInput.setValue("SuperSecretPassword!");
        loginButton.click();

        $("div#flash.flash.success")
                .shouldBe(visible)
                .shouldHave(partialText("You logged into a secure area!"));
    }
}

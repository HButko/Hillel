package lessons.lessonThree;

import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.conditions.webdriver.UrlCondition;

public class CustomConditions {
    public static WebElementCondition notVisible = new NotVisibleCondition();

    public static UrlCondition urlEndsWith(String url){
        return new UrlEndsWith(url);
    }
}

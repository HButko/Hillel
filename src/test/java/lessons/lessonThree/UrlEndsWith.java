package lessons.lessonThree;

import com.codeborne.selenide.conditions.webdriver.UrlCondition;

public class UrlEndsWith extends UrlCondition {
    protected UrlEndsWith(String expectedUrl) {
        super("ending with", expectedUrl);
    }

    @Override
    protected boolean test(String url) {
        return url.endsWith(expectedUrl);
    }
}

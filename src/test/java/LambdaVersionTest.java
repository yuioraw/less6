
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaVersionTest {
    //переменные
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 68;

    @Test
    public void testWithLambda() {

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Поиск репозитория" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Находим Issues с номером" + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });

    }

    @Test
    public void annotatedStepsTest() {
        WebStepsTest steps = new WebStepsTest();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER);

    }
}




package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.*;

public class MainTest {

    @BeforeAll
    static void beforeAll() {
        //        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    void setUp() {
        open("https://github.com/");
        $("input[name='q']").setValue("selenide").submit();
        $(linkText("selenide/selenide")).click();
        $("#wiki-tab").click();
        $(withText("more pages")).click();
    }

    @Test
    @DisplayName("Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions")
    void checkSoftAssertionsExistOnPagesList() {
        $("#wiki-pages-box.wiki-pages-box").shouldHave(text("SoftAssertions"));
    }

    @Test
    @DisplayName("Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5")
    void checkJUnit5ExampleOnSoftAssertionsWebPage() {
        $("#wiki-pages-box.wiki-pages-box").find(linkText("SoftAssertions")).click();
        $(withText("Using JUnit5 extend test class"), 1).shouldBe(visible);

    }
}

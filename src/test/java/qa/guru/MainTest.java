package qa.guru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainTest {

    @Test
    void mainTest() {

        open("https://github.com/");
        $()

    }
}

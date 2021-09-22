package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.domain.MenuItem;
import guru.qa.pages.DnsMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DnsTests {

    private DnsMainPage page = new DnsMainPage();

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        0, "Бытовая техника"
                ),
                Arguments.of(
                        1, "Смартфоны и гаджеты"
                ),
                Arguments.of(
                        2, "ТВ и мультимедиа"
                ),
                Arguments.of(
                        3, "Компьютеры"
                )
        );
    }

    @CsvSource({
            "Бытовая техника",
            "Смартфоны и гаджеты",
            "ТВ и мультимедиа",
            "Компьютеры",
            "Офис и сеть"
    })

    @ParameterizedTest()
    @DisplayName("Open all tabs using csv source")
    void openTabsWithCSVSource(String tabName) {
        page.openMainPage()
                .choseTab(tabName)
                .checkTabName(tabName);
    }

    @EnumSource(value = MenuItem.class)
    @ParameterizedTest()
    @DisplayName("Open all tabs using enum source")
    void openTabsWithEnumSource(MenuItem menuItem) {
        page.openMainPage()
                .choseTab(menuItem.getDescription())
                .checkTabName(menuItem.getDescription());
    }

    @MethodSource("testWithMethodSource")
    @ParameterizedTest()
    @DisplayName("Open all tabs using item index and method source")
    void openTabsWithMethodSource(int number, String title) {
        Configuration.startMaximized = true;
        page.openMainPage()
                .clickItemWithNumber(number)
                .checkTabName(title);
    }
}

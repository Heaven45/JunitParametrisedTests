package guru.qa;

import guru.qa.pages.DnsMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DnsTests {

    String link = "https://journal.citilink.ru/";

    DnsMainPage page = new DnsMainPage();

    @CsvSource({
            "Бытовая техника",
            "Смартфоны и гаджеты",
            "ТВ и мультимедиа",
            "Компьютеры",
            "Офис и сеть"
    })

    @ParameterizedTest()
    @DisplayName("Open all tabs")
    void openTabs(String tabName) {
        page.openMainPage()
                .choseTab(tabName)
                .checkTabName(tabName);
    }


//
//
//    @EnumSource(value = {
//
//    })
//
//
//
//    @MethodSource(value = {
//
//    })

}
